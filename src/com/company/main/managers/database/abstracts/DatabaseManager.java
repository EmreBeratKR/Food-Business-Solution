package com.company.main.managers.database.abstracts;

import com.company.helpers.Date;
import com.company.main.entities.database.abstracts.Database;
import com.company.main.entities.database.abstracts.IDatabaseable;
import com.company.main.entities.log.abstracts.ILoggable;
import com.company.main.entities.log.abstracts.Log;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.user.abstracts.User;

public abstract class DatabaseManager<T extends IDatabaseable> implements ILoggable
{

    public void add(Database<T> database, T element, User raiser)
    {
        database.add(element);

        log(getTargetLogs(getAddLogContent(), Date.random(), raiser, LogLevel.SUCCESS));
    }

    public void remove(Database<T> database, T element, User raiser)
    {
        database.remove(element);

        log(getTargetLogs(getRemoveLogContent(), Date.random(), raiser, LogLevel.SUCCESS));
    }

    public abstract String getAddLogContent();

    public abstract String getRemoveLogContent();

    @Override
    public void log(Log... logs)
    {
        for (var log : logs)
        {
            System.out.println(log.toLogFormat());
        }
    }
}
