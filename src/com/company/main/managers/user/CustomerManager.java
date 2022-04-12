package com.company.main.managers.user;

import com.company.helpers.Date;
import com.company.main.entities.Order;
import com.company.main.entities.log.concretes.LogContentHolder;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.user.concretes.Customer;

public class CustomerManager extends UserManager
{
    public void makeOrder(Customer customer, Order order)
    {
        var oldOrders = customer.getOrder();

        oldOrders.add(order);

        customer.setOrder(oldOrders);

        var content = LogContentHolder.orderMade;

        log(getTargetLogs(content.forDatabase, content.forFeedback, Date.random(), customer, LogLevel.SUCCESS));
    }

    public void cancelOrder(Customer customer, Order order)
    {
        var oldOrders = customer.getOrder();

        oldOrders.remove(order);

        customer.setOrder(oldOrders);

        var content = LogContentHolder.orderCancelled;

        log(getTargetLogs(content.forDatabase, content.forFeedback, Date.random(), customer, LogLevel.SUCCESS));
    }

    public void changeOrder(Customer customer, Order order, Order newOrder)
    {
        var oldOrders = customer.getOrder();

        oldOrders.remove(order);

        oldOrders.add(newOrder);

        customer.setOrder(oldOrders);

        var content = LogContentHolder.orderChanged;

        log(getTargetLogs(content.forDatabase, content.forFeedback, Date.random(), customer, LogLevel.SUCCESS));
    }
}
