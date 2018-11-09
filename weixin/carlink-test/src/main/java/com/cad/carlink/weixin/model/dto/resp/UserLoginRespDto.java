package com.cad.carlink.weixin.model.dto.resp;

import java.util.Date;

public class UserLoginRespDto {

    private String code;

    private String message;

    private Integer userid;

    private String useraccount;

    private String cellphone;

    private Integer companyid;

    private String organizationname;

    private String nickname;

    private String realname;

    private Short gender;

    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date birthday;

    private String idnumber;

    private String passwordsalt;

    private String password;

    private String accountpicture;

    private Short accounttype;

    private String productcode;

    private Integer organizationtype;

    private Integer isemergencycontact;

    private Boolean valid;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPasswordsalt() {
        return passwordsalt;
    }

    public void setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountpicture() {
        return accountpicture;
    }

    public void setAccountpicture(String accountpicture) {
        this.accountpicture = accountpicture;
    }

    public Short getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Short accounttype) {
        this.accounttype = accounttype;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public Integer getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(Integer organizationtype) {
        this.organizationtype = organizationtype;
    }

    public Integer getIsemergencycontact() {
        return isemergencycontact;
    }

    public void setIsemergencycontact(Integer isemergencycontact) {
        this.isemergencycontact = isemergencycontact;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
