using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();

        int rotations = int.Parse(Console.ReadLine());// Може да си спестим завъртания като сметнем rotation%numbers.Length=needRotation;
        for (int i = 1; i <= rotations; i++)
        {
            int firstIndex = numbers[0];

            for (int j = 0; j < numbers.Length - 1; j++)
            {
                numbers[j] = numbers[j + 1];

            }
            numbers[numbers.Length - 1] = firstIndex;

        }

        Console.WriteLine(string.Join(" ", numbers));
    }
}