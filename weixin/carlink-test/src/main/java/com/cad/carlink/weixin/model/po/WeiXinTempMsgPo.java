package com.cad.carlink.weixin.model.po;

public class WeiXinTempMsgPo {
    private String OpenID;
    private String plateNum;
    private String alarmTypeEnum;
    private String runningSpeed;
    private String currentConfigSpeedLimit;
    private String location;
    private String alarmLevelEnum;
    private String keepTime;
    private String cellPhone;

    public WeiXinTempMsgPo() {
    }

    public String getOpenID() {
        return this.OpenID;
    }

    public void setOpenID(String openID) {
        this.OpenID = openID;
    }

    public String getPlateNum() {
        return this.plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getAlarmTypeEnum() {
        return this.alarmTypeEnum;
    }

    public void setAlarmTypeEnum(String alarmTypeEnum) {
        this.alarmTypeEnum = alarmTypeEnum;
    }

    public String getRunningSpeed() {
        return this.runningSpeed;
    }

    public void setRunningSpeed(String runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAlarmLevelEnum() {
        return this.alarmLevelEnum;
    }

    public void setAlarmLevelEnum(String alarmLevelEnum) {
        this.alarmLevelEnum = alarmLevelEnum;
    }

    public String getKeepTime() {
        return this.keepTime;
    }

    public void setKeepTime(String keepTime) {
        this.keepTime = keepTime;
    }

    public String getCurrentConfigSpeedLimit() {
        return this.currentConfigSpeedLimit;
    }

    public void setCurrentConfigSpeedLimit(String currentConfigSpeedLimit) {
        this.currentConfigSpeedLimit = currentConfigSpeedLimit;
    }

    public String getCellPhone() {
        return this.cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}

