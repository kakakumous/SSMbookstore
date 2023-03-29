package com.bookstore.controller.client;

import com.bookstore.domain.User;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegisterController {
    @Autowired
    private UserService us;

    @RequestMapping(value = "/register.action")
    public String register(User user, Model model,String repassword){
        User re = null;
        re = us.selByName(user.getUsername());
        if(re==null) {
            if (user.getPassword().isEmpty() || user.getUsername().isEmpty()) {
                model.addAttribute("error", "会员名和密码为必填项");
                return "client/register";
            }
            if(!user.getPassword().equals(repassword)){
                model.addAttribute("error", "重复的密码与第一次输入的不一致");
                return "client/register";
            }
            if(user.getPassword().length()>16 || user.getPassword().length()<6){
                model.addAttribute("error", "密码的长度不符合要求");
                return "client/register";
            }
            us.register(user);
            return "client/registersuccess";
        }
        else{
            model.addAttribute("error", "会员名已存在");
            return "client/register";}
    }

}
