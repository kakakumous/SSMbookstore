package com.bookstore.service;

import com.bookstore.domain.PageBean;
import com.bookstore.domain.Products;
import com.bookstore.domain.SearchBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductsService {
    List<Products> listAll();
    List<Products> listSome(SearchBean searchBean);
    List<Products> getSalTimeProduct();
    Products getGoodById(String id);
    List<Products> showGoodByPage(PageBean pageBean, String category);
    int getGoodCount(String category);
    List<Products> showGoodByName(PageBean pageBean, String name);
    int getGoodCountByName(String name);

    void addGood(Products products);
    void delGood(String id);
    void update(Products products);


}
