package org.itis.hib.repository;

import org.hibernate.SessionFactory;
import org.itis.hib.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImp implements OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Order> getAllOrders() {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).list();
    }

    @Override
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        return (Order) sessionFactory.getCurrentSession().load(Order.class, id);
    }
}
