package com.cad.carlink.weixin.controller;


import com.cad.carlink.common.base.ResponsePojo;
import com.cad.carlink.common.enums.ResponseCodeTypeEnum;
import com.cad.carlink.common.support.redis.RedisCacheUtil;
import com.cad.carlink.common.util.BeanUtils;
import com.cad.carlink.weixin.config.PropertiesConfig;
import com.cad.carlink.weixin.model.dto.req.*;
import com.cad.carlink.weixin.model.dto.resp.UserLoginRespDto;
import com.cad.carlink.weixin.model.dto.resp.WeiXinAccountInfoRespDto;
import com.cad.carlink.weixin.model.dto.resp.WeiXinUserRespDto;
import com.cad.carlink.weixin.service.IWeiXinAccSetService;
import com.cad.carlink.weixin.service.IWeiXinAccountService;
import com.cad.carlink.weixin.weixin.WechatMsgTempUtil;
import com.cad.carlink.weixin.weixin.WechatUtil;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/wx")
public class WeiXinAccountInfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    IWeiXinAccountService weiXinAccountService;

    @Autowired
    IWeiXinAccSetService weiXinAccSetService;


    @Autowired
    WechatMsgTempUtil tempUtil;

    @Autowired
    WechatUtil wechatUtil;


    @Autowired
    PropertiesConfig config;


    /**
     * weixin 首次验证登陆
     *
     * @param
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponsePojo<WeiXinUserRespDto> wxLogin(@RequestBody WeiXinLoginReqDto weiXinLoginReqDto) {
        if (StringUtils.isEmpty(weiXinLoginReqDto.getCode()) && StringUtils.isEmpty(weiXinLoginReqDto.getOpenid())) {
            return new ResponsePojo<>(ResponseCodeTypeEnum.PARAMETER_ERROR);
        }

        WeiXinAccountInfoReqDto wxAccountDto = new WeiXinAccountInfoReqDto();
        String openId = null;
        if (StringUtils.isNotEmpty(weiXinLoginReqDto.getOpenid())) {
            openId = weiXinLoginReqDto.getOpenid();
        } else if (StringUtils.isNotEmpty(weiXinLoginReqDto.getCode())) {
            WxMpUser user = wechatUtil.getUserInfoByCode(weiXinLoginReqDto.getCode());
            if (user == null) {
                return new ResponsePojo<>(ResponseCodeTypeEnum.USER_TIME_OUT);
            }
            openId = user.getOpenId();
        }


        wxAccountDto.setOpenid(openId);
        wxAccountDto.setValid(true);

        ResponsePojo<List<WeiXinAccountInfoRespDto>> responsePojo = weiXinAccountService.findList(wxAccountDto);
        if (responsePojo == null || !ResponseCodeTypeEnum.SUCCESS.getValue().equals(responsePojo.getCode())) {
            logger.error("获取微信账户信息数据失败");
            return new ResponsePojo<>(ResponseCodeTypeEnum.DATABASE_EXCEPTION);
        }
        List<WeiXinAccountInfoRespDto> wxAccountList = responsePojo.getObject();

        WeiXinUserRespDto userRespDto = new WeiXinUserRespDto();
        userRespDto.setOpenId(openId);

        if (CollectionUtils.isNotEmpty(wxAccountList)) {
            //已经绑定状态
            userRespDto.setCellPhone(wxAccountList.get(0).getCellphone());
            userRespDto.setIsBind(1);
            return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS, userRespDto);
        } else {
            //未绑定  返回空页面
            userRespDto.setIsBind(0);
            return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS, userRespDto);
        }
    }

    /**
     * 微信绑定账户
     *
     * @return
     */
    @RequestMapping(value = "/bindAccount", method = RequestMethod.POST)
    public ResponsePojo wxBindAccount(@RequestBody WeiXinAccountUserReqDto wxUserBindDto) {
        if (StringUtils.isEmpty(wxUserBindDto.getUsername())
                || StringUtils.isEmpty(wxUserBindDto.getOpenId())
                || StringUtils.isEmpty(wxUserBindDto.getPassword())
                || wxUserBindDto.getAreatype() == null) {
            return new ResponsePojo(ResponseCodeTypeEnum.PARAMETER_ERROR);
        }


        //校验用户名密码是否正确  路由
        UserLoginReqDto dto = new UserLoginReqDto();
        BeanUtils.copy(wxUserBindDto, dto);

        String appUrl = getPathByAreaType(String.valueOf(wxUserBindDto.getAreatype())) + "/wx/checkUserInfo";


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserLoginRespDto> responseDto = restTemplate.postForEntity(appUrl, dto, UserLoginRespDto.class);

        UserLoginRespDto userDto = responseDto.getBody();

        HttpStatus statusCode = responseDto.getStatusCode();
        String code = String.valueOf(statusCode.value());


        if (!code.equals("200") || !ResponseCodeTypeEnum.SUCCESS.getValue().equals(userDto.getCode())) {
            for (ResponseCodeTypeEnum enums : ResponseCodeTypeEnum.values()) {
                if (enums.getValue().equals(userDto.getCode())) {
                    return new ResponsePojo<>(enums);
                }
            }
        } else {
            Boolean bool = wxBindSuccess(wxUserBindDto, userDto.getUserid(), wxUserBindDto.getUsername());
            if (!bool) {
                return new ResponsePojo<>(ResponseCodeTypeEnum.FAIL);
            }
        }

        return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS);
    }

    /**
     * 根据areaType 获取路由
     *
     * @return
     */
    private String getPathByAreaType(String areaType) {
        String url = "";
        try {
            if (StringUtils.isNotEmpty(areaType)) {
                switch (areaType) {
                    case "1":
                        url = config.getValueByKey("hubei_app");
                        break;
                    case "2":
                        url = config.getValueByKey("hunan_app");
                        break;
                    case "3":
                        url = config.getValueByKey("henan_app");
                        break;
                    default:
                        logger.error("不存在省份信息");
                        break;
                }
            }
        } catch (Exception ex) {
            logger.error("根据区域编号获取路由到URL异常,e:{}" + ex.getMessage(), ex);
        }
        return url;
    }

    private Boolean wxBindSuccess(WeiXinAccountUserReqDto wxUserBindDto, Integer userId, String userName) {
        //微信账户update信息
        WxMpUser wxMpUser = RedisCacheUtil.getObject(wxUserBindDto.getOpenId(), WxMpUser.class);
        WeiXinAccountInfoReqDto po = new WeiXinAccountInfoReqDto();

        po.setUserid(userId);
        po.setOpenid(wxMpUser.getOpenId());
        Short sex = wxMpUser.getSexId() != null ? wxMpUser.getSexId().shortValue() : wxMpUser.getSexId().shortValue();
        po.setSex(sex);
        po.setValid(true);
        po.setCellphone(userName);
        po.setHeadimgurl(wxMpUser.getHeadImgUrl());
        po.setAreatype(wxUserBindDto.getAreatype());
        BeanUtils.copy(wxMpUser, po);

        ResponsePojo wxAccountRes = weiXinAccountService.bindAccount(po);
        if (!ResponseCodeTypeEnum.SUCCESS.getValue().equals(wxAccountRes.getCode())) {
            return false;
        }

        //默认设置推送报警
        WeiXinAccSetReqDto accSetPO = new WeiXinAccSetReqDto();
        accSetPO.setOpenid(wxUserBindDto.getOpenId());
        accSetPO.setUserid(userId);
        accSetPO.setAlarmstate(true);
        accSetPO.setWarningstate(false);

        ResponsePojo wxAccSetRes = weiXinAccSetService.insertByOpenId(accSetPO);
        if (!ResponseCodeTypeEnum.SUCCESS.getValue().equals(wxAccSetRes.getCode())) {
            logger.error("WeiXinAccSetService -> insertOneByOpenId 默认设置推送报警失败 ,msg:" + wxAccountRes.getMessage());
        }


        //success 推送通知模板
        WeiXinBindTempleReqDto vo = new WeiXinBindTempleReqDto();
        vo.setOpenId(wxUserBindDto.getOpenId());
        vo.setTellPhone(wxUserBindDto.getUsername());
        tempUtil.sendTempBindMsg(vo);

        return true;
    }

    /**
     * 解除微信绑定的账户
     */
    @RequestMapping(value = "/unBindAccount/{openId}", method = RequestMethod.GET)
    public ResponsePojo<Object> wxUnBindAccount(@PathVariable("openId") String openId) {
        //解除绑定 就是valid = false
        if (StringUtils.isEmpty(openId)) {
            return new ResponsePojo<>(ResponseCodeTypeEnum.PARAMETER_ERROR);
        }
        WeiXinAccountInfoReqDto dto = new WeiXinAccountInfoReqDto();
        dto.setOpenid(openId);
        dto.setValid(false);

        return weiXinAccountService.updateByOpenId(dto);
    }

}
