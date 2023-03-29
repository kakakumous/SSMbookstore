package com.bookstore.mapper;

import com.bookstore.domain.Orderitem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    List<Orderitem> findOrderById(String id);
    void clearOrderById(String id);
}
