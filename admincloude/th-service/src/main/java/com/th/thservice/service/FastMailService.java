package com.th.thservice.service;

import com.th.thservice.common.CurdService;
import com.th.thservice.entity.FastMail;

public interface FastMailService extends CurdService<FastMail> {
    FastMail selectOne(FastMail record);
}
