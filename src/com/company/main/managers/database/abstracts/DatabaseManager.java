package com.company.main.managers.database.abstracts;

import com.company.helpers.Date;
import com.company.main.entities.database.abstracts.Database;
import com.company.main.entities.database.abstracts.IDatabaseable;
import com.company.main.entities.log.abstracts.ILoggable;
import com.company.main.entities.log.abstracts.ISendable;
import com.company.main.entities.log.abstracts.Log;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.user.abstracts.User;

public abstract class DatabaseManager<T extends IDatabaseable> implements ILoggable
{
    protected final Database<T> database;


    public DatabaseManager(Database<T> database)
    {
        this.database = database;
    }

    public void add(T element, User raiser)
    {
        database.add(element);

        log(getTargetLogs(getAddLogContent(), getAddLogContentForFeedback(), Date.random(), raiser, LogLevel.SUCCESS));
    }

    public void remove(T element, User raiser)
    {
        database.remove(element);

        log(getTargetLogs(getRemoveLogContent(), getRemoveLogContentForFeedback(), Date.random(), raiser, LogLevel.SUCCESS));
    }

    public int getAvailableId()
    {
        return database.availableId();
    }

    public abstract String getAddLogContent();

    public abstract String getAddLogContentForFeedback();

    public abstract String getRemoveLogContent();

    public abstract String getRemoveLogContentForFeedback();

    @Override
    public void log(Log... logs)
    {
        for (var log : logs)
        {
            System.out.println(log.toLogFormat());

            try
            {
                ((ISendable) log).send();
            }
            catch (ClassCastException e)
            {
                // un-sendable logs
            }

        }
    }
}
