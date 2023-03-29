package com.bookstore.mapper;

import com.bookstore.domain.Orders;
import com.bookstore.domain.Products;
import com.bookstore.domain.SearchBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
public interface OrdersMapper {
    List<Orders> showAllOrders();
    List<Orders> showSomeOrders(Orders orders);
    Orders findOrderById(String id);


    void createOrder(Orders orders);
    void delOrderById(String id);
    void update(Orders orders);
}
