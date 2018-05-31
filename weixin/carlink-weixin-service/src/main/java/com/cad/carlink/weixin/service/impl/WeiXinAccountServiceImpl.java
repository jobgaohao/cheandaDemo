package com.cad.carlink.weixin.service.impl;

import com.cad.carlink.common.base.ResponsePojo;
import com.cad.carlink.common.enums.ResponseCodeTypeEnum;
import com.cad.carlink.weixin.dao.WeiXinAccountInfoPOMapper;
import com.cad.carlink.weixin.model.dto.req.WeiXinAccountInfoReqDto;
import com.cad.carlink.weixin.model.dto.resp.WeiXinAccountInfoRespDto;
import com.cad.carlink.weixin.service.IWeiXinAccountService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("weiXinAccountService")
public class WeiXinAccountServiceImpl implements IWeiXinAccountService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WeiXinAccountInfoPOMapper weiXinAccountInfoPOMapper;

    /**
     * 更新账户信息
     *
     * @param dto
     * @return
     */
    @Override
    public ResponsePojo updateByOpenId(WeiXinAccountInfoReqDto dto) {
        if (StringUtils.isEmpty(dto.getOpenid())) {
            logger.error("openid为空");
            return new ResponsePojo(ResponseCodeTypeEnum.PARAMETER_ERROR);
        }
        try {
            int update =weiXinAccountInfoPOMapper.updateByOpenId(dto);
            if (update == 0) {
                return new ResponsePojo(ResponseCodeTypeEnum.DATABASE_EXCEPTION);
            }
        } catch (Exception e) {
            logger.error("更新微信账户信息出错,m:{}" + e.getMessage(), e);
            return new ResponsePojo(ResponseCodeTypeEnum.FAIL);
        }
        return new ResponsePojo(ResponseCodeTypeEnum.SUCCESS);
    }

    /**
     * 绑定微信账户
     *
     * @param record
     * @return
     */
    @Override
    public ResponsePojo bindAccount(WeiXinAccountInfoReqDto record) {

        if (record == null || StringUtils.isEmpty(record.getOpenid()) || record.getUserid() == null) {
            logger.error("参数有误 绑定终止");
            return new ResponsePojo(ResponseCodeTypeEnum.PARAMETER_ERROR);
        }
        try {
            WeiXinAccountInfoReqDto reqDto = new WeiXinAccountInfoReqDto();
            reqDto.setOpenid(record.getOpenid());
            List<WeiXinAccountInfoRespDto> list = weiXinAccountInfoPOMapper.findList(reqDto);

            if (CollectionUtils.isNotEmpty(list)) {
                if (record.getValid() == null) {
                    record.setValid(true);
                }
                record.setLastmodifytime(new Date());
                //update
                int update = weiXinAccountInfoPOMapper.updateByOpenId(record);
                if (update == 0) {
                    logger.error("修改绑定用户失败");
                    return new ResponsePojo(ResponseCodeTypeEnum.DATABASE_EXCEPTION);
                }
            } else {
                record.setCreatetime(new Date());
                //insert
                int insert = weiXinAccountInfoPOMapper.insertSelective(record);
                if (insert == 0) {
                    logger.error("添加绑定用户失败");
                    return new ResponsePojo(ResponseCodeTypeEnum.DATABASE_EXCEPTION);
                }
            }


        } catch (Exception e) {
            logger.error("绑定微信账户信息出错,m:{}" + e.getMessage(), e);
            return new ResponsePojo(ResponseCodeTypeEnum.DATABASE_EXCEPTION);
        }
        return new ResponsePojo(ResponseCodeTypeEnum.SUCCESS);
    }


    @Override
    public ResponsePojo<List<WeiXinAccountInfoRespDto>> findList(WeiXinAccountInfoReqDto dto) {
        ResponsePojo<List<WeiXinAccountInfoRespDto>> responsePojo = new ResponsePojo<>();
        try {
            List<WeiXinAccountInfoRespDto> list = weiXinAccountInfoPOMapper.findList(dto);
            responsePojo.setObject(list);
            responsePojo.setCode(ResponseCodeTypeEnum.SUCCESS.getValue());
            responsePojo.setMessage(ResponseCodeTypeEnum.SUCCESS.getDisplayName());

        } catch (Exception e) {
            logger.error("查询微信账户信息出错,m:{}" + e.getMessage(), e);
            responsePojo.setMessage(ResponseCodeTypeEnum.FAIL.getValue());
            responsePojo.setCode(ResponseCodeTypeEnum.FAIL.getDisplayName());
        }
        return responsePojo;
    }
}
