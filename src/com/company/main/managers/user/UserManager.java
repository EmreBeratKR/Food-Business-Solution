package com.company.main.managers.user;

import com.company.helpers.Date;
import com.company.main.entities.log.abstracts.ILoggable;
import com.company.main.entities.log.abstracts.ISendable;
import com.company.main.entities.log.abstracts.Log;
import com.company.main.entities.log.concretes.*;
import com.company.main.entities.user.abstracts.User;
import com.company.main.entities.user.concretes.Customer;
import com.company.main.managers.database.concretes.UserDatabaseManager;

public class UserManager implements ILoggable
{
    public boolean registerAsCustomer(UserDatabaseManager manager, String username, String password)
    {
        if (manager.contains(username)) return false;

        var user = new Customer(manager.getAvailableId(), username, password);

        manager.add(user, user);

        return true;
    }

    public User login(UserDatabaseManager manager, String username, String password)
    {
        var user = manager.find(username);
        LogContent content;

        if (user != null)
        {
            if (user.getPassword().equals(password))
            {
                content = LogContentHolder.loginSucceed;
                log(getTargetLogs(content.forDatabase, content.forFeedback, Date.random(), user, LogLevel.SUCCESS));
                return user;
            }
        }

        content = LogContentHolder.loginFailed;
        log(getTargetLogs(content.forDatabase, content.forFeedback, Date.random(), User.unknown(), LogLevel.FAIL));
        return null;
    }

    public void removeUser(UserDatabaseManager manager, User user)
    {
        if (user == null) return;

        manager.remove(user, user);
    }

    @Override
    public void log(Log... logs)
    {
        for (var log : logs)
        {
            System.out.println(log.toLogFormat());

            try
            {
                var sendable = ((ISendable) log);

                sendable.send();
            }
            catch (ClassCastException e)
            {
                // un-sendable
            }
        }
    }

    @Override
    public Log[] getTargetLogs(String content, String userFeedback, Date date, User raiser, LogLevel level)
    {
        return new Log[]
        {
            new DatabaseLog(content, date, raiser, level),
            new SmsLog(content, userFeedback, date, raiser, level)
        };
    }
}
