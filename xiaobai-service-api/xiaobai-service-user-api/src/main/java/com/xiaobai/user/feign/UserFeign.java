package com.xiaobai.user.feign;

import com.xiaobai.user.pojo.TUser;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user")
//@RequestMapping("/user")
public interface UserFeign {
    /***
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/user/load/{id}")
    Result<TUser> findById(@PathVariable(value = "id") String id);
}
