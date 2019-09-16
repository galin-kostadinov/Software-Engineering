using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        Console.ReadLine()
            .Split(' ')
            .Where(x => x.Length % 2 == 0)
            .ToList()
            .ForEach(x => Console.WriteLine(x));
    }
}