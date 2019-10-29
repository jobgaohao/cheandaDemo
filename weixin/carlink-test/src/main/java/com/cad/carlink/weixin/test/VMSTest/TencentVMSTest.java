package com.cad.carlink.weixin.test.VMSTest;

import com.github.qcloudsms.SmsVoiceVerifyCodeSender;
import com.github.qcloudsms.SmsVoiceVerifyCodeSenderResult;
import com.github.qcloudsms.TtsVoiceSender;
import com.github.qcloudsms.TtsVoiceSenderResult;
import org.json.JSONException;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;

/**
 *
 */
public class TencentVMSTest {

    // 语音消息应用 SDK AppID
    public static final int APPID = 1400277668; // SDK AppID 以1400开头
    // 语音消息应用 App Key
    public static final   String APPKEY = "33b454e78dfc74ff7279cd1d99cfcfe6";
    // 语音模板 ID，需要在语音消息控制台中申请
    public static final int TEMPLATE_ID = 456781;



    public static void main(String[] args) {
        sendVoiceVerifyCodeTest();

        sendVoiceTest();
    }

    /**
     *发送语音验证码
     * 文档：https://cloud.tencent.com/document/product/1128/37721
     */
    public static void sendVoiceVerifyCodeTest(){
        String[] phoneNumbers = {"13122079487", "15827219080", "15623046869"};
        String nationcode="86";//国家（或地区）码
        String phoneNumber= phoneNumbers[0];
        int playtimes=2;//播放次数，最多3次，默认2次
        String msg="8888";//验证码，仅支持填写数字，实际播报语音时，会自动在数字前补充语音文本"您的验证码是"
        try {
            SmsVoiceVerifyCodeSender vvcsender = new SmsVoiceVerifyCodeSender(APPID,APPKEY);
            SmsVoiceVerifyCodeSenderResult result = vvcsender.send(nationcode, phoneNumber,
                    msg, playtimes, "");
            System.out.println(result);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 发送语音消息
     */
    public static void sendVoiceTest(){
        try {
            String[] phoneNumbers = {"13122079487", "15827219080", "15623046869"};
            String nationcode="86";//国家（或地区）码
            String phoneNumber= phoneNumbers[0];
            int playtimes=2;//播放次数，最多3次，默认2次
            String[] params = {"鄂A12345","湖北车安达"};//
            TtsVoiceSender tvsender = new TtsVoiceSender(APPID,APPKEY);
            TtsVoiceSenderResult result = tvsender.send(nationcode,phoneNumber,
                    TEMPLATE_ID, params, playtimes, "");
            System.out.println(result);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
