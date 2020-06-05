package com.th.thservice.service.impl;

import com.th.thservice.dao.FastMailMapper;
import com.th.thservice.entity.FastMail;
import com.th.thservice.page.MybatisPageHelper;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.FastMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FastMailServiceImpl implements FastMailService {
    @Autowired
    FastMailMapper fastMailMapper;
    @Override
    public int save(FastMail record) {
        if (record.getId()==0||record.getId()==null){
            return  fastMailMapper.insert(record);

        }
        return fastMailMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(FastMail record) {

        return fastMailMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<FastMail> records) {
        for (FastMail fast:
             records) {
            fastMailMapper.deleteByPrimaryKey(fast.getId());
        }
        return 0;
    }

    @Override
    public FastMail findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Map<String,String> fastMail = (Map<String, String>) pageRequest.getParam("fastMail");
        FastMail fastMail1 = new FastMail();
        fastMail1.setType(fastMail.get("type"));
        fastMail1.setModelType(fastMail.get("modelType"));
        fastMail1.setSendBy(fastMail.get("sendBy"));
        fastMail1.setReceiveBy(fastMail.get("receiveBy"));
        fastMail1.setReceiveCompany(fastMail.get("receiveCompany"));
        fastMail1.setExpressCompany(fastMail.get("expressCompany"));
        fastMail1.setExpressNum(fastMail.get("expressNum"));
        fastMail1.setStartDate(fastMail.get("startDate"));
        fastMail1.setEndDate(fastMail.get("endDate"));
        PageResult result = MybatisPageHelper.findPage(pageRequest, fastMailMapper, "findByParams", fastMail1);
        List<FastMail> content = (List<FastMail>) result.getContent();
        for (FastMail fast: content) {
            if (fast.getPath()!=null){
                List<String> list = new ArrayList<>();
                String[] split = fast.getPath().split(";");
                for (String s: split) {
                    list.add(s);
                }
                fast.setPaths(list);
            }
        }
        result.setContent(content);
        return result;
    }

    @Override
    public FastMail selectOne(FastMail record) {
        return fastMailMapper.selectOne(record);
    }
}
