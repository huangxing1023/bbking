package com.family.bbkingweb.service;

import com.family.bbkingdao.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList(User user);
    int addUser(User user);
}
