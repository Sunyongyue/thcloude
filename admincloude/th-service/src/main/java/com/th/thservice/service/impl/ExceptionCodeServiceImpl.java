package com.th.thservice.service.impl;

import com.th.thservice.dao.ExceptionCodeMapper;
import com.th.thservice.entity.ExceptionCode;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.ExceptionCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExceptionCodeServiceImpl implements ExceptionCodeService {
    @Autowired
    ExceptionCodeMapper codeMapper;

    @Override
    public int save(ExceptionCode record) {
        if (record.getId()==0||record.getId()==null){
            return codeMapper.insert(record);
        }
        return codeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(ExceptionCode record) {
        return codeMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<ExceptionCode> records) {
        for (ExceptionCode record:
             records) {
            codeMapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public ExceptionCode findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        String model = pageRequest.getParam("model")+"";
        return MybatisPageHelper.findPage(pageRequest,codeMapper,"findByParams",model);
    }
}
