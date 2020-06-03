package com.family.bbkingweb.service;

import com.family.bbkingdao.entity.Permission;
import com.family.bbkingdao.entity.Role;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    List<Permission> getPermissionsList(Permission permissions);
    Set<Permission> getPermissionListByRole(Role role);
}
