package com.company.main.entities.log.concretes;

public final class LogContentHolder
{
    private LogContentHolder(){}

    public static LogContent userAdded = new LogContent("User has been added!", "Your account has been added!");
    public static LogContent userRemoved = new LogContent("User has been removed!", "Your account has been removed!");

    public static LogContent userNotFound = new LogContent("User not Found!", null);

    public static LogContent loginSucceed = new LogContent("Login Succeed!", "Welcome back, ");
    public static LogContent loginFailed = new LogContent("Login Failed!", "Invalid Credentials!");

    public static LogContent orderMade = new LogContent("Order Entry!", "Your order has been taken!");
    public static LogContent orderCancelled = new LogContent("Order Cancellation!", "Your order has been cancelled!");
    public static LogContent orderChanged = new LogContent("Order Change!", "Your order has been updated!");
    public static LogContent orderPayed = new LogContent("Order Payment!", "Thanks for choosing us, Here is your bill ");

    public static LogContent employeeHired = new LogContent("Employee Retirement", null);
    public static LogContent employeeFired = new LogContent("Employee Fired", "You have been fired!");
    public static LogContent employeePositionSet = new LogContent("Employee Position Set", "Your position has been set to ");
    public static LogContent employeeSalarySet = new LogContent("Employee Salary Set", "Your Salary has been set to ");

}
