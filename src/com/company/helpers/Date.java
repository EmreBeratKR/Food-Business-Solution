package com.company.helpers;

public record Date
    (

        int year,
        int month,
        int day,
        Time time

    )
{
    public static Date random()
    {
        int randomYear = MyRandom.range(2000, 2022);

        int randomMonth = MyRandom.range(1, 12);

        int maxDayCount = 28;

        if (randomMonth != 2)
        {
            switch (randomMonth)
            {
                case 1,3,5,7,8,10,12:
                    maxDayCount = 31;

                default:
                    maxDayCount = 30;
            }
        }

        int randomDay = MyRandom.range(1, maxDayCount);

        return new Date(randomYear, randomMonth, randomDay, Time.random());
    }

    public String toDigital()
    {
        var result = "";

        result += year;

        result += ":";

        result += month >= 10 ? month : "0" + month;

        result += ":";

        result += day >= 10 ? day : "0" + day;

        result += "/";

        result += time;

        return result;
    }

    @Override
    public String toString()
    {
        return this.toDigital();
    }
}
