package com.cad.carlink.weixin.model.dto.req;

public class WeiXinGetOpenIdByTelReqDto {

    private String  cellphones;//电话号码[多个以逗号分隔]
    private String  alarmLevelEnum;//事件类型 1.预警  2.报警

    public String getCellphones() {
        return cellphones;
    }

    public void setCellphones(String cellphones) {
        this.cellphones = cellphones;
    }

    public String getAlarmLevelEnum() {
        return alarmLevelEnum;
    }

    public void setAlarmLevelEnum(String alarmLevelEnum) {
        this.alarmLevelEnum = alarmLevelEnum;
    }
}
