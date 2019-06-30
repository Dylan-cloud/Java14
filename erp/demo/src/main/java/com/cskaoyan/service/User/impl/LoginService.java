package com.cskaoyan.service.User.impl;

import com.cskaoyan.bean.User.User;

import java.io.IOException;

public interface LoginService {
    public User login(String username) throws IOException;
}
