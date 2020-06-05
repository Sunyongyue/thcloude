package com.th.thservice.controller;

import com.th.thservice.dao.TestTemplateMapper;
import com.th.thservice.entity.PhotoInfo;
import com.th.thservice.entity.TestPlan;
import com.th.thservice.entity.TestTemplate;
import com.th.thservice.entity.TestTerm;
import com.th.thservice.http.HttpResult;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.TestPlanService;
import com.th.thservice.service.TestTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("testPlan")
public class TestPlanController {
    @Autowired
    TestPlanService testPlanService;
    @Autowired
    TestTermService testTermService;
    @Autowired
    TestTemplateMapper templateMapper;
    @PreAuthorize("hasAuthority('test:plan:view')")
    @PostMapping("/testPlanView")
    public HttpResult view(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(testPlanService.findPage(pageRequest));
    }
    @PreAuthorize("hasAuthority('test:plan:delete')")
    @PostMapping("/del")
    public HttpResult del(@RequestBody List<TestPlan> testPlan){
        return HttpResult.ok(testPlanService.delete(testPlan));
    }
    @PreAuthorize("hasAuthority('test:plan:add') and hasAuthority('test:plan:edit')")
    @PostMapping("/save")
    public HttpResult save(@RequestBody TestPlan testPlan){
        Long[] testNames = testPlan.getTestNames();
        for (Long testName: testNames) {
            TestTemplate testTemplate = templateMapper.queryById(testName);
            if (testTemplate.getAttribute()==testPlan.getAttribute()){
                if (testTemplate.getType()==testPlan.getType()||testTemplate.getType()==2){
                    testPlan.setTestName(testTemplate.getTestName());
                    int save = testPlanService.save(testPlan);
                    Long aLong=testPlan.getId();
                    if (testPlan.getId()==0||testPlan.getId()==null){
                        aLong =testPlanService.selectMaxId();
                    }
                    testTermService.deleteByParentID(aLong);
                    List<TestTemplate> testTemplates = templateMapper.queryByParentId(testName);
                    for (TestTemplate tem: testTemplates) {
                        TestTerm testTerm = new TestTerm();
                        testTerm.setId((long) 0);
                        testTerm.setTestPlanId(aLong);
                        testTerm.setTestName(tem.getTestName());
                        testTerm.setContent(tem.getContent());
                        testTerm.setTestTarget(tem.getTestTarget());
                        testTerm.setRemarks(tem.getRemarks());
                        testTerm.setOperator(testPlan.getOperator());
                        testTermService.save(testTerm);
                    }
                }
            }

        }
        return HttpResult.ok(1);
    }
    @PreAuthorize("hasAuthority('test:term:view')")
    @PostMapping("/testTermView")
    public HttpResult testTermView(@RequestBody TestTerm testTerm){
        return HttpResult.ok(testTermService.queryAll(testTerm.getTestPlanId(),testTerm.getStartTime(),testTerm.getEndTime(),testTerm.getSuccess()));
    }
//    @PreAuthorize("hasAuthority('test:term:test')")
//    @PostMapping(value = "/uploadFile")
//    public HttpResult uploadFile(@RequestParam Map<String,String> map, @RequestParam("file") MultipartFile[] file){
//        if(map.size() >0){
//            try{
//                String path="";
//                for (int i=0;i<file.length;i++){
//                    String filename = file[i].getOriginalFilename();
//                    UUID uuid = UUID.randomUUID();
////                    String filePath = "E:/GitWorkSpace/TianHeInfoSystemUI/mango-ui/static/myphoto/"+uuid+filename;
//                   String filePath = "D:/dist/static/myphoto/"+uuid+filename;
//
//                    File saveDir = new File(filePath);
//                    if (!saveDir.getParentFile().exists()){
//                        saveDir.getParentFile().mkdirs();
//                        file[i].transferTo(saveDir);
//                    }else {
//                        file[i].transferTo(saveDir);
//                    }
//                    path+="/static/myphoto/"+uuid+filename+";";
//                }
//                TestTerm testTerm = new TestTerm();
//                String  id = map.get("id").toString();
//                String  testResult = map.get("testResult").toString();
//                testTerm.setTestResult(testResult);
//                testTerm.setId(Long.valueOf(id));
//                testTerm.setResultPath(path);
//                testTermService.save(testTerm);
//
//            }catch (Exception e){
//                return HttpResult.error();
//            }
//            return  HttpResult.ok();
//        }
//        return  HttpResult.error();
//    }
@PreAuthorize("hasAuthority('test:term:test')")
@PostMapping(value = "/uploadFile")
public HttpResult uploadFile(@RequestBody TestTerm record){
    int save = testTermService.save(record);
    return  HttpResult.ok(save);
}
}
