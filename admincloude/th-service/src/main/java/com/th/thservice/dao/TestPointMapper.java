package com.th.thservice.dao;

import com.th.thservice.entity.TestTerm;

import java.util.List;

public interface TestPointMapper {
    int deleteByPrimaryKey(Long id);
    int insert(TestTerm record);
    int updateByPrimaryKey(TestTerm record);
    List<TestTerm> queryAll();
    List<TestTerm> queryByParams();
}
