package com.company;

import com.company.main.entities.database.concretes.UserDatabase;
import com.company.main.entities.user.concretes.*;
import com.company.main.managers.database.concretes.UserDatabaseManager;

public class Main
{

    public static void main(String[] args)
    {
        var database = new UserDatabase();

        UserDatabaseManager manager = new UserDatabaseManager();

        var customer = new Customer(1, "EmreBerat");

        manager.add(database, customer, customer);

        manager.remove(database, customer, customer);
    }

}
