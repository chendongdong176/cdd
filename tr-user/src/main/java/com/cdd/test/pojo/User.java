package com.cdd.test.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenyadong
 * @create 2022-09-28-20:19
 */
@Data
@TableName("t_user")
public class User implements Serializable {
    private Integer id;

    private String uname;

    private String upwd;

}
