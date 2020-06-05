package com.th.thservice.dao;

import com.th.thservice.entity.TestTarget;


import java.util.List;

public interface TestTargetMapper {
    int deleteByPrimaryKey(Long id);
    int insert(TestTarget record);
    int updateByPrimaryKey(TestTarget record);
    List<TestTarget> queryAll(Long id);
    List<TestTarget> queryByParams(Long id);
}
