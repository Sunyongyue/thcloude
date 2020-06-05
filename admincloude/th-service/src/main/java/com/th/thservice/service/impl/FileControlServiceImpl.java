package com.th.thservice.service.impl;

import com.th.thservice.dao.FileControlMapper;
import com.th.thservice.entity.FileControl;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.FileControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FileControlServiceImpl implements FileControlService {
    @Autowired
    FileControlMapper fileControlMapper;
    @Override
    public int save(FileControl record) {
        if (record.getId()==0||record.getId()==null){
            return  fileControlMapper.insert(record);
        }
        return fileControlMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(FileControl record) {
        return fileControlMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<FileControl> records) {
        for (FileControl file:records) {
            fileControlMapper.deleteByPrimaryKey(file.getId());
        }
        return 0;
    }

    @Override
    public FileControl findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Map<String,String> fileControl = (Map<String, String>) pageRequest.getParam("fileControl");
        FileControl fileControl1 = new FileControl();
        fileControl1.setDepartment(fileControl.get("department"));
        fileControl1.setFileType(fileControl.get("fileType"));
        fileControl1.setFileName(fileControl.get("fileName"));
        fileControl1.setFileVersion(fileControl.get("fileVersion"));
        fileControl1.setCreateBy(fileControl.get("createBy"));
        fileControl1.setStartDate(fileControl.get("startDate"));
        fileControl1.setEndDate(fileControl.get("endDate"));
        return MybatisPageHelper.findPage(pageRequest,fileControlMapper,"findByParams",fileControl1);
    }
}
