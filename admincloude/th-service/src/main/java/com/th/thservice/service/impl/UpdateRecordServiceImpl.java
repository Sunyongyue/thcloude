package com.th.thservice.service.impl;

import com.th.thservice.dao.UpdataRecordMapper;
import com.th.thservice.entity.UpdataRecord;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.UpdateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UpdateRecordServiceImpl implements UpdateRecordService {
    @Autowired
    UpdataRecordMapper updataRecordMapper;
    @Override
    public int save(UpdataRecord record) {
        if (record.getId()==null||record.getId()==0){
            return updataRecordMapper.insert(record);
        }
        return updataRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(UpdataRecord record) {
        return updataRecordMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<UpdataRecord> records) {
        for (UpdataRecord record :
        records) {
            updataRecordMapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public UpdataRecord findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Integer use = Integer.parseInt( pageRequest.getParam("use")+"") ;
        Integer protocol = Integer.parseInt( pageRequest.getParam("protocol")+"");
        Integer name = Integer.parseInt( pageRequest.getParam("name")+"");
        String falg = (String) pageRequest.getParam("falg");
        Integer falgId=0;
        if(falg.equals("硬件")){
            falgId=1;
        }
        return MybatisPageHelper.findPage(pageRequest,updataRecordMapper,"findPageByparams",use,protocol,name,falgId);
    }
}
