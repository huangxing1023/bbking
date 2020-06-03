package com.family.bbkingweb.dao.mapper;

import com.family.bbkingweb.dao.entity.user.Permission;
import com.family.bbkingweb.dao.entity.user.Role;

import java.util.Set;

public interface PermissionMapper {
    Set<Permission> getPermissionListByRole(Role role);
}
