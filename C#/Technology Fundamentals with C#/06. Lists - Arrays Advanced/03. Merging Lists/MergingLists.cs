using System;
using System.Collections.Generic;
using System.Linq;

class MergingLists
{
    static void Main()
    {
        List<double> firstListNumbers = Console.ReadLine().Split().Select(double.Parse).ToList();
        List<double> secondListNumbers = Console.ReadLine().Split().Select(double.Parse).ToList();
        int firstListNumbersCount = firstListNumbers.Count;
        int secondListNumbersCount = secondListNumbers.Count;
        int length = 0;

        if (firstListNumbersCount >= secondListNumbersCount)
        {
            length = firstListNumbersCount;
        }
        else
        {
            length = secondListNumbersCount;
        }

        List<double> allNumbers = new List<double>();

        for (int i = 0; i < length; i++)
        {
            if (firstListNumbersCount > i)
            {
                allNumbers.Add(firstListNumbers[i]);
            }

            if (secondListNumbersCount > i)
            {
                allNumbers.Add(secondListNumbers[i]);
            }
        }
        Console.WriteLine(string.Join(" ", allNumbers));
    }
}