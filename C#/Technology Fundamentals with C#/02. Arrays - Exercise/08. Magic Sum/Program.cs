using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();
        int specialNum = int.Parse(Console.ReadLine());
        for (int i = 0; i < numbers.Length ; i++)
        {
            for (int j = i+1; j < numbers.Length; j++)
            {
                int sum = numbers[i] + numbers[j];
                if (sum == specialNum)
                {
                    Console.WriteLine($"{numbers[i]} {numbers[j]}");
                }
            }
            
        }
    }
}