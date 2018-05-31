package com.cad.carlink.weixin.model.po;

import java.util.Date;

public class WeiXinAccSetPO {
    /**
     * 用户ID
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
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
     * 报警状态（0：开  1：关）
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Boolean alarmstate;

    /**
     * 预警状态（0：开  1：关）
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Boolean warningstate;

    /**
     * 备注
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String remark;

    /**
     * 创建时间
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Date createtime;

    /**
     * 创建人ID
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String createuserid;

    /**
     * 修改时间
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private Date lastmodifytime;

    /**
     * 最后修改人ID
     *
     * @mbggenerated Tue May 15 15:06:34 CST 2018
     */
    private String lastmodifyuserid;

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

    public Boolean getAlarmstate() {
        return alarmstate;
    }

    public void setAlarmstate(Boolean alarmstate) {
        this.alarmstate = alarmstate;
    }

    public Boolean getWarningstate() {
        return warningstate;
    }

    public void setWarningstate(Boolean warningstate) {
        this.warningstate = warningstate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid == null ? null : createuserid.trim();
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getLastmodifyuserid() {
        return lastmodifyuserid;
    }

    public void setLastmodifyuserid(String lastmodifyuserid) {
        this.lastmodifyuserid = lastmodifyuserid == null ? null : lastmodifyuserid.trim();
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}