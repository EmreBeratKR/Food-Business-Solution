package com.company.main.entities.log.concretes;

import com.company.helpers.Date;
import com.company.main.entities.log.abstracts.SendableLog;
import com.company.main.entities.user.abstracts.User;

public class SmsLog extends SendableLog
{

    public SmsLog(String content, String feedback, Date date, User raiser, LogLevel level)
    {
        super(content, feedback, date, raiser, level);
    }


    @Override
    public void send()
    {
        System.out.printf("A SMS has been sent to %s { %s }%n", data.raiser(), feedback);
    }

    @Override
    public String getLogTitle()
    {
        return "SMS SEND";
    }
}
