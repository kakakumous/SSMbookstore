package com.bookstore.controller.manager;

import com.bookstore.domain.Orderitem;
import com.bookstore.domain.Orders;
import com.bookstore.service.OrdersService;
import com.bookstore.service.ProductsService;
import com.bookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrdersAdminController {
    @Resource
    private OrdersService os;
    @Resource
    private UserService us;
    @Resource
    private ProductsService ps;

    @RequestMapping(value = "/admin/orderlist.action")
    String showOrder(Model model) {
        List<Orders> list = os.showAllOrders();
        for (Orders o : list) {
            o.setUser_name(us.selById(o.getUser_id()).getUsername());
        }
        model.addAttribute("orders", list);
        return "admin/orders/list";
    }

    @RequestMapping(value="/admin/findOrderByManyCondition.action")
    String showSome(Model model, Orders order){
        List<Orders> list=os.showSomeOrders(order);
        for (Orders o : list) {
            o.setUser_name(us.selById(o.getUser_id()).getUsername());
        }
        model.addAttribute("orders", list);
        return "admin/orders/list";
    }
    @RequestMapping(value="/admin/delOrderById.action")
    String delProduct(Model model, String id){
        System.out.print("del");
       os.delOrderById(id);
       
        return "redirect:/admin/orderlist.action";
    }
    @RequestMapping(value="/admin/findOrderById.action")
    String findProductById(Model model, String id){
        List<Orderitem> items=os.OrderInfoById(id);
        Orders order=os.findOrderById(id);
        for (Orderitem i : items) {
            i.setProducts(ps.getGoodById(i.getProduct_id()));
        }
        model.addAttribute("items",items);
        model.addAttribute("order",order);
        return "admin/orders/view";
    }
}
