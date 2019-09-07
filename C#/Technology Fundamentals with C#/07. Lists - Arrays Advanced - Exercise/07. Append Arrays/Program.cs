using System;
using System.Linq;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        List<string> numbersAsString = Console.ReadLine().Split("|").ToList();
        List<int> numbers = new List<int>();

        for (int i = 0; i < numbersAsString.Count; i++)
        {
            List<int> somePartOfNumbers = numbersAsString[numbersAsString.Count - 1 - i].Split(" ", StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToList();
            for (int j = 0; j < somePartOfNumbers.Count; j++)
            {
                numbers.Add(somePartOfNumbers[j]);
            }
        }
        Console.WriteLine(string.Join(' ', numbers));
    }
}