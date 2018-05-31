package com.cad.carlink.weixin.service;

import com.cad.carlink.common.base.ResponsePojo;
import com.cad.carlink.weixin.model.dto.req.WeiXinAccSetReqDto;
import com.cad.carlink.weixin.model.dto.req.WeiXinGetOpenIdByTelReqDto;
import com.cad.carlink.weixin.model.dto.resp.WeiXinAccSetRespDto;
import com.cad.carlink.weixin.model.po.WeiXinTempMsgPo;

import java.util.List;

public interface IWeiXinAccSetService {

    ResponsePojo updateByOpenId(WeiXinAccSetReqDto dto);

    ResponsePojo insertByOpenId(WeiXinAccSetReqDto dto);

    ResponsePojo<List<WeiXinAccSetRespDto>> findList(WeiXinAccSetReqDto dto);

    /**
     * 根据电话获取微信公众号OpenId
     * @param dto
     * @return
     */
    List<WeiXinTempMsgPo> getWeiXinOpenIdByTel(WeiXinGetOpenIdByTelReqDto dto);
}
