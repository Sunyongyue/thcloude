package com.th.thservice.service;

import com.th.thservice.common.CurdService;
import com.th.thservice.entity.TestPlan;
import com.th.thservice.entity.TestTerm;

import java.util.List;

public interface TestPlanService extends CurdService<TestPlan> {
    Long selectMaxId();
}
