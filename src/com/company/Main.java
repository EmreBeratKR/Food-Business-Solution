package com.company;

import com.company.main.entities.Order;
import com.company.main.entities.database.concretes.ProductDatabase;
import com.company.main.entities.database.concretes.UserDatabase;
import com.company.main.entities.product.abstracts.Drink;
import com.company.main.entities.product.abstracts.Food;
import com.company.main.entities.product.abstracts.Ingredient;
import com.company.main.entities.user.concretes.Customer;
import com.company.main.managers.database.concretes.UserDatabaseManager;
import com.company.main.managers.user.CustomerManager;
import com.company.main.managers.user.UserManager;

import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        var productDatabase = new ProductDatabase();

        productDatabase.add(new Food(0, "Hamburger", 65.95f));
        productDatabase.add(new Food(1, "Pizza", 57.90f));
        productDatabase.add(new Food(2, "Lahmacun", 37.50f));

        productDatabase.add(new Drink(3, "Ayran", 3.75f));
        productDatabase.add(new Drink(4, "Coke", 7.25f));
        productDatabase.add(new Drink(5, "Sprite", 6.65f));

        productDatabase.add(new Ingredient(6, "Mushroom", 0.75f));
        productDatabase.add(new Ingredient(7, "Salt", 0.15f));
        productDatabase.add(new Ingredient(8, "Ketchup", 1f));




        var database = new UserDatabase();

        UserDatabaseManager databaseManager = new UserDatabaseManager(database);

        CustomerManager customerManager = new CustomerManager();

        customerManager.registerAsCustomer(databaseManager, "EmreBerat", "1234");

        Customer customer = (Customer) customerManager.login(databaseManager, "EmreBerat", "1234");

        if (customer != null)
        {
            var foods = new ArrayList<Food>();
            foods.add((Food) productDatabase.findById(0));
            foods.add((Food) productDatabase.findById(2));

            var drinks = new ArrayList<Drink>();
            drinks.add(((Drink) productDatabase.findById(5)));

            var ingredients = new ArrayList<Ingredient>();
            ingredients.add(((Ingredient) productDatabase.findById(7)));
            ingredients.add(((Ingredient) productDatabase.findById(8)));

            var order = new Order(foods, drinks, ingredients);

            var foods1 = new ArrayList<Food>();
            foods.add((Food) productDatabase.findById(1));

            var drinks1 = new ArrayList<Drink>();

            var ingredients1 = new ArrayList<Ingredient>();
            ingredients.add(((Ingredient) productDatabase.findById(6)));

            var order1 = new Order(foods1, drinks1, ingredients1);

            var foods2 = new ArrayList<Food>();
            foods.add((Food) productDatabase.findById(0));

            var drinks2 = new ArrayList<Drink>();

            var ingredients2 = new ArrayList<Ingredient>();

            var order2 = new Order(foods2, drinks2, ingredients2);

            customerManager.makeOrder(customer, order);
            customerManager.makeOrder(customer, order1);

            customerManager.cancelOrder(customer, order);

            customerManager.changeOrder(customer, order1, order2);
        }

    }

}
