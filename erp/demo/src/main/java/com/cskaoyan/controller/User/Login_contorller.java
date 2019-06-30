package com.cskaoyan.controller.User;

import com.cskaoyan.bean.User.User;
import com.cskaoyan.service.User.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Login_contorller {

    @Autowired
    LoginService loginService;

//    @RequestMapping("hello")
//    public String loginjump(){
//        return "login";
//    }


    @RequestMapping("home")
    @ResponseBody
    public User login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User userone = loginService.login(username);
        if (userone != null && password.equals(userone.getPassword())) {
            request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
            return userone;
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            return null;
        }

    }
}
