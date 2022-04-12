package com.company.main.entities.product.abstracts;

import com.company.main.entities.database.abstracts.IDatabaseable;

public abstract class Product implements IDatabaseable
{
    private final int id;
    private String name;
    private float price;

    public Product(int id, String name, float price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getPrice()
    {
        return this.price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    @Override
    public int getId()
    {
        return this.id;
    }
}
