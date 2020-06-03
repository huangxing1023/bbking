package com.family.bbkingweb.dao.mapper;

import com.family.bbkingweb.dao.entity.user.Role;
import com.family.bbkingweb.dao.entity.user.User;

import java.util.Set;

public interface RoleMapper {
    Set<Role> getRoleList(User user);
}
