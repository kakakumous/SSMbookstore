package com.bookstore.controller.client;

import com.bookstore.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping(value = "/client/logout.action")
    public String logout(User user, Model model, HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/client/account.action")
    public String account(User user, Model model, HttpSession session) {
        if(session.getAttribute("user")!=null) {
            User u= (User) session.getAttribute("user");
            if (u.getRole().equals("超级用户")){
                return "/admin/login/home";
            } else
                return "client/myAccount";
        }
        else
            return "client/login";
    }
}
