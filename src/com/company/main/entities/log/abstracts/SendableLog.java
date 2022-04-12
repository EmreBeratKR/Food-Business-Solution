package com.company.main.entities.log.abstracts;

import com.company.helpers.Date;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.user.abstracts.User;

public abstract class SendableLog extends Log implements ISendable
{

    public SendableLog(String content, Date date, User sender, LogLevel level)
    {
        super(content, date, sender, level);
    }

}
