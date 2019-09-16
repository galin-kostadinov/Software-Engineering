using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var words = Console.ReadLine()
            .Split(' ')
            .ToArray();

        var counts = new Dictionary<string, int>();

        foreach (string word in words)
        {
            string wordInLowerCase = word.ToLower();
            if (!counts.ContainsKey(wordInLowerCase))
            {
                counts[wordInLowerCase] = 0;
            }
            counts[wordInLowerCase]++;
        }

        foreach (var count in counts)
        {
            if (count.Value % 2 == 1)
            {
                Console.Write(count.Key + " ");
            }
        }
        Console.WriteLine();
    }
}