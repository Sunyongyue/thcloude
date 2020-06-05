package com.th.thservice.controller;

import com.th.thservice.entity.FastMail;
import com.th.thservice.entity.PhotoInfo;
import com.th.thservice.http.HttpResult;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.FastMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("fastMail")
public class FastMailController {
    @Autowired
    FastMailService mailService;
    @PreAuthorize("hasAuthority('fast:mail:view')")
    @PostMapping(value="/view")
    public HttpResult view(@RequestBody PageRequest pageRequest) {
        PageResult page = mailService.findPage(pageRequest);
        return HttpResult.ok(page);
    }
    @PreAuthorize("hasAuthority('fast:mail:delete')")
    @PostMapping(value="/del")
    public HttpResult del(@RequestBody List<FastMail> fastMailList) {

        return HttpResult.ok(mailService.delete(fastMailList));
    }

    @PreAuthorize("hasAuthority('fast:mail:add') and hasAuthority('fast:mail:edit')")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody FastMail record) {

        return HttpResult.ok(mailService.save(record));
    }
    @PreAuthorize("hasAuthority('fast:mail:add')")
    @PostMapping(value = "/uploadFile")
    public HttpResult uploadFile(@RequestParam Map<String,String> map, @RequestParam("file") MultipartFile[] file){
            String paths="";
            try{
                FastMail fastMail = new FastMail();
                fastMail.setId(Long.valueOf(map.get("id")));
                fastMail.setType(map.get("type"));
                fastMail.setModelType(map.get("modelType"));
                fastMail.setDatail(map.get("datail"));
                fastMail.setSendBy(map.get("sendBy"));
                fastMail.setReceiveBy(map.get("receiveBy"));
                fastMail.setLink(map.get("link"));
                fastMail.setReceiveCompany(map.get("receiveCompany"));
                fastMail.setReceiveCompanyAddress(map.get("receiveCompanyAddress"));
                fastMail.setExpressCompany(map.get("expressCompany"));
                fastMail.setExpressNum(map.get("expressNum"));
                fastMail.setDate(map.get("date"));
                fastMail.setRemarks(map.get("remarks"));
                fastMail.setSort(Integer.parseInt(map.get("sort")));
                for (int i=0;i<file.length;i++){
                    String filename = file[i].getOriginalFilename();
                    UUID uuid = UUID.randomUUID();
 //                 String filePath = "E:/GitWorkSpace/TianHeInfoSystemUI/mango-ui/static/file/"+uuid+filename;
                    String filePath = "D:/dist/static/file/"+uuid+filename;
                    System.err.println("----------"+filename+"-----------------------");
                    File saveDir = new File(filePath);
                    if (!saveDir.getParentFile().exists()){
                        saveDir.getParentFile().mkdirs();
                        file[i].transferTo(saveDir);
                    }else {
                        file[i].transferTo(saveDir);
                    }
                 paths+="/static/file/"+uuid+filename+";";
                }
                fastMail.setPath(paths);
                mailService.save(fastMail);
            }catch (Exception e){
                return HttpResult.error();
            }
            return  HttpResult.ok();
    }
}
