package com.th.thservice.service;

import com.th.thservice.common.CurdService;
import com.th.thservice.entity.TestTemplate;

import java.util.List;

public interface TestTemplateService extends CurdService<TestTemplate> {
    List<TestTemplate> findTree();
    List<TestTemplate> findTwo();
    List<TestTemplate> findOne();
    List<TestTemplate> queryByParentId(Long id);
}
