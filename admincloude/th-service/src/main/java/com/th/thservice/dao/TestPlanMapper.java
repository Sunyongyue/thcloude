package com.th.thservice.dao;

import com.th.thservice.entity.TestPlan;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface TestPlanMapper {
    int deleteByPrimaryKey(Long id);
    int insert(TestPlan record);
    int updateByPrimaryKey(TestPlan record);
    List<TestPlan> queryAll();
    Long selectMaxId();
    List<TestPlan> queryByParams(@Param("planName")String planName,@Param("operator")String operator,@Param("startTime")String startTime,@Param("endTime")String endTime);
}
