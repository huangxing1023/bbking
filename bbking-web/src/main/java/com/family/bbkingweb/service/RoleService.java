package com.family.bbkingweb.service;

import com.family.bbkingweb.dao.entity.user.Role;
import com.family.bbkingweb.dao.entity.user.User;

import java.util.Set;

public interface RoleService {
    Set<Role> getRoleList(User user);
}
