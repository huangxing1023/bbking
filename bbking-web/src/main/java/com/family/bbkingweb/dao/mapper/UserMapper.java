package com.family.bbkingweb.dao.mapper;

import com.family.bbkingweb.dao.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList(User user);
    int addUser(User user);
}
