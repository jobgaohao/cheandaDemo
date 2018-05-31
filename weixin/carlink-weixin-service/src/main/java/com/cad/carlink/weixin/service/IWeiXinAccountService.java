package com.cad.carlink.weixin.service;

import com.cad.carlink.common.base.ResponsePojo;
import com.cad.carlink.weixin.model.dto.req.WeiXinAccountInfoReqDto;
import com.cad.carlink.weixin.model.dto.resp.WeiXinAccountInfoRespDto;

import java.util.List;

public interface IWeiXinAccountService {

    /**
     * updte
     * <p>
     * 解除绑定
     *
     * @param dto
     * @return
     */
    ResponsePojo updateByOpenId(WeiXinAccountInfoReqDto dto);

    /**
     * 微信账号绑定
     *
     * @param dto
     * @return
     */
    ResponsePojo bindAccount(WeiXinAccountInfoReqDto dto);


    ResponsePojo<List<WeiXinAccountInfoRespDto>> findList(WeiXinAccountInfoReqDto dto);

}
