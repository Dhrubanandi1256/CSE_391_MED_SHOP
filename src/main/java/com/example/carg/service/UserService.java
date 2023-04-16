package com.example.carg.service;

import com.example.carg.model.UserDtls;


public interface UserService {
    public UserDtls createUser(UserDtls user);
    public boolean checkEmail(String email);
}
