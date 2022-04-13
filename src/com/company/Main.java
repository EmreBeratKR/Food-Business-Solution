package com.company;

import com.company.helpers.Day;
import com.company.main.entities.Order;
import com.company.main.entities.database.concretes.ProductDatabase;
import com.company.main.entities.database.concretes.UserDatabase;
import com.company.main.entities.product.concretes.Drink;
import com.company.main.entities.product.concretes.Food;
import com.company.main.entities.product.concretes.Ingredient;
import com.company.main.entities.user.concretes.Customer;
import com.company.main.entities.user.concretes.Employee;
import com.company.main.managers.database.concretes.UserDatabaseManager;
import com.company.main.managers.user.CustomerManager;
import com.company.main.managers.user.EmployeeManager;

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

        CustomerManager customerManager = new CustomerManager(databaseManager);

        EmployeeManager employeeManager = new EmployeeManager(databaseManager);

        customerManager.register("EmreBerat", "1234");

        employeeManager.register("Berkay7", "password");

        Customer customer = customerManager.login("EmreBerat", "1234");

        Employee employee = employeeManager.login("Berkay7", "password");

        employeeManager.setPosition(employee, "CEO");
        employeeManager.setSalary(employee, 25000.90);
        employeeManager.fire(employee);

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
            foods1.add((Food) productDatabase.findById(1));

            var drinks1 = new ArrayList<Drink>();

            var ingredients1 = new ArrayList<Ingredient>();
            ingredients1.add(((Ingredient) productDatabase.findById(6)));

            var order1 = new Order(foods1, drinks1, ingredients1);

            var foods2 = new ArrayList<Food>();
            foods2.add((Food) productDatabase.findById(0));

            var drinks2 = new ArrayList<Drink>();

            var ingredients2 = new ArrayList<Ingredient>();

            var order2 = new Order(foods2, drinks2, ingredients2);

            customerManager.makeOrder(customer, order);
            customerManager.makeOrder(customer, order1);

            customerManager.cancelOrder(customer, order);

            customerManager.changeOrder(customer, order1, order2);

            customerManager.payOrder(customer, order2, Day.random());
        }

    }

}
