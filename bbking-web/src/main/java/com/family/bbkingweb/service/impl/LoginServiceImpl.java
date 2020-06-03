package com.family.bbkingweb.service.impl;

import com.family.bbkingdao.entity.Permission;
import com.family.bbkingdao.entity.Role;
import com.family.bbkingdao.entity.User;
import com.family.bbkingweb.service.LoginService;
import com.family.bbkingweb.service.PermissionService;
import com.family.bbkingweb.service.RoleService;
import com.family.bbkingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public User getUserByName(String getMapByName) {
        return getMapByName(getMapByName);
    }

    private User getMapByName(String userName){
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        //查找数据库对应用户名
        User user = new User();
        user.setUsername(userName);
        List<User> userList = userService.getUserList(user);
        if(userList.size()>0){
            user = userList.get(0);
            //获取登录人角色
            Set<Role> roleSet = roleService.getRoleList(user);
            //获取角色对应权限
            Iterator<Role> it = roleSet.iterator();
            while(it.hasNext()){
                Role role = it.next();
                Set<Permission> permissionSet = permissionService.getPermissionListByRole(role);
                role.setPermission(permissionSet);
            }
            user.setRoles(roleSet);
        }
        return user;
    }
}
