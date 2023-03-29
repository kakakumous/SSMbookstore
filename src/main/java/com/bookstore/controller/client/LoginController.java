package com.bookstore.controller.client;

import com.bookstore.domain.User;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value={"user"})
public class LoginController {
    @Autowired
    private UserService us;

    @RequestMapping(value = "/client/login.action")
    public String login(User user, Model model) {
        User re = null;
        re = us.selByName(user.getUsername());
        if (re != null) {
            if (re.getPassword().equals(user.getPassword())) {
                model.addAttribute("user", re);
                if (re.getRole().equals("超级用户")) {
                    return "/admin/login/home";
                } else
                    return "client/myAccount";
            } else {
                model.addAttribute("error", "密码错误");
                return "client/login";
            }
        } else {
            model.addAttribute("error", "用户名不存在");
            return "client/login";
        }
    }


}
