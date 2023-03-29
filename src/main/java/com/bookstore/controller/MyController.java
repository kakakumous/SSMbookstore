package com.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {


    @RequestMapping("/")
    public String quick(Model model){

        return "redirect:/client/ShowIndex.action";
    }

    @RequestMapping("/jump.action")
    public String jump(Model model,String page){
        return page;
    }
}
