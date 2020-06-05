package com.th.thservice.service.impl;

import com.th.thservice.dao.HardwareLcdMapper;
import com.th.thservice.entity.HardwareLcd;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.HardwareLcdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HardwareLcdServiceImpl implements HardwareLcdService {
    @Autowired
    private HardwareLcdMapper hardwareLcdMapper;

    @Override
    public int save(HardwareLcd record) {
        if(record.getId() == null || record.getId() == 0) {
            return hardwareLcdMapper.insert(record);
        }
        return hardwareLcdMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(HardwareLcd record) {
        return hardwareLcdMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<HardwareLcd> records) {
        for(HardwareLcd record:records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public HardwareLcd findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Integer use = Integer.parseInt( pageRequest.getParam("use")+"") ;
        Integer protocol = Integer.parseInt( pageRequest.getParam("protocol")+"");
        Integer model = Integer.parseInt( pageRequest.getParam("model")+"");
        return MybatisPageHelper.findPage(pageRequest,hardwareLcdMapper,"findByParams",use,protocol,model);
    }
}
