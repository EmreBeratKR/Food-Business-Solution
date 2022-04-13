package com.company.main.managers.user;

import com.company.helpers.Date;
import com.company.helpers.Day;
import com.company.main.entities.Order;
import com.company.main.entities.log.concretes.LogContentHolder;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.user.concretes.Customer;
import com.company.main.managers.database.concretes.UserDatabaseManager;

public class CustomerManager extends UserManager<Customer>
{
    public static final Day discountDay = Day.Wednesday;
    public static final float discountPercent = 10;


    public CustomerManager(UserDatabaseManager userDatabaseManager)
    {
        super(userDatabaseManager);
    }

    @Override
    public boolean register(String username, String password)
    {
        if (userDatabaseManager.contains(username)) return false;

        var user = new Customer(userDatabaseManager.getAvailableId(), username, password);

        userDatabaseManager.add(user, user);

        return true;
    }

    public void makeOrder(Customer customer, Order order)
    {
        var oldOrders = customer.getOrder();

        oldOrders.add(order);

        customer.setOrder(oldOrders);

        var content = LogContentHolder.orderMade;

        log(getTargetLogs(content.forDatabase, content.forFeedback, Date.random(), customer, LogLevel.SUCCESS));
    }

    private void removeOrder(Customer customer, Order order)
    {
        var oldOrders = customer.getOrder();

        oldOrders.remove(order);

        customer.setOrder(oldOrders);
    }

    private void removePayedOrder(Customer customer, Order order, double bill)
    {
        removeOrder(customer, order);

        var content = LogContentHolder.orderPayed;

        log(getTargetLogs(content.forDatabase, content.forFeedback + bill, Date.random(), customer, LogLevel.SUCCESS));
    }

    public void cancelOrder(Customer customer, Order order)
    {
        removeOrder(customer, order);

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

    public void payOrder(Customer customer, Order order, Day day)
    {
        float rawTotal = 0;
        float discount = 0;

        for (var drink : order.getDrinks())
        {
            rawTotal += drink.getPrice();
        }

        for (var food : order.getFoods())
        {
            rawTotal += food.getPrice();
        }

        for (var ingredient : order.getIngredients())
        {
            rawTotal += ingredient.getPrice();
        }

        if (day == discountDay)
        {
            discount = rawTotal * discountPercent * 0.01f;
        }

        float bill = rawTotal - discount;

        removePayedOrder(customer, order, bill);
    }
}
