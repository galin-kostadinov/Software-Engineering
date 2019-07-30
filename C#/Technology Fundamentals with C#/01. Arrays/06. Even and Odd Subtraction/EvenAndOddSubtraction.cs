using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        double[] numbers = Console.ReadLine().Split().Select(double.Parse).ToArray();
        double evenSum = 0;
        double oddSum = 0;
        for (int i = 0; i < numbers.Length; i++)
        {
            if (numbers[i] % 2 == 0)
            {
                evenSum += numbers[i];
            }
            else
            {
                oddSum += numbers[i];
            }
        }
        double result = evenSum - oddSum;

        Console.WriteLine(result);

    }
}