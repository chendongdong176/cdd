package com.cdd.test.service;

import com.cdd.test.pojo.User;
import com.cdd.test.utils.R;

/**
 * @author chenyadong
 * @create 2022-09-28-20:18
 */
public interface UserService {
    R login(User user);
}
