using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        string text = Console.ReadLine();

        var count = new Dictionary<char, int>();
        foreach (var symbol in text)
        {
            if (symbol == ' ')
            {
                continue;
            }
            if (!count.ContainsKey(symbol))
            {
                count[symbol] = 0;
            }
            count[symbol]++;
        }
        foreach (var kvp in count)
        {
            Console.WriteLine($"{kvp.Key} -> {kvp.Value}");
        }
    }
}