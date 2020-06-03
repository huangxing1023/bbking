package com.family.bbkingservice.impl;

import com.family.bbkingdao.entity.user.Role;
import com.family.bbkingdao.entity.user.User;
import com.family.bbkingdao.mapper.RoleMapper;
import com.family.bbkingservice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Set<Role> getRoleList(User user) {
        return roleMapper.getRoleList(user);
    }
}
