package com.bookstore.controller.client;

import com.bookstore.domain.PageBean;
import com.bookstore.domain.Products;
import com.bookstore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class ProductsController {
    @Autowired
    private ProductsService ps;
    @RequestMapping(value="/client/findProductById.action")
    String findProductById(Model model, String id){
        Products p=ps.getGoodById(id);
        model.addAttribute("product",p);
        return "client/info";
    }
    @RequestMapping(value="/showProductByPage.action")
    String showProductByPage(Model model, PageBean pageBean, String category){
        pageBean.setCurrentCount(5); //设置每页记录数
        pageBean.setTotalCount(ps.getGoodCount(category));
        if(ps.getGoodCount(category)%pageBean.getCurrentCount()==0){
            pageBean.setTotalPage(ps.getGoodCount(category)/pageBean.getCurrentCount());
        }
        else{
            pageBean.setTotalPage((ps.getGoodCount(category)/pageBean.getCurrentCount())+1);
        }
        List<Products> list=ps.showGoodByPage(pageBean,category);

        model.addAttribute("product",list);
        model.addAttribute("pagebean",pageBean);
        model.addAttribute("category",category);
        return "client/product_list";
    }
    @RequestMapping(value="/findProductByName.action")
    String findProductByName(Model model, PageBean pageBean, String textfield){
        String pname="%"+textfield+"%";
        pageBean.setCurrentCount(5); //设置每页记录数
        pageBean.setTotalCount(ps.getGoodCountByName(pname));
        if(ps.getGoodCountByName(pname)%pageBean.getCurrentCount()==0){
            pageBean.setTotalPage(ps.getGoodCountByName(pname)/pageBean.getCurrentCount());
        }
        else{
            pageBean.setTotalPage((ps.getGoodCountByName(pname)/pageBean.getCurrentCount())+1);
        }
        List<Products> list=ps.showGoodByName(pageBean,pname);

        model.addAttribute("product",list);
        model.addAttribute("pagebean",pageBean);
        return "client/product_list";
    }
}
