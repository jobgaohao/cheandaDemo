package com.cad.carlink.weixin.controller;

import com.cad.carlink.common.base.ResponsePojo;
import com.cad.carlink.weixin.model.po.WeiXinTempMsgPo;
import com.cad.carlink.weixin.weixin.WechatMpConfig;
import com.cad.carlink.weixin.weixin.WechatMsgTempUtil;
import me.chanjar.weixin.common.api.WxConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 微信公众号 认证相关功能
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/wx")
public class WechatController {

    private static Logger logger = LoggerFactory.getLogger(WechatController.class);

    @Autowired
    WechatMpConfig mpConfig;

    @Autowired
    WechatMsgTempUtil wechatMsgTempUtil;

    /**
     * 微信服务器配置验证授权【使用】
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/getServerInfo", method = RequestMethod.GET)
    public  String getToken(String echostr){
        logger.info("微信服务器认证,echostr:{}" + echostr);
        return  echostr;
    }

    /**
     * 微信认证,跳转【使用】
     * @return
     */
    @RequestMapping(value="/authorize", method = RequestMethod.GET)
    public String authorize(@RequestParam("url") String url) {
        try
        {
            String redirectUrl = mpConfig.wxMpService().oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, null);
            return redirectUrl;
        }catch (Exception ex){
            logger.error("微信认证,跳转出现异常,e:{}" + ex.getMessage(), ex);
            return ex.getMessage();
        }
    }

    /**
     * 微信发送模版消息
     * @param weiXinTempMsgPo
     * @return
     */
    @RequestMapping(value="/sendWechatTempMsg", method = RequestMethod.POST)
    public  ResponsePojo<Object> sendWechatTempMsg(@RequestBody WeiXinTempMsgPo weiXinTempMsgPo){
       return wechatMsgTempUtil.sendTempMonitorMsg(weiXinTempMsgPo);
    }
}
