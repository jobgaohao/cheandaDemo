package com.cad.carlink.weixin.dao;

import com.cad.carlink.common.annotation.MybatisMapper;
import com.cad.carlink.weixin.model.dto.req.WeiXinAccSetReqDto;
import com.cad.carlink.weixin.model.dto.resp.WeiXinAccSetRespDto;
import com.cad.carlink.weixin.model.po.WeiXinAccSetPO;

import java.util.List;


@MybatisMapper("weiXinAccSetPOMapper")
public interface WeiXinAccSetPOMapper {
    int deleteByPrimaryKey(Integer pkid);

    int insert(WeiXinAccSetPO record);

    int insertSelective(WeiXinAccSetPO record);

    int insertByOpenId(WeiXinAccSetReqDto reqDto);

    WeiXinAccSetPO selectByPrimaryKey(Integer pkid);

    int updateByPrimaryKeySelective(WeiXinAccSetPO record);

    int updateByPrimaryKey(WeiXinAccSetPO record);

    int updateByOpenId(WeiXinAccSetReqDto dto);

    List<WeiXinAccSetRespDto> findList(WeiXinAccSetReqDto dto);
}