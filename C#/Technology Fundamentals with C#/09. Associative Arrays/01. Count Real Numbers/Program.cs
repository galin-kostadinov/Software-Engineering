﻿using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        double[] numbers = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();

        var count = new SortedDictionary<double, int>();

        foreach (var number in numbers)
        {
            if (!count.ContainsKey(number))
            {
                count[number] = 1;
            }
            else
            {
                count[number]++;
            }
        }

        foreach (var kvp in count)
        {
            Console.WriteLine(kvp.Key + " -> " + kvp.Value);
        }
    }
}