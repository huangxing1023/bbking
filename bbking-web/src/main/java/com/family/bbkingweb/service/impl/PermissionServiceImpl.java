package com.family.bbkingweb.service.impl;

import com.family.bbkingweb.dao.entity.user.Permission;
import com.family.bbkingweb.dao.entity.user.Role;
import com.family.bbkingweb.dao.mapper.PermissionMapper;
import com.family.bbkingweb.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service(value = "permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> getPermissionsList(Permission permission) {
        return null;
    }

    @Override
    public Set<Permission> getPermissionListByRole(Role role) {
        return permissionMapper.getPermissionListByRole(role);
    }
}
