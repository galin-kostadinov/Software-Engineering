using System;

public class MathPowerII
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
        double result = 1;

        for (int i = 0; i < power; i++)
        {
            result *= number;
        }

        return result;
    }
}
