package com.cad.carlink.weixin.model.dto.req;

public class WeiXinLoginReqDto {
    private String code;

    private String openid;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

}
