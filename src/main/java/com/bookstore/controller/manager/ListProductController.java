    package com.bookstore.controller.manager;

import com.bookstore.domain.Products;
import com.bookstore.domain.SearchBean;
import com.bookstore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

    @Controller
    public class ListProductController {
        @Resource
        private ProductsService ps;
        @RequestMapping(value="/admin/list.action")
        String showIndex(Model model){
            List<Products> list=ps.listAll();
            model.addAttribute("list",list);
            return "admin/products/list";
        }

        @RequestMapping(value="/admin/complex.action")
        String showSome(Model model, SearchBean searchBean){
            if(searchBean.getUpprice()!=null || searchBean.getDownprice()!=null){
                Double up=99999.0;
                Double dp=0.0;
                if(searchBean.getDownprice()==null)
                    searchBean.setDownprice(dp);
                if(searchBean.getUpprice()==null)
                    searchBean.setUpprice(up);
            }
            List<Products> list=ps.listSome(searchBean);
            model.addAttribute("list",list);
            return "admin/products/list";
        }

        @RequestMapping(value="/admin/search.action")
        String findProductById(Model model, String id){
            Products p=ps.getGoodById(id);
            model.addAttribute("product",p);
            return "admin/products/edit";
        }
        @RequestMapping(value="/admin/edit.action")
        String updateProduct(Model model,  Products products,MultipartFile file) {
            String imgFile=null;
            if(file.isEmpty())
                imgFile="";
            else {
                String newFile= UUID.randomUUID()+"-"+file.getOriginalFilename();
                File f=new File("D:/study/2021 下/gdhd/src/main/resources/static/productImg",newFile);

                if(!f.getParentFile().exists())
                    f.mkdirs();
                try {
                    file.transferTo(f);
                    imgFile="/productImg/"+newFile;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            products.setImgurl(imgFile);
            ps.addGood(products);
            return "redirect:/admin/list.action";
        }
        @RequestMapping(value="/admin/add.action")
        String addProduct(Model model, Products products,MultipartFile file){
            String imgFile=null;
            if(file.isEmpty())
                imgFile="";
            else {
                String newFile= UUID.randomUUID()+"-"+file.getOriginalFilename();
                File f=new File("D:/study/2021 下/gdhd/src/main/resources/static/productImg",newFile);

                if(!f.getParentFile().exists())
                    f.mkdirs();
                try {
                    file.transferTo(f);
                    imgFile="/productImg/"+newFile;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            products.setImgurl(imgFile);
            ps.addGood(products);
            return "redirect:/admin/list.action";
        }
        @RequestMapping(value="/admin/delete.action")
        String delProduct(Model model, String id){
            System.out.print("del");
            ps.delGood(id);
            return "redirect:/admin/list.action";
        }
    }
