package com.th.thservice.dao;

import com.th.thservice.entity.FileControl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileControlMapper {
    int deleteByPrimaryKey(Long id);
    int insert(FileControl record);
    List<FileControl> findAll();
    int updateByPrimaryKey(FileControl record);
    List<FileControl>findByParams(FileControl record);
}
