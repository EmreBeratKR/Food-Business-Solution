package com.company.main.entities.log.concretes;

import com.company.helpers.Date;
import com.company.main.entities.log.abstracts.SendableLog;
import com.company.main.entities.user.abstracts.User;

public class EmailLog extends SendableLog
{

    public EmailLog(String content, String feedback, Date date, User sender, LogLevel level)
    {
        super(content, feedback, date, sender, level);
    }

    @Override
    public void send()
    {
        System.out.printf("An Email has been sent to %s { %s }%n", data.raiser(), feedback);
    }

    @Override
    public String getLogTitle()
    {
        return "EMAIL SEND";
    }
}
