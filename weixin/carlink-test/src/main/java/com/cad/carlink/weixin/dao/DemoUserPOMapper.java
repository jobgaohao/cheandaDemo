package com.cad.carlink.weixin.dao;

import com.cad.carlink.common.annotation.MybatisMapper;
import com.cad.carlink.weixin.model.po.DemoUserPO;

@MybatisMapper("demoUserPOMapper")
public interface DemoUserPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(DemoUserPO record);

    int insertSelective(DemoUserPO record);

    DemoUserPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DemoUserPO record);

    int updateByPrimaryKey(DemoUserPO record);

}