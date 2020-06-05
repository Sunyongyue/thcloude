package com.th.thservice.dao;


import com.th.thservice.entity.TestTerm;

import java.util.List;

public interface TestTermMapper {
    int deleteByPrimaryKey(Long id);
    int insert(TestTerm record);
    int updateByPrimaryKey(TestTerm record);
    double countPlanProgress(Long id);
    List<TestTerm> queryAll(Long id,String startTime,String endTime,int success);
    List<TestTerm> queryByParams(Long id);
}
