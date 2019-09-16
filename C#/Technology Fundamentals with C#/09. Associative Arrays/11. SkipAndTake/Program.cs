using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var list = new List<int> { 1, 2, 3, 4, 5, 5, 7, 4 };

        var result = list
            .Skip(2)
            .ToList();

        var result2 = list
            .Take(4)
            .ToList();

        var result3 = list
            .Skip(2)
            .Take(3)
            .ToList();

        foreach (var number in result)
        {
            Console.WriteLine(number);
        }
    }
}