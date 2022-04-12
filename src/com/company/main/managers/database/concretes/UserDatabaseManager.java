package com.company.main.managers.database.concretes;

import com.company.helpers.Date;
import com.company.main.entities.database.abstracts.Database;
import com.company.main.entities.log.abstracts.Log;
import com.company.main.entities.log.concretes.*;
import com.company.main.entities.user.abstracts.User;
import com.company.main.managers.database.abstracts.DatabaseManager;

public final class UserDatabaseManager extends DatabaseManager<User>
{

    public UserDatabaseManager(Database<User> database)
    {
        super(database);
    }

    public boolean contains(String username)
    {
        for (var user : database)
        {
            if (user.getUsername().equals(username)) return true;
        }

        return false;
    }

    public boolean contains(String username, String password)
    {
        for (var user : database)
        {
            if (user.getUsername().equals(username))
            {
                return user.getPassword().equals(password);
            }
        }

        return false;
    }

    public User find(String username)
    {
        for (var user : database)
        {
            if (user.getUsername().equals(username))
            {
                return user;
            }
        }

        return null;
    }

    @Override
    public String getAddLogContent()
    {
        return LogContentHolder.userAdded.forDatabase;
    }

    @Override
    public String getAddLogContentForFeedback()
    {
        return LogContentHolder.userAdded.forFeedback;
    }

    @Override
    public String getRemoveLogContent()
    {
        return LogContentHolder.userRemoved.forDatabase;
    }

    @Override
    public String getRemoveLogContentForFeedback()
    {
        return LogContentHolder.userRemoved.forFeedback;
    }

    @Override
    public Log[] getTargetLogs(String content, String userFeedback, Date date, User raiser, LogLevel level)
    {
        return new Log[]
        {
            new DatabaseLog(content, date, raiser, level),
            new EmailLog(content, userFeedback, date, raiser, level)
        };
    }
}
