package com.th.thservice.dao;


import com.th.thservice.entity.UpdataRecord;

import java.util.List;

public interface UpdataRecordMapper {
    int deleteByPrimaryKey(Long id);
    int insert(UpdataRecord record);
    List<UpdataRecord> selectAll();
    List<UpdataRecord> findPage();
    List<UpdataRecord> findPageByparams(Integer use,Integer protocol,Integer name,Integer falgId);
    int updateByPrimaryKey(UpdataRecord record);

}
