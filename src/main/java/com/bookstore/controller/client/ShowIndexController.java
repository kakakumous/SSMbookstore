package com.bookstore.controller.client;

import com.bookstore.domain.Products;
import com.bookstore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShowIndexController {
    @Autowired
    private ProductsService ps;

@RequestMapping(value="/client/ShowIndex.action")
    String showIndex(Model model){
        List<Products> list=ps.getSalTimeProduct();
        model.addAttribute("list",list);
        return "client/index";
    }
}
