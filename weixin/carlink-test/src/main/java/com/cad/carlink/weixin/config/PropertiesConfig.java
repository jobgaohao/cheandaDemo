package com.cad.carlink.weixin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 修改记录
 * 接入配置
 * @author kai.huang
 *
 */
@Component
public class PropertiesConfig {

    private static Logger logger = LoggerFactory.getLogger(PropertiesConfig.class);

    private static Properties props = new Properties();

    static {

        InputStream inputStream = null;
        try {
            inputStream = PropertiesConfig.class.getResourceAsStream("/properties/application.properties");
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            props.load(reader);

        } catch (Exception e) {
            logger.error("加载属性文件失败:" + e.getMessage(), e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    public String getValueByKey(String key) {
        if(null == key) {
            return null;
        }
        return props.getProperty(key);
    }
}

