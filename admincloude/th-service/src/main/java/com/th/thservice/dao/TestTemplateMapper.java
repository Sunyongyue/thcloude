package com.th.thservice.dao;

import com.th.thservice.entity.TestTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestTemplateMapper {
    int deleteByPrimaryKey(Long id);
    int insert(TestTemplate record);
    int updateByPrimaryKey(TestTemplate record);
    List<TestTemplate> queryAll();
    List<TestTemplate> queryByParentId(Long id);
    TestTemplate queryById(Long id);
    List<TestTemplate> queryByParams(@Param("testName") String testName);
}
