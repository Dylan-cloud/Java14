/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ToHome
 * Author:   Administrator
 * Date:     2019/6/27 22:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.az.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/6/27
 * @since 1.0.0
 */
@Controller
public class ToHome {
    //跳转list页面
    @RequestMapping("/")
    public String toHome() {
        return "/WEB-INF/jsp/home.jsp";
    }
}