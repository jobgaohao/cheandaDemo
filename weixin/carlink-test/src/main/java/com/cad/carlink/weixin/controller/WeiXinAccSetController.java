package com.cad.carlink.weixin.controller;


import com.cad.carlink.common.base.ResponsePojo;
import com.cad.carlink.common.enums.ResponseCodeTypeEnum;
import com.cad.carlink.weixin.model.dto.req.WeiXinAccSetReqDto;
import com.cad.carlink.weixin.model.dto.req.WeiXinGetOpenIdByTelReqDto;
import com.cad.carlink.weixin.model.dto.resp.WeiXinAccSetRespDto;
import com.cad.carlink.weixin.model.po.WeiXinTempMsgPo;
import com.cad.carlink.weixin.service.IWeiXinAccSetService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/wx")
public class WeiXinAccSetController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    IWeiXinAccSetService weiXinAccSetService;


    /**
     * 更新推送报警类型
     *
     * @param dto
     * @return
     */
    @RequestMapping(value = "/updateSendAlarmType", method = RequestMethod.POST)
    public ResponsePojo<Object> updateSendAlarmType(@RequestBody WeiXinAccSetReqDto dto) {
        if (dto == null || StringUtils.isBlank(dto.getOpenid())) {
            return new ResponsePojo<>(ResponseCodeTypeEnum.PARAMETER_ERROR);
        }
        return weiXinAccSetService.updateByOpenId(dto);
    }


    /**
     * 查询推送报警类型
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/findByOpenId/{openId}", method = RequestMethod.GET)
    public ResponsePojo<WeiXinAccSetRespDto> findAccSetAlarm(@PathVariable("openId") String openId) {
        if (StringUtils.isEmpty(openId)) {
            logger.error("openid 为空！ 查询终止");
            return new ResponsePojo<>(ResponseCodeTypeEnum.PARAMETER_ERROR);
        }
        WeiXinAccSetReqDto dto = new WeiXinAccSetReqDto();
        dto.setOpenid(openId);
        ResponsePojo<List<WeiXinAccSetRespDto>> responsePojo = weiXinAccSetService.findList(dto);
        if (responsePojo == null || !ResponseCodeTypeEnum.SUCCESS.getValue().equals(responsePojo.getCode())) {
            logger.error("weiXinAccSetService.findList 查询出错,msg:{}" + responsePojo.getMessage());
            return new ResponsePojo<>(ResponseCodeTypeEnum.DATABASE_EXCEPTION);
        }
        if (CollectionUtils.isNotEmpty(responsePojo.getObject())) {
            return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS, responsePojo.getObject().get(0));
        }
        return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS);
    }


    /**
     * 根据车辆电话找到微信 OpenId
     * @param weiXinGetOpenIdByTelReqDto
     * @return
     */
    @RequestMapping(value="/findTempMsgOpenIdByCell",method = RequestMethod.POST)
    public List<WeiXinTempMsgPo> findTempMsgOpenIdByCell(@RequestBody WeiXinGetOpenIdByTelReqDto weiXinGetOpenIdByTelReqDto){
        List<WeiXinTempMsgPo> liOpenIds=new ArrayList<WeiXinTempMsgPo>();
        try{
            liOpenIds= weiXinAccSetService.getWeiXinOpenIdByTel(weiXinGetOpenIdByTelReqDto);
        }catch(Exception ex){
            logger.error("根据车辆找到司机&企业负责人的电话异常,e:{}" + ex.getMessage(), ex);
        }
        return  liOpenIds;
    }
}
