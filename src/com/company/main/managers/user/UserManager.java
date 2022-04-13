package com.company.main.managers.user;

import com.company.helpers.Date;
import com.company.main.entities.log.abstracts.ILoggable;
import com.company.main.entities.log.abstracts.ISendable;
import com.company.main.entities.log.abstracts.Log;
import com.company.main.entities.log.abstracts.SendableLog;
import com.company.main.entities.log.concretes.*;
import com.company.main.entities.user.abstracts.User;
import com.company.main.managers.database.concretes.UserDatabaseManager;

public abstract class UserManager<T extends User> implements ILoggable
{
    protected final UserDatabaseManager userDatabaseManager;


    public UserManager(UserDatabaseManager userDatabaseManager)
    {
        this.userDatabaseManager = userDatabaseManager;
    }

    public abstract boolean register(String username, String password);

    public T login(String username, String password)
    {
        var user = userDatabaseManager.find(username);
        LogContent content;

        if (user != null)
        {
            if (user.getPassword().equals(password))
            {
                content = LogContentHolder.loginSucceed;
                log(getTargetLogs(content.forDatabase, content.forFeedback + username, Date.random(), user, LogLevel.SUCCESS));
                return ((T) user);
            }
        }

        content = LogContentHolder.loginFailed;
        log(getTargetLogs(content.forDatabase, content.forFeedback, Date.random(), User.unknown(), LogLevel.FAIL));
        return null;
    }

    public void removeUser(User user)
    {
        if (user == null) return;

        userDatabaseManager.remove(user, user);
    }

    @Override
    public void log(Log... logs)
    {
        for (var log : logs)
        {
            System.out.println(log.toLogFormat());

            try
            {
                var sendable = ((SendableLog) log);

                if (sendable.feedback != null)
                {
                    sendable.send();
                }

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
