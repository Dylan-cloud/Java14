package com.cskaoyan.controller.User;

import com.cskaoyan.bean.User.User;
import com.cskaoyan.service.User.impl.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("user")
@Controller
public class User_contorller {

    @Autowired
    UserService userService;

    /*
    查询列表所有成员
     */
    @RequestMapping("find")
    public String find(){
        return "user_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public List userlist(Integer page,Integer rows) throws IOException {
        PageHelper.startPage(page,rows);
        List<User> users = userService.userlist();
        return users;
    }

    /*
    添加用户
     */
    @RequestMapping("add_judge")
    public String add_judge(){
        return "user_add";
    }
    @RequestMapping("add")
    public String add(){
        return "user_add";
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String add_function( User user){
        userService.insert(user);
        return "user_list";
    }

    /*
    删除用户
     */
    @RequestMapping("delete_judge")
    public String delete_judge(){
        return "delete_add";
    }
    @RequestMapping("delete")
    public String delete(){
        return "user_delete";
    }
    @RequestMapping("delete_batch")
    public void delete_function( User user){
        userService.delete(user);
    }


    /*
    修改用户
     */
    @RequestMapping("edit_judge")
    public String edit_judege(){
        return "user_edit";
    }
    @RequestMapping("edit")
    public String edit(){
        return "user_edit";
    }
    @RequestMapping("/update_all")
    public String edit( User user){
        userService.updata(user);
        return "user_list";
    }

    /*
    查询用户信息
     */
    @RequestMapping("search_user_by_userName")
    @ResponseBody
    public List searchByUsername(String username,Integer page,Integer rows){

        PageHelper.startPage(page,rows);
        List<User> user = userService.findByUsername(username);

        return user;

    }
    @RequestMapping("search_user_by_userId")
    @ResponseBody
    public List searchByUserid(String userid,Integer page,Integer rows){

        PageHelper.startPage(page,rows);
        List<User> user = userService.findByUsername(userid);

        return user;

    }





}
