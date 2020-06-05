package com.th.thservice.service.impl;

import com.th.thservice.dao.ExpressManagementMapper;
import com.th.thservice.entity.ExpressManagement;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.ExpressManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExpressManagementServicelmpl implements ExpressManagementService {
    @Autowired
    ExpressManagementMapper expressManagementMapper;


    @Override
    public int save(ExpressManagement record) {
        if (record.getId() == 0) {
            return expressManagementMapper.insertSelective(record);
        }
        return expressManagementMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(ExpressManagement record) {
        return expressManagementMapper.updateByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<ExpressManagement> records) {
        for (ExpressManagement record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public ExpressManagement findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object lable=pageRequest.getParam("");
        if (lable!=null){
            return MybatisPageHelper.findPage(pageRequest,
                    expressManagementMapper,"",lable);
        }
        return MybatisPageHelper.findPage(pageRequest,expressManagementMapper);
    }
}
