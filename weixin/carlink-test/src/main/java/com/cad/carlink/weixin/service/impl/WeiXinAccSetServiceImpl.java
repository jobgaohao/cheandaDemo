package com.cad.carlink.weixin.service.impl;

import com.cad.carlink.common.base.ResponsePojo;
import com.cad.carlink.common.enums.ResponseCodeTypeEnum;
import com.cad.carlink.weixin.dao.WeiXinAccSetPOMapper;
import com.cad.carlink.weixin.dao.WeiXinMsgTempMapper;
import com.cad.carlink.weixin.model.dto.req.WeiXinAccSetReqDto;
import com.cad.carlink.weixin.model.dto.req.WeiXinGetOpenIdByTelReqDto;
import com.cad.carlink.weixin.model.dto.resp.WeiXinAccSetRespDto;
import com.cad.carlink.weixin.model.po.WeiXinTempMsgPo;
import com.cad.carlink.weixin.service.IWeiXinAccSetService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("weiXinAccSetService")
public class WeiXinAccSetServiceImpl implements IWeiXinAccSetService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WeiXinAccSetPOMapper weiXinAccSetPOMapper;

    @Autowired
    private WeiXinMsgTempMapper weiXinMsgTempMapper;

    @Override
    public ResponsePojo updateByOpenId(WeiXinAccSetReqDto dto) {
        if (dto == null || StringUtils.isBlank(dto.getOpenid())) {
            logger.error("参数有误 添加终止");
            return new ResponsePojo(ResponseCodeTypeEnum.PARAMETER_ERROR);
        }
        try {
            int update = weiXinAccSetPOMapper.updateByOpenId(dto);
            if (update == 0) {
                return new ResponsePojo(ResponseCodeTypeEnum.DATABASE_EXCEPTION);
            }
        } catch (Exception e) {
            logger.error("更新账户的报警推送设置失败");
            return new ResponsePojo(ResponseCodeTypeEnum.FAIL);
        }
        return new ResponsePojo(ResponseCodeTypeEnum.SUCCESS);
    }

    @Override
    public ResponsePojo insertByOpenId(WeiXinAccSetReqDto dto) {
        if (dto == null || StringUtils.isBlank(dto.getOpenid())) {
            logger.error("参数有误 添加终止");
            return new ResponsePojo(ResponseCodeTypeEnum.PARAMETER_ERROR);
        }
        try {
            weiXinAccSetPOMapper.insertByOpenId(dto);
        } catch (Exception e) {
            logger.error("添加账户的报警推送设置失败");
            return new ResponsePojo(ResponseCodeTypeEnum.FAIL);
        }
        return new ResponsePojo(ResponseCodeTypeEnum.SUCCESS);
    }


    @Override
    public ResponsePojo<List<WeiXinAccSetRespDto>> findList(WeiXinAccSetReqDto dto) {
        ResponsePojo<List<WeiXinAccSetRespDto>> responsePojo = new ResponsePojo<>();
        try {
            List<WeiXinAccSetRespDto> list = weiXinAccSetPOMapper.findList(dto);
            responsePojo.setObject(list);
            responsePojo.setCode(ResponseCodeTypeEnum.SUCCESS.getValue());
            responsePojo.setMessage(ResponseCodeTypeEnum.SUCCESS.getDisplayName());

        } catch (Exception e) {
            logger.error("获取报警推送信息失败");
            responsePojo.setMessage(ResponseCodeTypeEnum.FAIL.getDisplayName());
            responsePojo.setCode(ResponseCodeTypeEnum.FAIL.getValue());
        }
        return responsePojo;
    }


    @Override
    public List<WeiXinTempMsgPo> getWeiXinOpenIdByTel(WeiXinGetOpenIdByTelReqDto dto) {
        List<WeiXinTempMsgPo> li=new ArrayList<WeiXinTempMsgPo>();
        try{
            li= weiXinMsgTempMapper.getWeiXinOpenIdByTel(dto);
        }catch (Exception ex){
            logger.error("getWeiXinOpenIdByTel出现异常,e:{}" + ex.getMessage(), ex);
        }
        return li;
    }
}
