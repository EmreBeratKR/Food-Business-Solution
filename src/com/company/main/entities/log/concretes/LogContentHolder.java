package com.company.main.entities.log.concretes;

public final class LogContentHolder
{
    private LogContentHolder(){}

    public static LogContent userAdded = new LogContent("User has been added!", "Your account has been added!");
    public static LogContent userRemoved = new LogContent("User has been removed!", "Your account has been removed!");
}
