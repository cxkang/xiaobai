package com.xiaobai.user.controller;


import com.alibaba.fastjson.JSON;
import com.xiaobai.user.pojo.TUser;
import com.xiaobai.user.service.TuserService;
import entity.JwtUtil;
import entity.Result;
import entity.StatusCode;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
//@Api(value = "TUserController")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class TUserController {
    @Resource
    private TuserService tUserService;


    /**
     * 用户登录
     */
    @GetMapping(value = "/login")
    public Result login(String username, String password) {
        TUser user = tUserService.findByName(username);
        if (user != null && user.getClientPassword().equals(password)) {
            Map<String, Object> info = new HashMap<String, Object>();
            info.put("role", "USER");
            info.put("success", "SUCCESS");
            info.put("username", username);
            //生成令牌
            String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(info), null);
            return new Result(true, StatusCode.OK, "登录成功！", jwt);
        }
        return new Result(false, StatusCode.LOGINERROR, "账号或者密码错误！");
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping({"/{id}", "/load/{id}"})
    public Result<TUser> findById(@PathVariable String id) {
        TUser tUser = tUserService.findById(id);
        return new Result<TUser>(true, StatusCode.OK, "获取成功", tUser);
    }

    //  @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/test")
    public Result test() {
        return new Result(true, StatusCode.OK, "测试");
    }

}
