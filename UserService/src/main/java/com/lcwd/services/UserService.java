package com.lcwd.services;

import com.lcwd.entity.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);


    //get all users
    List<User> getAllUsers();

    //get user by id
    User getUser(String userId);

    //update user by id
    User updateUser(String userId,User user);

    //delete user by id
    void deleteUser(String userId);
}
