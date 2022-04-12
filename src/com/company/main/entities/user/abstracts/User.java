package com.company.main.entities.user.abstracts;

import com.company.main.entities.database.abstracts.IDatabaseable;

public abstract class User implements IDatabaseable
{
    public final int id;

    private String username;


    public User(int id, String username)
    {
        this.id = id;
        this.username = username;
    }


    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return this.username;
    }
}
