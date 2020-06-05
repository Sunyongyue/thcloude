package com.th.thservice.service.impl;

import com.th.thservice.dao.TestPlanMapper;
import com.th.thservice.dao.TestTermMapper;
import com.th.thservice.entity.TestPlan;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.TestPlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestPlanServiceImpl implements TestPlanService {
    @Autowired
    TestPlanMapper planMapper;
    @Autowired
    TestTermMapper testTermMapper;
    @Override
    public int save(TestPlan record) {
        if (record.getId()==0||record.getId()==null){
            return planMapper.insert(record);
        }

        return planMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(TestPlan record) {
        testTermMapper.deleteByPrimaryKey(record.getId());
        return planMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<TestPlan> records) {
        for (TestPlan record:
             records) {
            planMapper.deleteByPrimaryKey(record.getId());
            testTermMapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public TestPlan findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {

        String planName="";
        if (pageRequest.getParam("planName")!=null){
            planName = String.valueOf(pageRequest.getParam("planName"));
        }
        String operator="";
        if (pageRequest.getParam("operator")!=null){
            operator = String.valueOf(pageRequest.getParam("operator"));
        }

        String startTime="";
        if (pageRequest.getParam("startTime")!=null){
            startTime = String.valueOf(pageRequest.getParam("startTime"));
        }

        String endTime="";
        if (pageRequest.getParam("endTime")!=null){
            endTime = String.valueOf(pageRequest.getParam("endTime"));
        }
        PageResult pageResult = MybatisPageHelper.findPage(pageRequest, planMapper, "queryByParams", planName, operator, startTime, endTime);
        List<TestPlan> list = (List<TestPlan>) pageResult.getContent();
        for (TestPlan li:
             list) {
            double v = testTermMapper.countPlanProgress(li.getId());
            li.setPlanProgress(v*100+"%");
            //String.format("%.2f", d);
        }
        pageResult.setContent(list);
        return pageResult;
    }

    @Override
    public Long selectMaxId() {
        return planMapper.selectMaxId();
    }
}
