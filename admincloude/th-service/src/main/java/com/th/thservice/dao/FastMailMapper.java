package com.th.thservice.dao;

import com.th.thservice.entity.FastMail;


import java.util.List;

public interface FastMailMapper {
    int deleteByPrimaryKey(Long id);
    int insert(FastMail record);
    List<FastMail> findAll();
    int updateByPrimaryKey(FastMail record);
    List<FastMail>findByParams(FastMail record);
    FastMail selectOne(FastMail record);
}
