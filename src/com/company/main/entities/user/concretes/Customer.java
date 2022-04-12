package com.company.main.entities.user.concretes;

import com.company.main.entities.Order;
import com.company.main.entities.user.abstracts.User;

import java.util.ArrayList;

public class Customer extends User
{
    private ArrayList<Order> orders;


    public Customer(int id, String username, String password)
    {
        super(id, username, password);
        orders = new ArrayList<>();
    }


    public ArrayList<Order> getOrder()
    {
        return new ArrayList<>(this.orders);
    }

    public void setOrder(ArrayList<Order> order)
    {
        this.orders = order;
    }
}
