package com.company.main.entities;

import com.company.main.entities.product.concretes.Drink;
import com.company.main.entities.product.concretes.Food;
import com.company.main.entities.product.concretes.Ingredient;

import java.util.ArrayList;

public class Order
{
    private ArrayList<Food> foods;
    private ArrayList<Drink> drinks;
    private ArrayList<Ingredient> ingredients;


    public Order(ArrayList<Food> foods, ArrayList<Drink> drinks, ArrayList<Ingredient> ingredients)
    {
        this.foods = foods;
        this.drinks = drinks;
        this.ingredients = ingredients;
    }


    public ArrayList<Food> getFoods()
    {
        return new ArrayList<>(this.foods);
    }

    public void setFoods(ArrayList<Food> foods)
    {
        this.foods = foods;
    }

    public ArrayList<Drink> getDrinks()
    {
        return new ArrayList<>(this.drinks);
    }

    public void setDrinks(ArrayList<Drink> drinks)
    {
        this.drinks = drinks;
    }

    public ArrayList<Ingredient> getIngredients()
    {
        return new ArrayList<>(this.ingredients);
    }

    public void setIngredients(ArrayList<Ingredient> ingredients)
    {
        this.ingredients = ingredients;
    }
}
