using System;
using System.Collections.Generic;
using System.Linq;

class GaussTrick
{
    static void Main()
    {
        List<double> numbers = Console.ReadLine().Split().Select(double.Parse).ToList();
        List<double> sumNumbers = new List<double>();
  
        for (int i = 0; i < numbers.Count / 2; i++)
        {
            sumNumbers.Add(numbers[i] + numbers[numbers.Count - i - 1]);
        }

        if (numbers.Count % 2 != 0)
        {
            sumNumbers.Add(numbers[numbers.Count / 2]);
        }
        
        Console.WriteLine(string.Join(" ", sumNumbers));
    }

}