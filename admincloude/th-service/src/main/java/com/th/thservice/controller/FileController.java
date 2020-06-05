package com.th.thservice.controller;

import com.th.thservice.entity.FastMail;
import com.th.thservice.entity.FileControl;
import com.th.thservice.http.HttpResult;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.FileControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("fileControl")
public class FileController {
    @Autowired
    FileControlService fileControlService;
    @PreAuthorize("hasAuthority('file:control:view')")
    @PostMapping(value="/view")
    public HttpResult view(@RequestBody PageRequest pageRequest) {
        PageResult page = fileControlService.findPage(pageRequest);
        return HttpResult.ok(page);
}
    @PreAuthorize("hasAuthority('file:control:add') and hasAuthority('file:control:edit')")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody FileControl fileControl) {

        return HttpResult.ok(fileControlService.save(fileControl));
    }
    @PreAuthorize("hasAuthority('file:control:delete')")
    @PostMapping(value="/del")
    public HttpResult del(@RequestBody List<FileControl> fileControls) {

        return HttpResult.ok(fileControlService.delete(fileControls));
    }
    @PreAuthorize("hasAuthority('file:control:add')")
    @PostMapping(value = "/uploadFile")
    public HttpResult uploadFile(@RequestParam Map<String,String> map, @RequestParam("file") MultipartFile[] file){
        System.err.println(map);
        try{
            FileControl fileControl = new FileControl();
            fileControl.setId(Long.valueOf(map.get("id")));
            fileControl.setFileType(map.get("fileType"));
            fileControl.setFileName(map.get("fileName"));
            fileControl.setFileVersion(map.get("fileVersion"));
            fileControl.setDepartment(map.get("department"));
            fileControl.setRemarks(map.get("remarks"));
            fileControl.setSort(Integer.parseInt(map.get("sort")));

            for (int i=0;i<file.length;i++){
                String filename = file[i].getOriginalFilename();
                UUID uuid = UUID.randomUUID();
         //       String filePath = "E:/GitWorkSpace/TianHeInfoSystemUI/mango-ui/static/file/"+uuid+filename;
                                   String filePath = "D:/dist/static/file/"+uuid+filename;
                System.err.println("----------"+filename+"-----------------------");
                File saveDir = new File(filePath);
                if (!saveDir.getParentFile().exists()){
                    saveDir.getParentFile().mkdirs();
                    file[i].transferTo(saveDir);
                }else {
                    file[i].transferTo(saveDir);
                }

                fileControl.setFilepath("/static/file/"+uuid+filename);
                fileControlService.save(fileControl);
            }
        }catch (Exception e){
            return HttpResult.error();
        }
        return  HttpResult.ok();
    }
}
