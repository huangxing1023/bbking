package com.family.bbkingweb.controller;
import com.family.bbkingweb.shiro.ShiroEncryption;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    //注解验角色和权限
    @RequiresRoles("admin")
    //@RequiresPermissions("add")
    @RequestMapping("/getUser")
    @ResponseBody
    public Result getUser(User user) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        List<User> userList = userService.getUserList(user);
        dataMap.put("userList",userList);
        return Result.success(dataMap);
    }

    //注解验角色和权限
    @RequiresRoles("admin")
    //@RequiresPermissions("add")
    @RequestMapping("/addUser")
    public Result addUser(User user) {
        user = postUserInfo(user);
        int i = userService.addUser(user);
        return Result.success();
    }
    @RequestMapping("/testException")
    public void testException() throws Exception {
        throw new Exception("异常测试");
    }

    public User postUserInfo(User user) {
        // shiro 自带的工具类生成salt
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();

        String encodedPassword = ShiroEncryption.shiroEncryption(user.getPassword(),salt);
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        return user;
    }
}
