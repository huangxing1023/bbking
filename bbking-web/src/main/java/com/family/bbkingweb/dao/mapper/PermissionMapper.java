package com.family.bbkingweb.dao.mapper;

import com.family.bbkingweb.dao.entity.Permission;
import com.family.bbkingweb.dao.entity.Role;

import java.util.Set;

public interface PermissionMapper {
    Set<Permission> getPermissionListByRole(Role role);
}
