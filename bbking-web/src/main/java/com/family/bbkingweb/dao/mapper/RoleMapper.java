package com.family.bbkingweb.dao.mapper;

import com.family.bbkingweb.dao.entity.Role;
import com.family.bbkingweb.dao.entity.User;

import java.util.Set;

public interface RoleMapper {
    Set<Role> getRoleList(User user);
}
