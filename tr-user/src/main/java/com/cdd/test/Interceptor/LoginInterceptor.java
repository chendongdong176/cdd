package com.cdd.test.Interceptor;

import cn.hutool.json.JSONUtil;
import com.cdd.test.pojo.User;
import com.cdd.test.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyadong
 * @create 2022-09-28-20:42
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token==null && token==""){
            returnNoLogin(response);
            return false;
        }
        User o = (User) redisTemplate.opsForValue().get("token" + token);
        if(Objects.isNull(o)){
            returnNoLogin(response);
            return false;
        }

        redisTemplate.opsForValue().set("token"+token,o,30, TimeUnit.MINUTES);
        return true;
    }


    /**
     * 返回未登录的错误信息
     * @param response ServletResponse
     */
    private void returnNoLogin(HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        // 设置返回401 和响应编码
        response.setStatus(401);
        response.setContentType("Application/json;charset=utf-8");
        // 构造返回响应体
        String resultString = JSONUtil.toJsonStr(R.error("未登录，请先登录"));
        outputStream.write(resultString.getBytes(StandardCharsets.UTF_8));
    }
}
