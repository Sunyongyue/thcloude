package com.th.thservice.service.impl;


import com.th.thservice.dao.UpdateContentMapper;
import com.th.thservice.dao.UpdateRecordInfoMapper;
import com.th.thservice.entity.UpdateContent;
import com.th.thservice.entity.UpdateRecordInfo;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.UpdateRecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UpdateRecordInfoImpl implements UpdateRecordInfoService {
    @Autowired
    private UpdateRecordInfoMapper updateRecordInfoMapper;
    @Autowired
    UpdateContentMapper contentMapper;
    @Override
    public int save(UpdateRecordInfo record) {
        if (record.getId()==null||record.getId()==0){
            return updateRecordInfoMapper.insert(record);
        }
        return updateRecordInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(UpdateRecordInfo record) {
        return updateRecordInfoMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<UpdateRecordInfo> records) {
        for (UpdateRecordInfo record:
             records) {
            updateRecordInfoMapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public UpdateRecordInfo findById(Long id) {
        UpdateRecordInfo byId = updateRecordInfoMapper.findById(id);
        List<UpdateContent> byParent = contentMapper.findByParent(byId.getId());
        byId.setContents(byParent);
        return byId;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Integer id = (Integer) pageRequest.getParam("id");
        PageResult pageResult = MybatisPageHelper.findPage(pageRequest, updateRecordInfoMapper,"findPageById", id);
        List<UpdateRecordInfo> recordInfos = (List<UpdateRecordInfo>) pageResult.getContent();
        for (UpdateRecordInfo recordInfo:
        recordInfos) {
            List<UpdateContent> byParent = contentMapper.findByParent(recordInfo.getId());
            recordInfo.setContents(byParent);
        }
        pageResult.setContent(recordInfos);
        return pageResult;
    }

    @Override
    public int deleteById(Long id) {
        updateRecordInfoMapper.deleteByPrimaryKey(id);
        contentMapper.deleteByPrimaryKey(id);
        return 1;
    }

    @Override
    public int selectMaxId() {
        return updateRecordInfoMapper.selectMaxId();
    }

    @Override
    public int insertHaveId(UpdateRecordInfo recordInfo) {

        return updateRecordInfoMapper.insert(recordInfo);
    }
}
