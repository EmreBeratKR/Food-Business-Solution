package com.company.helpers;

public record Time
    (
        int hour,
        int minute,
        int second
    )
{
    public static Time random()
    {
        return new Time(MyRandom.range(0, 23), MyRandom.range(0, 59), MyRandom.range(0, 59));
    }

    public String toDigital()
    {
        var result = "";

        result += hour;

        result += ":";

        result += minute >= 10 ? minute : "0" + minute;

        result += ":";

        result += second >= 10 ? second : "0" + second;

        return result;
    }

    @Override
    public String toString()
    {
        return this.toDigital();
    }
}
