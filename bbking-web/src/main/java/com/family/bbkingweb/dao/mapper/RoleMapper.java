package com.family.bbkingdao.mapper;

import com.family.bbkingdao.entity.user.Role;
import com.family.bbkingdao.entity.user.User;

import java.util.Set;

public interface RoleMapper {
    Set<Role> getRoleList(User user);
}
