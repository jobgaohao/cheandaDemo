package com.cad.carlink.weixin.weixin;


import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WechatMpConfig {

    @Autowired
    public WechatAccountConfig accountConfig;

    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(accountConfig.getMpAppId());
        wxMpConfigStorage.setSecret(accountConfig.getMpAppSecret());
        return wxMpConfigStorage;
    }

    /**
     * 绑定消息模版ID
     */
    public String getBindMsgTempId(){
        return  accountConfig.getBindMsgTempId();
    }

    /**
     * 报警，预警消息模版ID
     */
    public String getSendAlarmTempId(){
        return  accountConfig.getSendAlarmTempId();
    }

}