package com.th.thservice.dao;

import com.th.thservice.entity.TestStep;

import java.util.List;

public interface TestStepMapper {
    int deleteByPrimaryKey(Long id);
    int insert(TestStep record);
    int updateByPrimaryKey(TestStep record);
    List<TestStep> queryAll(Long id);
    List<TestStep> queryByParams(Long id);
}
