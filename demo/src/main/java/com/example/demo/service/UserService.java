package com.example.demo.service;

import com.example.demo.dto.Role;
import com.example.demo.dto.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoletoUser(String userName,String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
