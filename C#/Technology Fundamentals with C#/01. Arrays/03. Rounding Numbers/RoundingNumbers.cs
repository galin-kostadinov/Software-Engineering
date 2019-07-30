using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        string numbersAsString = Console.ReadLine();
        double[] numbers = numbersAsString.Split().Select(double.Parse).ToArray();
        int[] roundingNumber = new int[numbers.Length];

        for (int i = 0; i < numbers.Length; i++)
        {
            roundingNumber[i] =(int)Math.Round(numbers[i], MidpointRounding.AwayFromZero);
        }

        for (int i = 0; i < roundingNumber.Length; i++)
        {
            Console.WriteLine($"{numbers[i]} => {roundingNumber[i]}");
        }
    }
}