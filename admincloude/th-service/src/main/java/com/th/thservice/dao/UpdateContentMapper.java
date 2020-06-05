package com.th.thservice.dao;

import com.th.thservice.entity.UpdateContent;

import java.util.List;

public interface UpdateContentMapper {
    int deleteByPrimaryKey(Long id);
    int insert(UpdateContent record);
    List<UpdateContent> findByParent(Long id);
    int updateByPrimaryKey(UpdateContent record);
}
