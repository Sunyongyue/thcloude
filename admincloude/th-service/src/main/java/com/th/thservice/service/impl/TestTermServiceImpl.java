package com.th.thservice.service.impl;

import com.th.thservice.dao.TestTermMapper;
import com.th.thservice.entity.TestTerm;
import com.th.thservice.service.TestTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
@Service
public class TestTermServiceImpl implements TestTermService {
    @Autowired
    TestTermMapper testTermMapper;
    @Override
    public int deleteByPrimaryKey(List<TestTerm> record) {
        for (TestTerm r:
             record) {
            testTermMapper.deleteByPrimaryKey(r.getId());
        }
        return 1;
    }

    @Override
    public int save(TestTerm record) {
        if (record.getId()==0||record.getId()==null){
            return testTermMapper.insert(record);
        }
        return testTermMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByParentID(Long id) {
        return testTermMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TestTerm> queryAll(Long id,String startTime,String endTime,int success) {
        List<TestTerm> testTerms = testTermMapper.queryAll(id, startTime, endTime, success);
        for (TestTerm testTerm:testTerms) {
//            if (testTerm.getResultPath()!=null){
//                String[] split = testTerm.getResultPath().split(";");
//                List<String> paths= new ArrayList<>();
//                for (String s: split) {
//                    paths.add(s);
//                }
//                testTerm.setPaths(paths);
//            }
            try {
                if (testTerm.getTestResults()!=null){
                    testTerm.setTestResult(new String(testTerm.getTestResults(),"utf-8"));
                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return testTerms;
    }
}
