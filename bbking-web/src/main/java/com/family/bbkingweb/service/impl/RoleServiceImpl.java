package com.family.bbkingweb.service.impl;

import com.family.bbkingdao.entity.Role;
import com.family.bbkingdao.entity.User;
import com.family.bbkingdao.mapper.RoleMapper;
import com.family.bbkingweb.service.RoleService;
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
