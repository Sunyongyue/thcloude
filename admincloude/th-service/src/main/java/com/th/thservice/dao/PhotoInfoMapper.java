package com.th.thservice.dao;


import com.th.thservice.entity.PhotoInfo;

import java.util.List;

public interface PhotoInfoMapper {
    int deleteByPrimaryKey(Long id);
    int insert(PhotoInfo record);
    List<PhotoInfo> findByParent(Integer id);
    int updateByPrimaryKey(PhotoInfo record);
}
