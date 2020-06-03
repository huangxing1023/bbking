package com.family.bbkingdao.mapper;

import com.family.bbkingdao.entity.user.Permission;
import com.family.bbkingdao.entity.user.Role;

import java.util.Set;

public interface PermissionMapper {
    Set<Permission> getPermissionListByRole(Role role);
}
