package com.th.thservice.dao;

import com.th.thservice.entity.HardwareLcd;

import java.util.List;

public interface HardwareLcdMapper {
    int deleteByPrimaryKey(Long id);
    int insert(HardwareLcd record);
    List<HardwareLcd> findAll();
    int updateByPrimaryKey(HardwareLcd record);
    List<HardwareLcd>findByParams(Integer use,Integer protocol,Integer model);
}
