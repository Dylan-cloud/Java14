package com.cskaoyan.service.User;

import com.cskaoyan.bean.User.User;
import com.cskaoyan.bean.User.UserExample;
import com.cskaoyan.mapper.User.UserMapper;
import com.cskaoyan.service.User.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LoginserviceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String username) throws IOException {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        User userone = users.get(0);

        return userone;

    }
}
