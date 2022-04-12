package com.company.main.managers.log;

import com.company.main.entities.log.abstracts.Log;

public abstract class LogManager<T extends Log>
{
    public abstract void log(T log);
}
