package com.bookstore.controller.client;
import com.bookstore.domain.User;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class IfLoginController {
    @Autowired
    private UserService us;

    @RequestMapping(value = "/client/iflogin.action")
    public String login(String page, Model model,HttpSession session) {
        User sessionuser = (User)session.getAttribute("user");
        if(sessionuser==null)
            return "client/error/privilege";
        else
            return page;

    }
}
