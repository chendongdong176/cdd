package com.cdd.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cdd.test.mapper.UserMapper;
import com.cdd.test.pojo.User;
import com.cdd.test.service.UserService;
import com.cdd.test.utils.JwtUtils;
import com.cdd.test.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyadong
 * @create 2022-09-28-20:18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public R login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("uname", user.getUname());
        User user1 = userMapper.selectOne(queryWrapper);
        if(Objects.isNull(user)){
            return R.error("用户名不存在或者密码错误");
        }
        if(!user.getUpwd().equals(user1.getUpwd())){
            return R.error("用户名不存在或者密码错误");
        }
        //将用户信息放到redis中
        Map<String,Object> map = new HashMap<>();
        String token = jwtUtils.generateToken(user1.getId());
        map.put("token",token);
        map.put("msg","登录成功");
        map.put("code","200");
        redisTemplate.opsForValue().set("token"+token,user1,30, TimeUnit.MINUTES);
        return R.ok(map);
    }

    @Override
    public R list() {
        return null;
    }
}
