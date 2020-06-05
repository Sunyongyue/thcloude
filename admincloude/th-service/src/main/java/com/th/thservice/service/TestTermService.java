package com.th.thservice.service;

import com.th.thservice.entity.TestTerm;

import java.util.List;

public interface TestTermService  {
    int deleteByPrimaryKey(List<TestTerm> record);
    int save(TestTerm record);
    int deleteByParentID(Long id);
    List<TestTerm> queryAll(Long id,String startTime,String endTime,int success);
}
