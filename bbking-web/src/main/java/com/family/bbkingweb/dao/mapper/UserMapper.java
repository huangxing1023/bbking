package com.family.bbkingdao.mapper;

import com.family.bbkingdao.entity.user.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList(User user);
    int addUser(User user);
}
