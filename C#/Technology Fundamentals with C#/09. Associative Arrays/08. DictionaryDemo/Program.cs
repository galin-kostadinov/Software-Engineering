using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var dict = new Dictionary<string, int>
        {
            ["Ivan"] = 6,
            ["Gosho"] = 5,
            ["Ana"] = 6,
            ["Kircho"] = 4
        };


        var result = dict
            .OrderBy(kvp => kvp.Value)
            .ThenBy(kvp => kvp.Key)
            .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);


        foreach (var kvp in result)
        {
            Console.WriteLine($"{kvp.Key} - {kvp.Value}");
        }
    }
}