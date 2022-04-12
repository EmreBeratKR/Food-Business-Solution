package com.company.main.entities.log.abstracts;

import com.company.helpers.Date;
import com.company.main.entities.log.concretes.LogData;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.user.abstracts.User;

public abstract class Log
{
    public final LogData data;


    public Log(LogData data)
    {
        this.data = data;
    }

    public Log(String content, Date date, User raiser, LogLevel level)
    {
        this.data = new LogData(content, date, raiser, level);
    }

    public abstract String getLogTitle();

    public String toLogFormat()
    {
        return String.format("[%s]%s", this.getLogTitle(), this.data.toString());
    }

}
