package com.cad.carlink.weixin.dao;

import com.cad.carlink.common.annotation.MybatisMapper;
import com.cad.carlink.weixin.model.dto.req.WeiXinAccountInfoReqDto;
import com.cad.carlink.weixin.model.dto.resp.WeiXinAccountInfoRespDto;
import com.cad.carlink.weixin.model.po.WeiXinAccountInfoPO;

import java.util.List;

@MybatisMapper("weiXinAccountInfoPOMapper")
public interface WeiXinAccountInfoPOMapper {
    int deleteByPrimaryKey(Integer pkid);

    int insert(WeiXinAccountInfoPO record);

    int insertSelective(WeiXinAccountInfoPO record);

    WeiXinAccountInfoPO selectByPrimaryKey(Integer pkid);

    int updateByPrimaryKeySelective(WeiXinAccountInfoPO record);

    int updateByPrimaryKey(WeiXinAccountInfoPO record);

    List<WeiXinAccountInfoRespDto> findList(WeiXinAccountInfoReqDto dto);

    int updateByOpenId(WeiXinAccountInfoReqDto dto);
}