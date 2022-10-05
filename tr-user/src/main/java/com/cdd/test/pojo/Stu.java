package com.cdd.test.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenyadong
 * @create 2022-09-28-21:36
 */
@Data
@TableName("t_stu")
@AllArgsConstructor
@NoArgsConstructor
public class Stu {
    private Integer id;

    private String sname;

    private String sex;
}
