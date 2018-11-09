package com.cad.carlink.weixin.model.dto.resp;

public class WeiXinUserRespDto {
    private String openId;

    private String cellPhone;

    /**
     * 是否绑定
     */
    private Integer isBind;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Integer getIsBind() {
        return isBind;
    }

    public void setIsBind(Integer isBind) {
        this.isBind = isBind;
    }
}
