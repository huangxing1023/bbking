package com.family.bbkingweb.service;

import com.family.bbkingdao.entity.Role;
import com.family.bbkingdao.entity.User;

import java.util.Set;

public interface RoleService {
    Set<Role> getRoleList(User user);
}
