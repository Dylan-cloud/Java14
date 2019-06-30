package com.cskaoyan.service.User.impl;

import com.cskaoyan.bean.User.User;
import com.cskaoyan.mapper.User.UserMapper;

import java.util.List;

public interface UserService {

    public List userlist();
    public void insert(User user);
    public void delete(User user);
    public void updata(User user);
    public List findByUsername(String condition);
    public List findById(String condition);
}
