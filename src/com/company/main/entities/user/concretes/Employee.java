package com.company.main.entities.user.concretes;

import com.company.main.entities.user.abstracts.User;

public class Employee extends User
{
    private String position;
    private double salary;


    public Employee(int id, String username, String password)
    {
        super(id, username, password);
    }

    public Employee(int id, String username, String password, String position, double salary)
    {
        super(id, username, password);
        this.position = position;
        this.salary = salary;
    }


    public String getPosition()
    {
        return this.position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
}
