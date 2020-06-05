package com.th.thservice.controller;

import com.th.thservice.entity.UpdataRecord;
import com.th.thservice.entity.UpdateContent;
import com.th.thservice.entity.UpdateRecordInfo;
import com.th.thservice.http.HttpResult;
import com.th.thservice.page.PageRequest;
import com.th.thservice.service.UpdateContentService;
import com.th.thservice.service.UpdateRecordInfoService;
import com.th.thservice.service.UpdateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/record")
public class UpdateRecordController {
    @Autowired
    UpdateRecordService updateRecordService;
    @Autowired
    UpdateRecordInfoService recordInfoService;
    @Autowired
    UpdateContentService contentService;
    @PreAuthorize("hasAuthority('up:record:add') AND hasAuthority('up:record:edit')")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody UpdataRecord record) {
        return HttpResult.ok(updateRecordService.save(record));
    }
    @PreAuthorize("hasAuthority('up:record:view')")
    @PostMapping(value="/view")
    public HttpResult view( @RequestBody PageRequest pageRequest) {
        return HttpResult.ok(updateRecordService.findPage(pageRequest));
    }
    @PreAuthorize("hasAuthority('up:record:delete')")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<UpdataRecord> records) {
        return HttpResult.ok(updateRecordService.delete(records));
    }
    //查看界面
    @PreAuthorize("hasAuthority('up:recordInfo:view')")
    @PostMapping(value="/infoView")
    public HttpResult infoView(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(recordInfoService.findPage(pageRequest));
    }
    //对Info信息进行修改界面
    @PreAuthorize("hasAuthority('up:recordInfo:edit')")
    @PostMapping(value="/modifyInfo")
    public HttpResult modifyInfo(@RequestBody HashMap<String, Long> map) {
        Long id = map.get("id");
        return HttpResult.ok(recordInfoService.findById(id));
    }
    //确认修改
    @PreAuthorize("hasAuthority('up:recordInfo:edit')")
    @PostMapping(value="/modifyInfoOver")
    public HttpResult modifyInfoOver(@RequestBody UpdateRecordInfo recordInfo) {
        int save = recordInfoService.save(recordInfo);

        Integer id = Math.toIntExact(recordInfo.getId());
        List<UpdateContent> contents = recordInfo.getContents();

        UpdateContent remove = contents.remove(contents.size()-1);

        String[] split = remove.getContent().split(";");
        remove.setContent(split[0]);
        contentService.save(remove);
        for (int i=1;i<split.length;i++) {
            UpdateContent updateContent = new UpdateContent();
            updateContent.setContent(split[i]);
            updateContent.setParentId(id);
            contentService.save(updateContent);
        }
        for (UpdateContent content: contents) {
            contentService.save(content);
            System.err.println(content.getContent()+"-------------------------------");
        }
        return HttpResult.ok(1);
    }
    //删除info界面
    @PreAuthorize("hasAuthority('up:recordInfo:delete')")
    @PostMapping(value="/deleteInfo")
    public HttpResult deleteInfo(@RequestBody HashMap<String, Long> map) {
        Long id = map.get("id");
        return HttpResult.ok(recordInfoService.deleteById(id));
    }
    //新增UpdatarecordInfo界面
    @PreAuthorize("hasAuthority('up:recordInfo:add')")
    @PostMapping(value="/addInfo")
    public HttpResult addInfo(@RequestBody HashMap<String, String> map) {
        String id = map.get("parentId");
        String upTime = map.get("upTime");
        String version = map.get("version");
        String contents = map.get("contents");
        String[] split = contents.split(";");
        int maxId = recordInfoService.selectMaxId()+1;
        Long maxIdLong = Long.valueOf(recordInfoService.selectMaxId()+1);
        UpdateRecordInfo updateRecordInfo = new UpdateRecordInfo();
        updateRecordInfo.setId(maxIdLong);
        updateRecordInfo.setParentId(Integer.parseInt(id));
        updateRecordInfo.setUpTime(upTime);
        updateRecordInfo.setSort(maxId);
        updateRecordInfo.setVersion(version);
        recordInfoService.insertHaveId(updateRecordInfo);
        for (String sp:split) {

            UpdateContent updateContent = new UpdateContent();
            updateContent.setParentId(maxId);
            updateContent.setContent(sp);
            contentService.save(updateContent);
        }
        return HttpResult.ok(1);
    }

}
