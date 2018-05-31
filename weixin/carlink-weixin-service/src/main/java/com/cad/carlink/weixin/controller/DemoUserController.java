package com.cad.carlink.weixin.controller;

import com.cad.carlink.weixin.dao.DemoUserPOMapper;
import com.cad.carlink.weixin.model.po.DemoUserPO;
import com.cad.carlink.weixin.service.IWeiXinAccSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class DemoUserController {

    @Autowired
    private DemoUserPOMapper demoUserPOMapper;

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DemoUserPO getUser(@PathVariable ("id") Integer id) {
        return demoUserPOMapper.selectByPrimaryKey(String.valueOf(id));
    }
}
