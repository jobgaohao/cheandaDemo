package com.cad.carlink.weixin.weixin;

import com.cad.carlink.common.base.ResponsePojo;
import com.cad.carlink.common.enums.AlarmLevelEnum;
import com.cad.carlink.common.enums.ResponseCodeTypeEnum;
import com.cad.carlink.common.util.DateUtils;
import com.cad.carlink.weixin.model.dto.req.WeiXinBindTempleReqDto;
import com.cad.carlink.weixin.model.po.WeiXinTempMsgPo;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WechatMsgTempUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    WechatMpConfig mpConfig;

    /**
     * 微信绑定成功通知模板
     *
     * @return
     */
    public ResponsePojo<Object> sendTempBindMsg(WeiXinBindTempleReqDto dto) {
        String nowDate = DateUtils.getNowDateForString();
        String title = StringUtils.isNotEmpty(dto.getTitle()) ? dto.getTitle() : "您已经成功绑定了手机号码";
        String remark = StringUtils.isNotEmpty(dto.getRemark()) ? dto.getRemark() : "";
        String phone = StringUtils.isNotEmpty(dto.getTellPhone()) ? dto.getTellPhone() : "";

        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(dto.getOpenId())
                .templateId(mpConfig.getBindMsgTempId())
                .build();
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("first", title));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword1", phone));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword2", nowDate));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("remark", remark));
        try {
            mpConfig.wxMpService().getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            logger.error("微信发送绑定账号模板消息失败,e:{}" + e.getMessage(), e);
        }
        return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS);
    }


    /**
     * 发送报警微信模版消息
     *
     * @return
     */
    public ResponsePojo<Object> sendTempAlarmMsg(WeiXinTempMsgPo weiXinTempMsgPo) {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(weiXinTempMsgPo.getOpenID())
                .templateId(mpConfig.getSendAlarmTempId())
                .url("")
                .build();
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("first", "您有一条报警记录，请及时纠正。\n", "#FF0000"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword1", weiXinTempMsgPo.getPlateNum(), "#080808"));
        //templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword2", weiXinTempMsgPo.getAlarmTypeEnum() + "(持续：" + weiXinTempMsgPo.getKeepTime() + ")", "#FF0000"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword2", weiXinTempMsgPo.getAlarmTypeEnum() , "#FF0000"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword3", weiXinTempMsgPo.getRunningSpeed() + "(限速：" + weiXinTempMsgPo.getCurrentConfigSpeedLimit() + ")", "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword4", weiXinTempMsgPo.getLocation(), "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("remark", "\n查看详情，请下载【车安哒】APP查看详情~", "#4169E1"));
        try {
            mpConfig.wxMpService().getTemplateMsgService().sendTemplateMsg(templateMessage);
            return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS);
        } catch (WxErrorException e) {
            logger.error("微信发送告警模板消息失败,e:{}" + e.getMessage(), e);
            return new ResponsePojo<>(ResponseCodeTypeEnum.FAIL);
        }
    }


    /**
     * 发送告警微信模版消息
     *
     * @return
     */
    public ResponsePojo<Object> sendTempWarmMsg(WeiXinTempMsgPo weinXinTempMsgPo) {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(weinXinTempMsgPo.getOpenID())
                .templateId(mpConfig.getSendAlarmTempId())
                .url("")
                .build();
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("first", "您有一条预警记录，请及时纠正。\n", "#FFD700"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword1", weinXinTempMsgPo.getPlateNum(), "#080808"));
        //templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword2", weinXinTempMsgPo.getAlarmTypeEnum() + "(持续：" + weinXinTempMsgPo.getKeepTime() + ")", "#FFD700"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword2", weinXinTempMsgPo.getAlarmTypeEnum() , "#FFD700"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword3", weinXinTempMsgPo.getRunningSpeed() + "(限速" + weinXinTempMsgPo.getCurrentConfigSpeedLimit() + ")", "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword4", weinXinTempMsgPo.getLocation(), "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("remark", "\n查看详情，请下载【车安哒】APP查看详情~", "#4169E1"));
        try {
            mpConfig.wxMpService().getTemplateMsgService().sendTemplateMsg(templateMessage);
            return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS);
        } catch (WxErrorException e) {
            logger.error("微信发送预警模板消息失败,e:{}" + e.getMessage(), e);
            return new ResponsePojo<>(ResponseCodeTypeEnum.FAIL);
        }
    }


    /**
     * 微信监控通知
     *
     * @param weiXinTempMsgPo
     * @return
     */
    public ResponsePojo<Object> sendTempMonitorMsg(WeiXinTempMsgPo weiXinTempMsgPo) {
        if ((AlarmLevelEnum.EARLY_ALARM.getValue().toString()).equals(weiXinTempMsgPo.getAlarmLevelEnum())) {
            return sendTempWarmMsg(weiXinTempMsgPo);
        } else if ((AlarmLevelEnum.GAVE_ALARM.getValue().toString()).equals(weiXinTempMsgPo.getAlarmLevelEnum())) {
           return sendTempAlarmMsg(weiXinTempMsgPo);
        }
        return new ResponsePojo<>(ResponseCodeTypeEnum.FAIL);
    }
}

