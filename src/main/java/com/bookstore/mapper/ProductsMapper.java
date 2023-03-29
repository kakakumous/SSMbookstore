package com.bookstore.mapper;

import com.bookstore.domain.Products;
import com.bookstore.domain.SearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductsMapper {
    List<Products> showAllGood();
    List<Products> showSomeGood(SearchBean searchBean);
    List<Products> getNewGood();
    Products getGoodById(String id);
    List<Products> showGoodByPage(int currentPage, int currentCount);
    int getGoodCount();
    List<Products> showCGoodByPage(int currentPage, int currentCount, String category);
    int getCGoodCount(String category);
    List<Products> showNGoodByPage(int currentPage, int currentCount, String name);
    int getNGoodCount(String name);

    void addGood(Products products);

    void delGood(String id);

    void update(Products products);
}
