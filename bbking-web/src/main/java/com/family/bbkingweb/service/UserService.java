package com.family.bbkingweb.service;

import com.family.bbkingweb.dao.entity.user.User;

import java.util.List;

public interface UserService {
    List<User> getUserList(User user);
    int addUser(User user);
}
