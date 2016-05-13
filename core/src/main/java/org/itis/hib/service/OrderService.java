package org.itis.hib.service;


import org.itis.hib.domain.Order;
import org.itis.hib.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Transactional
    public void addOrder(Order order){orderDAO.addOrder(order);
    }
    @Transactional
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }
    @Transactional
    public void deleteOrder(Order order) {
        orderDAO.deleteOrder(order);
    }
    @Transactional
    public Order getOrderById(Integer id) {
        return orderDAO.getOrderById(id);

    }
    @Transactional
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

}