package com.cad.carlink.weixin.weixin;

import com.cad.carlink.common.base.ResponsePojo;
import com.cad.carlink.common.enums.AlarmLevelEnum;
import com.cad.carlink.common.enums.ResponseCodeTypeEnum;
import com.cad.carlink.common.util.DateUtils;
import com.cad.carlink.weixin.model.po.WeiXinTempMsgPo;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class WeChatTempMsgUtil {

    private static Logger logger = LoggerFactory.getLogger(WeChatTempMsgUtil.class);

    /**
     * 绑定模版消息模版ID【生产】
     */
    //private static final String BIND_TEMP_ID = "Mi411aE8ata1pgWeYAVozeAE83TEsWa534tfZA9M-gI";


    /**
     * 发送报警/预警消息模版ID【生产】
     */
    // private static final String SEND_ALARM_TEMP_ID = "YLoquB5Urq0Oar7JpwBGzIIUvFcW6Cnxm2o3gRHr9Lc";

    private static final String BIND_TEMP_ID = "e6YfVecrGAk8rOZ1BKDtk7Xwph5u0AeintNPccm8t_M";
    private static final String SEND_ALARM_TEMP_ID = "ETUkNIIDAgoUi5Gt5mHj_7lPFqCN6ZWZ2wT8OfnK8FE";

    @Autowired
    WechatMpConfig mpConfig;

    /**
     * 微信绑定成功通知模板
     *
     * @return
     */
//    public ResponsePojo<Object> sendTempBindMsg(WeiXinBindTempleReqDto dto) {
//        String nowDate = DateUtils.getNowDateForString();
//        String title = StringUtils.isNotEmpty(dto.getTitle()) ? dto.getTitle() : "您已经成功绑定了手机号码";
//        String remark = StringUtils.isNotEmpty(dto.getRemark()) ? dto.getRemark() : "";
//        String phone = StringUtils.isNotEmpty(dto.getTellPhone()) ? dto.getTellPhone() : "";
//
//        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
//                .toUser(dto.getOpenId())
//                .templateId(BIND_TEMP_ID)
//                .build();
//        templateMessage.addWxMpTemplateData(new WxMpTemplateData("first", title));
//        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword1", phone));
//        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword2", nowDate));
//        templateMessage.addWxMpTemplateData(new WxMpTemplateData("remark", remark));
//        try {
//            mpConfig.wxMpService().getTemplateMsgService().sendTemplateMsg(templateMessage);
//        } catch (WxErrorException e) {
//            logger.error("微信发送绑定账号模板消息失败,e:{}" + e.getMessage(), e);
//        }
//        return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS);
//    }


    /**
     * 发送报警微信模版消息
     *
     * @return
     */
    public ResponsePojo<Object> sendTempAlarmMsg(WeiXinTempMsgPo weiXinTempMsgPo) {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(weiXinTempMsgPo.getOpenID())
                .templateId(SEND_ALARM_TEMP_ID)
                .build();
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("first", "您有一条报警记录，请及时纠正。\n" , "#FF0000"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword1", weiXinTempMsgPo.getPlateNum(), "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword2", weiXinTempMsgPo.getAlarmTypeEnum()+"(持续："+weiXinTempMsgPo.getKeepTime()+")", "#FF0000"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword3", weiXinTempMsgPo.getRunningSpeed()+"(限速："+weiXinTempMsgPo.getCurrentConfigSpeedLimit()+")", "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword4", weiXinTempMsgPo.getLocation(), "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("remark", "\n查看详情，请下载【车安哒】APP查看详情~", "#4169E1"));
        try {
            mpConfig.wxMpService().getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            logger.error("微信发送告警模板消息失败,e:{}" + e.getMessage(), e);
        }
        return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS);
    }


    /**
     * 发送告警微信模版消息
     *
     * @return
     */
    public ResponsePojo<Object> sendTempWarmMsg(WeiXinTempMsgPo weinXinTempMsgPo){
        String nowDate = DateUtils.getNowDateForString();
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(weinXinTempMsgPo.getOpenID())
                .templateId(SEND_ALARM_TEMP_ID)
                .build();
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("first", "您有一条预警记录，请及时纠正。\n", "#FFD700"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword1", weinXinTempMsgPo.getPlateNum(), "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword2", weinXinTempMsgPo.getAlarmTypeEnum()+"(持续："+weinXinTempMsgPo.getKeepTime()+")", "#FFD700"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword3", weinXinTempMsgPo.getRunningSpeed()+"(限速"+weinXinTempMsgPo.getCurrentConfigSpeedLimit()+")", "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword4", weinXinTempMsgPo.getLocation(), "#080808"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("remark", "\n查看详情，请下载【车安哒】APP查看详情~", "#4169E1"));
        try {
            mpConfig.wxMpService().getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            logger.error("微信发送预警模板消息失败,e:{}" + e.getMessage(), e);
        }
        return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS);
    }


    /**
     * 微信监控通知
     *
     * @param weiXinTempMsgPo
     * @return
     */
    public ResponsePojo<Object> sendTempMonitorMsg(WeiXinTempMsgPo weiXinTempMsgPo) {
        if((AlarmLevelEnum.EARLY_ALARM.getValue().toString()).equals(weiXinTempMsgPo.getAlarmLevelEnum())){
            sendTempWarmMsg(weiXinTempMsgPo);
        }
        else if((AlarmLevelEnum.GAVE_ALARM.getValue().toString()).equals(weiXinTempMsgPo.getAlarmLevelEnum())){
            sendTempAlarmMsg(weiXinTempMsgPo);
        }
        return new ResponsePojo<>(ResponseCodeTypeEnum.SUCCESS);
    }
}
