package com.bookstore.service.impl;

import com.bookstore.domain.Orderitem;
import com.bookstore.domain.Orders;
import com.bookstore.mapper.OrderItemMapper;
import com.bookstore.mapper.OrdersMapper;
import com.bookstore.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    OrdersMapper ordersMapper;
    @Resource
    OrderItemMapper orderItemMapper;

    @Override
    public List<Orders> showAllOrders() {
        List<Orders> orders=ordersMapper.showAllOrders();
        return orders;
    }

    @Override
    public List<Orders> showSomeOrders(Orders orders) {
        List<Orders> sorders=ordersMapper.showSomeOrders(orders);
        return sorders;
    }

    @Override
    public Orders findOrderById(String id) {
        Orders order=ordersMapper.findOrderById(id);
        return order;
    }

    @Override
    public void createOrder(Orders orders) {
        ordersMapper.createOrder(orders);
    }

    @Override
    public void delOrderById(String id) {
        ordersMapper.delOrderById(id);
        orderItemMapper.clearOrderById(id);
    }

    @Override
    public void update(Orders orders) {
        ordersMapper.update(orders);

    }

    @Override
    public List<Orderitem> OrderInfoById(String id) {
        List<Orderitem> orderitem=orderItemMapper.findOrderById(id);
        return orderitem;
    }
}
