package com.th.thservice.service.impl;

import com.th.thservice.dao.TestStepMapper;
import com.th.thservice.dao.TestTargetMapper;
import com.th.thservice.dao.TestTemplateMapper;
import com.th.thservice.entity.TestStep;
import com.th.thservice.entity.TestTarget;
import com.th.thservice.entity.TestTemplate;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.TestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class TestTemplateServiceImpl implements TestTemplateService {
    @Autowired
    TestTemplateMapper templateMapper;

    @Override
    public int save(TestTemplate record) {
        if (record.getId()==null||record.getId()==0){
            List<TestTemplate> testTemplates = templateMapper.queryByParentId(record.getParent_id());
            if (testTemplates!=null){
                int size = testTemplates.size();
                record.setSort(size+1);
            }
           return templateMapper.insert(record);

        }
        return templateMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(TestTemplate record) {
        return templateMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<TestTemplate> records) {
        for (TestTemplate record:
             records) {
            templateMapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public TestTemplate findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        String testName = (String) pageRequest.getParam("testName");
        PageResult pageResult = MybatisPageHelper.findPage(pageRequest, templateMapper, "queryByParams", testName);
        return pageResult;
    }

    @Override
    public List<TestTemplate> findTree() {
        List<TestTemplate> testTemplates = templateMapper.queryAll();
        List<TestTemplate> first=new ArrayList<>();
        for (TestTemplate testTemplate: testTemplates) {
            if (testTemplate.getParent_id()==0||testTemplate.getParent_id()==null){
                first.add(testTemplate);
                testTemplate.setLevel(0);

            }
        }
        findChildren(first,testTemplates);
        return first;
    }

    @Override
    public List<TestTemplate> findTwo() {
        List<TestTemplate> testTemplates = templateMapper.queryAll();
        List<TestTemplate> two=new ArrayList<>();
        List<TestTemplate> first=new ArrayList<>();
        for (TestTemplate testTemplate: testTemplates) {
            if (testTemplate.getParent_id()==0||testTemplate.getParent_id()==null){
                first.add(testTemplate);
                testTemplate.setLevel(0);
            }
        }
        for (TestTemplate one:first){
            for (TestTemplate testTemplate: testTemplates) {
                if (testTemplate.getParent_id().equals(one.getId())){
                    testTemplate.setLevel(1);
                    two.add(testTemplate);
                }
            }
        }
        return two;
    }

    @Override
    public List<TestTemplate> findOne() {
        List<TestTemplate> testTemplates = templateMapper.queryAll();
        List<TestTemplate> first=new ArrayList<>();
        for (TestTemplate testTemplate: testTemplates) {
            if (testTemplate.getParent_id()==0||testTemplate.getParent_id()==null){
                first.add(testTemplate);
                testTemplate.setLevel(0);
            }
        }

        return first;
    }

    @Override
    public List<TestTemplate> queryByParentId(Long id) {
        List<TestTemplate> testTemplates = templateMapper.queryByParentId(id);
        TestTemplate testTemplate = templateMapper.queryById(id);
        for (TestTemplate test: testTemplates) {
            List<TestTemplate> tests = templateMapper.queryByParentId(test.getId());
            if (tests.size()>0){
                test.setHasChildren(true);
            }
            if(testTemplate!=null){
                test.setParentName(testTemplate.getTestName());
            }
        }
        return testTemplates;
    }

    public void findChildren(List<TestTemplate> first,List<TestTemplate> templates){
        for (TestTemplate template: first) {
            List<TestTemplate> children = new ArrayList<>();
            for (TestTemplate tem: templates) {
                if (template.getId().equals(tem.getParent_id())){
                    tem.setLevel(template.getLevel()+1);
                    tem.setParentName(template.getTestName());
                    children.add(tem);
                }
            }
            template.setChildren(children);
            findChildren(children,templates);
        }
    }
}
