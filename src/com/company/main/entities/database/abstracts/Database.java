package com.company.main.entities.database.abstracts;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Database<T extends IDatabaseable> implements Iterable<T>
{
    private final ArrayList<T> datas;


    public Database()
    {
        this.datas = new ArrayList<>();
    }

    public Database(ArrayList<T> datas)
    {
        this.datas = datas;
    }


    public void add(T element)
    {
        datas.add(element);
    }

    public void remove(T element)
    {
        datas.remove(element);
    }

    @Override
    public Iterator<T> iterator()
    {
        return datas.iterator();
    }
}
