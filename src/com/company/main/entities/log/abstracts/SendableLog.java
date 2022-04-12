package com.company.main.entities.log.abstracts;

import com.company.helpers.Date;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.user.abstracts.User;

public abstract class SendableLog extends Log implements ISendable
{
    public final String feedback;


    public SendableLog(String content, String feedback, Date date, User sender, LogLevel level)
    {
        super(content, date, sender, level);
        this.feedback = feedback;
    }

}
