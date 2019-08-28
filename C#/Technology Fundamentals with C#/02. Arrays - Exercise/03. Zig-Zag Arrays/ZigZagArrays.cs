using System;
using System.Linq;

public class ZigZagArrays
{
    public static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0; i < n; i++)
        {
            int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();

            if (i % 2 == 0)
            {
                firstArray[i] = input[0];
                secondArray[i] = input[1];
            }
            else
            {
                firstArray[i] = input[1];
                secondArray[i] = input[0];
            }
        }

        foreach (var number in firstArray)
        {
            Console.Write(number + " ");
        }

        Console.WriteLine();

        foreach (var number in secondArray)
        {
            Console.Write(number + " ");
        }

        Console.WriteLine();
    }
}