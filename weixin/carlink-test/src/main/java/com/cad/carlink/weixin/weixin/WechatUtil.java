package com.cad.carlink.weixin.weixin;

import com.cad.carlink.common.support.redis.RedisCacheUtil;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WechatUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    WechatMpConfig mpConfig;

    /**
     * 根据code获取用户信息
     *
     * @param code
     * @return
     */
    public WxMpUser getUserInfoByCode(String code) {
        //用户信息
        WxMpUser wxMpUser = null;
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = mpConfig.wxMpService().oauth2getAccessToken(code);
            wxMpUser = mpConfig.wxMpService().oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            if(wxMpUser!=null&& StringUtils.isNotEmpty(wxMpUser.getOpenId())){
                RedisCacheUtil.putObject(wxMpUser.getOpenId(),wxMpUser);
            }
        } catch (WxErrorException e) {
            logger.error("根据code获取用户信息失败,e:{}" + e.getMessage(), e);
        }
        return wxMpUser;
    }
}

