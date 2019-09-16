using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var list = new List<int> { 1, 2, 3, 4, 5, 7, 8, 311, 32, 311 };

        var result = list
            .Select(x => x * 2)
            .ToList();

        var someResult = new List<int>();

        foreach (var number in list)
        {
            var newNumber = number * 2;
            someResult.Add(newNumber);
        }

    }
}