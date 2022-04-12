package com.company.main.managers.database.concretes;

import com.company.helpers.Date;
import com.company.main.entities.log.abstracts.Log;
import com.company.main.entities.log.concretes.*;
import com.company.main.entities.user.abstracts.User;
import com.company.main.managers.database.abstracts.DatabaseManager;

public final class UserDatabaseManager extends DatabaseManager<User>
{
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
        var logs = new Log[3];

        logs[0] = new DatabaseLog(content, date, raiser, level);
        logs[1] = new SmsLog(content, userFeedback, date, raiser, level);
        logs[2] = new EmailLog(content, userFeedback, date, raiser, level);

        return logs;
    }
}
