package com.bookstore.service;

import com.bookstore.domain.*;

import java.util.List;

public interface OrdersService {
    List<Orders> showAllOrders();
    List<Orders> showSomeOrders(Orders orders);
    Orders findOrderById(String id);

    void createOrder(Orders orders);
    void delOrderById(String id);
    void update(Orders orders);

    List<Orderitem> OrderInfoById(String id);

}
