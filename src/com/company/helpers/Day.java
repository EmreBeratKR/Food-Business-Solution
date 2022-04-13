package com.company.helpers;

public enum Day
{
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

    public static Day random()
    {
        var days = Day.values();

        return days[MyRandom.range(0, days.length - 1)];
    }
}
