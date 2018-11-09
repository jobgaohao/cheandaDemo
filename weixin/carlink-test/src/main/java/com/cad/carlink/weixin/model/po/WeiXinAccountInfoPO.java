package com.cad.carlink.weixin.model.po;

import com.cad.carlink.weixin.test.mybatisFilter.Common;

import java.util.Date;

public class WeiXinAccountInfoPO extends Common{
    private Integer pkid;

    /**
     * 账户ID
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Integer userid;

    /**
     * 微信openId
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String openid;

    /**
     * 区域：1 湖北 2.湖南  3.河南  4.河北
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Integer areatype;

    /**
     * 手机号
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String cellphone;

    /**
     * 头像Url
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String headimgurl;

    /**
     * 昵称
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String nickname;

    /**
     * 头像标签
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String imagetag;

    /**
     * 性别
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Short sex;

    /**
     * 语言
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String language;

    /**
     * 城市
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String city;

    /**
     * 省
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String province;

    /**
     * 国家
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String country;

    /**
     * 创建时间
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Date createtime;

    /**
     * 最后修改时间
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Date lastmodifytime;

    /**
     * 是否有效
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Boolean valid;

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getAreatype() {
        return areatype;
    }

    public void setAreatype(Integer areatype) {
        this.areatype = areatype;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getImagetag() {
        return imagetag;
    }

    public void setImagetag(String imagetag) {
        this.imagetag = imagetag == null ? null : imagetag.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}