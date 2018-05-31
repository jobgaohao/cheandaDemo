package com.cad.carlink.weixin.controller;

import com.cad.carlink.common.constant.Constants;
import com.cad.carlink.common.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.Date;

@RestController
@RequestMapping("")
public class SysController {

    private static Logger logger = LoggerFactory.getLogger(SysController.class);

    public final STGroup ORIGINAL_TRACK_SELECT_TEMPLATE = new STGroupFile("essql/originalTrackSelectTemplate.stg");

    /**
     * 获取微信接口域名下的txt
     *
     * @return
     */
    @RequestMapping("/MP_verify_0nWwS3cDgfyBSVvJ.txt")
    public String toTxt() {
        logger.info("微信服务器请求MP_verify_0nWwS3cDgfyBSVvJ.txt");
        return "0nWwS3cDgfyBSVvJ";
    }


    /**
     * stringtemplate
     * @return
     */
    @RequestMapping("/getStGroupFileInfo")
    public  String getStGroupFileInfo(){
        try {
            ST sqlST = ORIGINAL_TRACK_SELECT_TEMPLATE.getInstanceOf("selectTrackListByVehicleCode");
            sqlST.add("indexName", Constants.ORIGINAL_TRACK_DATA_TABLE);
            sqlST.add("vehicleCode", "HB8888");
            sqlST.add("startTime", DateUtils.getESStr("2018-05-31"));
            sqlST.add("endTime", DateUtils.getESStr("2018-05-31"));
            return sqlST.render();
        }catch (Exception ex){
            logger.error("getStGroupFileInfo error",ex);
            return ex.getMessage();
        }
   }

    /**
     * stringtemplate
     * @return
     */
    @RequestMapping("/getStGroupFileInfoCacl")
    public  String getStGroupFileInfoCacl(){
        try {
            ST sqlST = ORIGINAL_TRACK_SELECT_TEMPLATE.getInstanceOf("calc");
            sqlST.add("num1", 10);
            sqlST.add("num2", 45);
            return sqlST.render();
        }catch (Exception ex){
            logger.error("getStGroupFileInfoCacl error",ex);
            return ex.getMessage();
        }
    }

}
