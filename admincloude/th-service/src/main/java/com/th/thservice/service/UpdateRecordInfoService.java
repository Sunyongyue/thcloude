package com.th.thservice.service;

import com.th.thservice.common.CurdService;
import com.th.thservice.entity.UpdateRecordInfo;

public interface UpdateRecordInfoService extends CurdService<UpdateRecordInfo> {
    int deleteById(Long id);
    int selectMaxId();
    int insertHaveId(UpdateRecordInfo recordInfo);
}
