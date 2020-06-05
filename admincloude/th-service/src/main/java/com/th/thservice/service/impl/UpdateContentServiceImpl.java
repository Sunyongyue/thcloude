package com.th.thservice.service.impl;

import com.th.thservice.dao.UpdateContentMapper;
import com.th.thservice.entity.UpdateContent;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.UpdateContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UpdateContentServiceImpl implements UpdateContentService {
    @Autowired
    UpdateContentMapper updateContentMapper;
    @Override
    public int save(UpdateContent record) {
        if (record.getId()==0){
            return updateContentMapper.insert(record);
        }
        return updateContentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(UpdateContent record) {
        return updateContentMapper.deleteByPrimaryKey((long) record.getId());
    }

    @Override
    public int delete(List<UpdateContent> records) {
        for (UpdateContent record:
             records) {
            return updateContentMapper.deleteByPrimaryKey((long) record.getId());
        }
        return 1;
    }

    @Override
    public UpdateContent findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }


}
