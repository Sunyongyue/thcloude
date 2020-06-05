package com.th.thservice.dao;

import com.th.thservice.entity.ExceptionCode;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ExceptionCodeMapper {
    int deleteByPrimaryKey(Long id);
    int insert(ExceptionCode record);
    List<ExceptionCode> findAll();
    int updateByPrimaryKey(ExceptionCode record);
    List<ExceptionCode>findByParams(@Param("model") String model);
}
