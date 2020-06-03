package com.family.bbkingservice;

import com.family.bbkingdao.entity.user.Permission;
import com.family.bbkingdao.entity.user.Role;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    List<Permission> getPermissionsList(Permission permissions);
    Set<Permission> getPermissionListByRole(Role role);
}
