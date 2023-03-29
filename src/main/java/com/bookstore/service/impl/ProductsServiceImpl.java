package com.bookstore.service.impl;


import com.bookstore.domain.PageBean;
import com.bookstore.domain.Products;
import com.bookstore.domain.SearchBean;
import com.bookstore.mapper.ProductsMapper;
import com.bookstore.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Resource
    private ProductsMapper pd;


    @Override
    public List<Products> listAll() {
        List<Products> books=pd.showAllGood();
        return books;
    }

    @Override
    public List<Products> listSome(SearchBean searchBean) {
        List<Products> books=pd.showSomeGood(searchBean);
        return books;
    }

    @Override
    public List<Products> getSalTimeProduct() {
        List<Products> books=pd.getNewGood();
        return books;
    }

    @Override
    public Products getGoodById(String id) {
        Products p=pd.getGoodById(id);
        return p;
    }

    @Override
    public List<Products> showGoodByPage(PageBean pageBean, String category) {
        List<Products> list=null;
        if(category.equals("全部商品")){

            list=pd.showGoodByPage(pageBean.getCurrentPage()*pageBean.getCurrentCount(),pageBean.getCurrentCount());
        }
        else{
            list=pd.showCGoodByPage(pageBean.getCurrentPage()*pageBean.getCurrentCount(),pageBean.getCurrentCount(),category);
        }
        return list;
    }

    @Override
    public int getGoodCount(String category) {
        int c;
        if(category.equals("全部商品")){
            c=pd.getGoodCount();
        }
        else{
            c=pd.getCGoodCount(category);
        }
        return c;

    }

    @Override
    public List<Products> showGoodByName(PageBean pageBean, String name) {
        return pd.showNGoodByPage(pageBean.getCurrentPage()*pageBean.getCurrentCount(),pageBean.getCurrentCount(),name);
    }

    @Override
    public int getGoodCountByName(String name) {
        return pd.getNGoodCount(name);
    }

    @Override
    public void addGood(Products products) {
        pd.addGood(products);
    }

    @Override
    public void delGood(String id) {
        pd.delGood(id);
    }

    @Override
    public void update(Products products) {
        pd.update(products);
    }


}
