package com.cdd.test.controller;

import com.cdd.test.pojo.Stu;
import com.cdd.test.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenyadong
 * @create 2022-09-28-21:38
 */
@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuService stuService;

    @RequestMapping("/list")
    public List<Stu> list(){
        return stuService.list();
    }
}
