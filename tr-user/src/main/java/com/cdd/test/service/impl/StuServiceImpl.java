package com.cdd.test.service.impl;

import com.cdd.test.mapper.StuMapper;
import com.cdd.test.pojo.Stu;
import com.cdd.test.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenyadong
 * @create 2022-09-28-21:39
 */
@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

    @Override
    public List<Stu> list() {
        return stuMapper.selectList(null);
    }
}
