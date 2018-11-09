package com.cad.carlink.weixin.dao;

import com.cad.carlink.common.annotation.MybatisMapper;
import com.cad.carlink.weixin.model.dto.req.WeiXinGetOpenIdByTelReqDto;
import com.cad.carlink.weixin.model.po.WeiXinTempMsgPo;

import java.util.List;

@MybatisMapper("weiXinMsgTempMapper")
public interface WeiXinMsgTempMapper {

    /**
     * 根据电话以及告警类型查找OpenId
     * @param dto
     * @return
     */
    List<WeiXinTempMsgPo> getWeiXinOpenIdByTel(WeiXinGetOpenIdByTelReqDto dto);
}
