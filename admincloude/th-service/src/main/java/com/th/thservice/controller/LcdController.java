package com.th.thservice.controller;

import com.th.thservice.entity.HardwareLcd;
import com.th.thservice.entity.PhotoInfo;
import com.th.thservice.entity.UpdataRecord;
import com.th.thservice.http.HttpResult;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.HardwareLcdService;
import com.th.thservice.service.PhotoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("lcd")
public class LcdController {
    @Autowired
    HardwareLcdService hardwareLcdService;
    @Autowired
    PhotoInfoService photoInfoService;
    @PreAuthorize("hasAuthority('lcd:info:view')")
    @PostMapping(value="/lcdView")
    public HttpResult lcdView(@RequestBody PageRequest pageRequest) {
        PageResult page = hardwareLcdService.findPage(pageRequest);
        return HttpResult.ok(page);
    }
    @PreAuthorize("hasAuthority('lcd:info:add') and hasAuthority('lcd:info:edit')")
    @PostMapping(value="/lcdAdd")
    public HttpResult lcdAdd(@RequestBody HardwareLcd hardwareLcd) {
        int save = hardwareLcdService.save(hardwareLcd);
        return HttpResult.ok(save);
    }
    @PreAuthorize("hasAuthority('lcd:info:delete')")
    @PostMapping(value="/lcdDel")
    public HttpResult lcdDel(@RequestBody List<HardwareLcd> hardwareLcd) {
        int delete = hardwareLcdService.delete(hardwareLcd);
        return HttpResult.ok(delete);
    }
    @PreAuthorize("hasAuthority('photo:info:view')")
    @PostMapping(value="/photoInfoView")
    public HttpResult photoInfoView(@RequestBody PageRequest pageRequest) {
        PageResult page = photoInfoService.findPage(pageRequest);
        return HttpResult.ok(page);
    }
    @PreAuthorize("hasAuthority('photo:info:delete')")
    @PostMapping(value="/delPhoto")
    public HttpResult delPhoto(@RequestBody PhotoInfo photoInfo) {
        return HttpResult.ok(photoInfoService.delete(photoInfo));
    }
    @PreAuthorize("hasAuthority('photo:info:add')")
    @PostMapping(value = "/uploadFile")
    public HttpResult uploadFile(@RequestParam Map<String,String> map, @RequestParam("file") MultipartFile[] file){
       if(map.size() >0){
            try{
                PhotoInfo photoInfo = new PhotoInfo();
                String  parentId = map.get("parentId").toString();
                String  describe = map.get("describe").toString();
                String  dispalyType = map.get("dispalyType").toString();
                String  sort = map.get("sort").toString();
                photoInfo.setParentId(Integer.parseInt(parentId));
                photoInfo.setDescribe(describe);
                photoInfo.setDispalyType(dispalyType);
                photoInfo.setSort(Integer.parseInt(sort));
                System.err.println("+--------------"+sort+"---------------------");
                for (int i=0;i<file.length;i++){
                    String filename = file[i].getOriginalFilename();
                    UUID uuid = UUID.randomUUID();
//                    String filePath = "E:/GitWorkSpace/TianHeInfoSystemUI/mango-ui/dist/static/myphoto/"+uuid+filename;
                    String filePath = "D:/dist/static/myphoto/"+uuid+filename;
                    System.err.println("----------"+filename+"-----------------------");
                    File saveDir = new File(filePath);
                    if (!saveDir.getParentFile().exists()){
                        saveDir.getParentFile().mkdirs();
                        file[i].transferTo(saveDir);
                    }else {
                        file[i].transferTo(saveDir);
                    }
                    photoInfo.setPath("/static/myphoto/"+uuid+filename);
                    photoInfoService.save(photoInfo);                }
            }catch (Exception e){
                return HttpResult.error();
            }
            return  HttpResult.ok();
        }
        return  HttpResult.error();
    }

}
