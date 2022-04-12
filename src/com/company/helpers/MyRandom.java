package com.company.helpers;

import java.util.Random;

public final class MyRandom
{
    private static final Random randomizer = new Random();


    private MyRandom(){}


    public static int range(int minInclusive, int maxInclusive)
    {
        return randomizer.nextInt(minInclusive, maxInclusive+1);
    }
}
