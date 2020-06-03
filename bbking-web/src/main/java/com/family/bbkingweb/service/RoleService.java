package com.family.bbkingservice;

import com.family.bbkingdao.entity.user.Role;
import com.family.bbkingdao.entity.user.User;

import java.util.Set;

public interface RoleService {
    Set<Role> getRoleList(User user);
}
