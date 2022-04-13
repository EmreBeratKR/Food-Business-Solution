package com.company.main.managers.user;

import com.company.helpers.Date;
import com.company.main.entities.log.concretes.LogContentHolder;
import com.company.main.entities.log.concretes.LogLevel;
import com.company.main.entities.user.concretes.Employee;
import com.company.main.managers.database.concretes.UserDatabaseManager;

public class EmployeeManager extends UserManager<Employee>
{
    public EmployeeManager(UserDatabaseManager userDatabaseManager)
    {
        super(userDatabaseManager);
    }


    @Override
    public boolean register(String username, String password)
    {
        if (userDatabaseManager.contains(username)) return false;

        var user = new Employee(userDatabaseManager.getAvailableId(), username, password);

        userDatabaseManager.add(user, user);

        var content = LogContentHolder.employeeHired;
        log(getTargetLogs(content.forDatabase, content.forFeedback, Date.random(), user, LogLevel.SUCCESS));

        return true;
    }

    public boolean fire(Employee employee)
    {
        userDatabaseManager.remove(employee, employee);

        var content = LogContentHolder.employeeFired;
        log(getTargetLogs(content.forDatabase, content.forFeedback, Date.random(), employee, LogLevel.SUCCESS));

        return true;
    }

    public void setPosition(Employee employee, String position)
    {
        employee.setPosition(position);

        var content = LogContentHolder.employeePositionSet;
        var positionLog = "[" + position + "]";
        log(getTargetLogs(content.forDatabase + positionLog, content.forFeedback + position, Date.random(), employee, LogLevel.SUCCESS));
    }

    public void setSalary(Employee employee, double salary)
    {
        employee.setSalary(salary);

        var content = LogContentHolder.employeeSalarySet;
        var salaryLog = "[" + salary + "]";
        log(getTargetLogs(content.forDatabase + salaryLog, content.forFeedback + salary, Date.random(), employee, LogLevel.SUCCESS));
    }
}
