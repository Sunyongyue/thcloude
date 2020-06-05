package com.th.thservice.service.impl;

import com.th.thservice.dao.PhotoInfoMapper;
import com.th.thservice.entity.PhotoInfo;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.PhotoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotoInfoServiceImpl implements PhotoInfoService {
    @Autowired
    PhotoInfoMapper photoInfoMapper;
    @Override
    public int save(PhotoInfo record) {
        if (record.getId()==null||record.getId()==0){
            return  photoInfoMapper.insert(record);
        }
        return photoInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(PhotoInfo record) {
        return photoInfoMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<PhotoInfo> records) {
        for (PhotoInfo record:
        records) {
            photoInfoMapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public PhotoInfo findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Integer id = (Integer) pageRequest.getParam("id");
        PageResult pageResult = MybatisPageHelper.findPage(pageRequest, photoInfoMapper,"findByParent", id);
        return pageResult;
    }
}
