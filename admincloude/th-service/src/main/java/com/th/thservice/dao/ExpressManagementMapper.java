package com.th.thservice.dao;

import com.th.thservice.entity.ExpressManagement;

import java.util.List;

public interface ExpressManagementMapper {
        int deleteByPrimaryKey(int id);

        int insect(ExpressManagement record);

        int insertSelective(ExpressManagement record);

        ExpressManagement selectByPrimaryKey(int id);

        int updateByPrimaryKeySelective(ExpressManagement record);

        int updateByPrimaryKey(int record);

        List<ExpressManagement>findPage();

}
