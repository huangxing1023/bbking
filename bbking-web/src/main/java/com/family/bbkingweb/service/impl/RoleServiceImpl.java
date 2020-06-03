package com.family.bbkingweb.service.impl;

import com.family.bbkingweb.dao.entity.user.Role;
import com.family.bbkingweb.dao.entity.user.User;
import com.family.bbkingweb.dao.mapper.RoleMapper;
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
