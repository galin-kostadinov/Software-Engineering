﻿using System;

public class MathPower
{
    public static void Main()
    {
        double number = double.Parse(Console.ReadLine());
        int power = int.Parse(Console.ReadLine());

        double raiseToPower = RaiseToPower(number, power);

        Console.WriteLine(raiseToPower);
    }

    public static double RaiseToPower(double number, int power)
    {
        return Math.Pow(number, power);
    }
}
