package com.cdd.test;

import com.cdd.test.pojo.Stu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenyadong
 * @create 2022-10-05-16:25
 */
@SpringBootTest
public class StuTest {


    @Test
    public void test(){
        List<Stu> list = new ArrayList<>();
        list.add(new Stu(1,"张三","男"));
        list.add(new Stu(2,"李四","女"));
        List<Stu> collection = list.stream()
                .filter(stu -> stu.getSname().equals("张三")).collect(Collectors.toList());
        List<Boolean> collect = list.stream()
                .filter(stu -> stu.getSname().equals("张三"))
                .map(stu -> {
                    if(stu.getSname().equals("张三")){
                        return true;
                    }else{
                        return false;
                    }
                })
                .collect(Collectors.toList());
            System.out.println(collect);
            list.forEach(stu -> {

            });
    }
}
