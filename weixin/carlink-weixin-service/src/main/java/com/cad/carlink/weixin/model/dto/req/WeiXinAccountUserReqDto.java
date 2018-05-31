package com.cad.carlink.weixin.model.dto.req;

public class WeiXinAccountUserReqDto {

    private String password;

    private String username;

    private String openId;

    /**
     * 区域类型
     * 不同省
     */
    private Integer areatype;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getAreatype() {
        return areatype;
    }

    public void setAreatype(Integer areatype) {
        this.areatype = areatype;
    }
}
