package com.family.bbkingservice;

import com.family.bbkingdao.entity.user.User;

import java.util.List;

public interface UserService {
    List<User> getUserList(User user);
    int addUser(User user);
}
