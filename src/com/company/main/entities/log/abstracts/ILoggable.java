package com.company.main.entities.log.abstracts;

import com.company.helpers.Date;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.user.abstracts.User;

public interface ILoggable
{
    void log(Log... logs);

    Log[] getTargetLogs(String content, String userFeedback, Date date, User raiser, LogLevel level);
}
