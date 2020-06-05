package com.th.thservice.dao;



import com.th.thservice.entity.UpdateRecordInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpdateRecordInfoMapper {
    int deleteByPrimaryKey(Long id);
    int insert(UpdateRecordInfo record);
    UpdateRecordInfo findById(Long id);
    List<UpdateRecordInfo> findPageById(@Param(value = "id") Integer id);
    List<UpdateRecordInfo> findPage(@Param(value = "id") int id);
    int updateByPrimaryKey(UpdateRecordInfo record);
    int selectMaxId();
}
