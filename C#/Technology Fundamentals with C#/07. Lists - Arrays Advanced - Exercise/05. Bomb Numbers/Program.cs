using System;
using System.Linq;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        List<int> listNumbers = Console.ReadLine().Split().Select(int.Parse).ToList();
        List<int> bombProp = Console.ReadLine().Split().Select(int.Parse).ToList();
        int bombNumber = bombProp[0];
        int bombPower = bombProp[1];



        for (int i = 0; i < listNumbers.Count; i++)
        {
            if (listNumbers[i] == bombNumber)
            {
                int startIndex = i - bombPower;
                int endIndex = i + bombPower;

                if (startIndex < 0)
                {
                    startIndex = 0;
                }
                if (endIndex > listNumbers.Count - 1)
                {
                    endIndex = listNumbers.Count - 1;
                }
                if (startIndex > listNumbers.Count - 1 || endIndex < 0)
                {
                    continue;
                }

                listNumbers.RemoveRange(startIndex, endIndex - startIndex + 1);

                i = startIndex - 1;
            }
        }

        int sum = listNumbers.Sum();
        Console.WriteLine(sum);
    }
}