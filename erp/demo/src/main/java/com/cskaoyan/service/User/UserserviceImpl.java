package com.cskaoyan.service.User;


import com.cskaoyan.bean.User.User;
import com.cskaoyan.bean.User.UserExample;
import com.cskaoyan.mapper.User.UserMapper;
import com.cskaoyan.service.User.impl.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class UserserviceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    /*
    获取表中全部数据，并返回显示
     */
    @Override
   public List userlist() {

       UserExample userExample = new UserExample();

       UserExample.Criteria criteria = userExample.createCriteria();
       criteria.andIdNotEqualTo("asd");
       List<User> users = userMapper.selectByExample(userExample);
       return users;


    }

    /*
    对数据库进行添加
     */
    @Override
    public void insert( User user) {

        userMapper.insert(user);

    }

    /*
    删除操作
     */
    @Override
    public void delete(User user ) {

        userMapper.deleteByPrimaryKey(user.getId());

    }

    /*
    编辑操作
     */
    @Override
    public void updata(User user) {

        userMapper.deleteByPrimaryKey(user.getId());


    }

    /*
    根据输入的不同值查找
     */
    @Override
    public List findByUsername(String username) {
        UserExample userExample = new UserExample();

        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameLike(username);
        List<User> users = userMapper.selectByExample(userExample);

        return users;

    }

    @Override
    public List findById(String id) {
        UserExample userExample = new UserExample();

        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameLike(id);
        List<User> users = userMapper.selectByExample(userExample);

        return users;
    }


}
