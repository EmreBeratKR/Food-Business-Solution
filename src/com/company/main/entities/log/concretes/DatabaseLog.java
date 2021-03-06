package com.company.main.entities.log.concretes;

import com.company.helpers.Date;
import com.company.main.entities.log.abstracts.Log;
import com.company.main.entities.user.abstracts.User;

public class DatabaseLog extends Log
{

    public DatabaseLog(String content, Date date, User raiser, LogLevel level)
    {
        super(content, date, raiser, level);
    }

    @Override
    public String getLogTitle()
    {
        return "DATABASE";
    }
}
