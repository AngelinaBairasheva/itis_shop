package org.itis.hib.repository;


import org.itis.hib.domain.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAllOrders();
    void updateOrder(Order user);
    void deleteOrder(Order user);
    void addOrder(Order user);
    Order getOrderById(Integer id);
}
