package com.company.main.entities.log.concretes;

public final class LogContentHolder
{
    private LogContentHolder(){}

    public static LogContent userAdded = new LogContent("User has been added!", "Your account has been added!");
    public static LogContent userRemoved = new LogContent("User has been removed!", "Your account has been removed!");

    public static LogContent userNotFound = new LogContent("User not Found!", null);

    public static LogContent loginSucceed = new LogContent("Login Succeed!", "Welcome back!");
    public static LogContent loginFailed = new LogContent("Login Failed!", "Invalid Credentials!");
}
