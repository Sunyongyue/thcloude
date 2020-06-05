package com.th.thservice.controller;

import com.th.thservice.entity.TestTemplate;
import com.th.thservice.http.HttpResult;
import com.th.thservice.service.TestTemplateService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("testTem")
public class TestTemplateController {
    @Autowired
    TestTemplateService templateService;

    @PreAuthorize("hasAuthority('test:tem:view')")
    @PostMapping("/templateView")
    public HttpResult templateView(@RequestBody TestTemplate testTemplate){
        List<TestTemplate> testTemplates = templateService.queryByParentId(testTemplate.getId());
        return HttpResult.ok(testTemplates);
    }
    @PostMapping("/findAllPop")
    public HttpResult findAllPop(){
        List<TestTemplate> testTemplates = templateService.findTree();
        return HttpResult.ok(testTemplates);
    }
    @PreAuthorize("hasAuthority('test:tem:add') and hasAuthority('test:tem:edit')")
    @PostMapping("/save")
    public HttpResult save(@RequestBody TestTemplate testTemplate){

        int save = templateService.save(testTemplate);

        return HttpResult.ok(save);
    }
    @PreAuthorize("hasAuthority('test:tem:delete')")
    @PostMapping("/del")
    public HttpResult del(@RequestBody List<TestTemplate> testTemplate){
        return HttpResult.ok(templateService.delete(testTemplate));
    }
    @PostMapping("/two")
    public HttpResult two(@RequestBody TestTemplate testTemplate){

        return HttpResult.ok(templateService.queryByParentId(testTemplate.getId()));
    }
    @PostMapping("/one")
    public HttpResult one(){
        return HttpResult.ok(templateService.findOne());
    }
    @PostMapping("/updateSort")
    public HttpResult updateSort(@RequestBody TestTemplate testTemplate){
        String result="操作成功";
        int sort=testTemplate.getSort();
        List<TestTemplate> testTemplates = templateService.queryByParentId(testTemplate.getParent_id());
        if (testTemplate.getRemarks().equals("上移")){
            if (sort==1){
                result="已经是第一条不可上移";
            }else{
                if (testTemplates!=null){
                    TestTemplate testTemplate1 = testTemplates.get(sort - 2);
                    testTemplate1.setSort(sort);
                    testTemplate.setSort(sort-1);
                    System.err.println("up"+"testTemplate"+testTemplate.getSort()+"testTemplate1"+testTemplate1.getSort());
                    templateService.save(testTemplate);
                    templateService.save(testTemplate1);
                }
            }
        }else if(testTemplate.getRemarks().equals("下移")){
            if (testTemplates!=null){
                if (testTemplates.size()==sort){
                    result="已经是最后一条不可下移";
                }else {
                    TestTemplate testTemplate1 = testTemplates.get(sort);
                    testTemplate1.setSort(sort);
                    testTemplate.setSort(sort+1);
                    System.err.println("down"+"testTemplate"+testTemplate.getSort()+"testTemplate1"+testTemplate1.getSort());
                    templateService.save(testTemplate);
                    templateService.save(testTemplate1);
                }
            }
        }
        return HttpResult.ok(result);
    }
}
