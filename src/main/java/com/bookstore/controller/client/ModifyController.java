package com.bookstore.controller.client;

import com.bookstore.domain.User;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

@Controller
public class ModifyController {
    @Autowired
    private UserService us;

    @RequestMapping(value = "/modifyuserinfo.action")
    public String modifyuserinfo(User user, Model model, HttpSession session){
        User sessionuser = (User)session.getAttribute("user");
        user.setId(sessionuser.getId());
        us.modify(user);
        System.out.print("修改成功");
        return "client/modifysuccess";
    }
}
