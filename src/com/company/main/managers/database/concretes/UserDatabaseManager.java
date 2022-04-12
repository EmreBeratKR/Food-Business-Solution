package com.company.main.managers.database.concretes;

import com.company.helpers.Date;
import com.company.main.entities.log.abstracts.Log;
import com.company.main.entities.log.concretes.DatabaseLog;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.log.concretes.SmsLog;
import com.company.main.entities.user.abstracts.User;
import com.company.main.managers.database.abstracts.DatabaseManager;

public final class UserDatabaseManager extends DatabaseManager<User>
{
    @Override
    public String getAddLogContent()
    {
        return "User has been added!";
    }

    @Override
    public String getRemoveLogContent()
    {
        return "User has been removed!";
    }

    @Override
    public Log[] getTargetLogs(String content, Date date, User raiser, LogLevel level)
    {
        var logs = new Log[2];

        logs[0] = new SmsLog(content, date, raiser, level);
        logs[1] = new DatabaseLog(content, date, raiser, level);

        return logs;
    }
}
