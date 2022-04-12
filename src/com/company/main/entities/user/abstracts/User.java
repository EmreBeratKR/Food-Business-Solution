package com.company.main.entities.user.abstracts;

import com.company.main.entities.database.abstracts.IDatabaseable;

public abstract class User implements IDatabaseable
{
    public final int id;

    private String username;
    private String password;


    public User(int id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static User unknown()
    {
        return new User(-1, "Unknown", null)
        {

        };
    }

    @Override
    public int getId()
    {
        return this.id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return this.username;
    }
}
