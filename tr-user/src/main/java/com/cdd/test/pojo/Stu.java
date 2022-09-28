package com.cdd.test.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chenyadong
 * @create 2022-09-28-21:36
 */
@Data
@TableName("t_stu")
public class Stu {
    private Integer id;

    private String sname;

    private String sex;
}
