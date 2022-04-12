package com.company;

import com.company.main.entities.database.concretes.UserDatabase;
import com.company.main.managers.database.concretes.UserDatabaseManager;
import com.company.main.managers.user.UserManager;

public class Main
{

    public static void main(String[] args)
    {
        var database = new UserDatabase();

        UserDatabaseManager databaseManager = new UserDatabaseManager(database);

        UserManager userManager = new UserManager();

        userManager.registerAsCustomer(databaseManager, "EmreBerat", "1234");


        userManager.tryLogin(databaseManager, "EmreBerat", "1234");

        userManager.removeUser(databaseManager, databaseManager.find("EmreBerat"));

        userManager.tryLogin(databaseManager, "EmreBerat", "1234");
    }

}
