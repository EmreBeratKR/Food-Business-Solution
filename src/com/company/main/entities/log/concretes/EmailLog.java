package com.company.main.entities.log.concretes;

import com.company.helpers.Date;
import com.company.main.entities.log.abstracts.SendableLog;
import com.company.main.entities.user.abstracts.User;

public class EmailLog extends SendableLog
{

    public EmailLog(String content, Date date, User sender, LogLevel level)
    {
        super(content, date, sender, level);
    }


    @Override
    public void send()
    {

    }

    @Override
    public String getLogTitle()
    {
        return "EMAIL SEND";
    }
}
