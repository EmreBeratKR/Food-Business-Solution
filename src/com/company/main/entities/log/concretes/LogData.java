package com.company.main.entities.log.concretes;

import com.company.helpers.Date;
import com.company.main.entities.user.abstracts.User;

public record LogData
    (

        String content,
        Date date,
        User trigger,
        LogLevel level

    )
{
    @Override
    public String toString()
    {
        return String.format("[%s][%s][%s] : %s", date, level, trigger, content);
    }
}
