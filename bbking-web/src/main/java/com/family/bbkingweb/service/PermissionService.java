package com.family.bbkingweb.service;

import com.family.bbkingweb.dao.entity.user.Permission;
import com.family.bbkingweb.dao.entity.user.Role;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    List<Permission> getPermissionsList(Permission permissions);
    Set<Permission> getPermissionListByRole(Role role);
}
