package com.cad.carlink.weixin.weixin;


import com.cad.carlink.weixin.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WechatAccountConfig {

    @Autowired
    private PropertiesConfig config;


    /**
     * 公众平台id
     */
    private String mpAppId;

    /**
     * 公众平台密钥
     */
    private String mpAppSecret;

    /**
     * 绑定消息模版ID
     */
    private String bindMsgTempId;

    /**
     * 报警，预警消息模版ID
     */
    private String sendAlarmTempId;

    public String getMpAppId() {
        return config.getValueByKey("mpAppId");
    }

    public String getMpAppSecret() {
        return config.getValueByKey("mpAppSecret");
    }

    public void setMpAppId(String mpAppId) {
        this.mpAppId = mpAppId;
    }

    public void setMpAppSecret(String mpAppSecret) {
        this.mpAppSecret = mpAppSecret;
    }

    public String getBindMsgTempId() {
        return config.getValueByKey("bindMsgTempId");
    }

    public void setBindMsgTempId(String bindMsgTempId) {
        this.bindMsgTempId = bindMsgTempId;
    }

    public String getSendAlarmTempId() {
        return config.getValueByKey("sendAlarmTempId");
    }

    public void setSemdAlarmTempId(String sendAlarmTempId) {
        this.sendAlarmTempId = sendAlarmTempId;
    }
}

