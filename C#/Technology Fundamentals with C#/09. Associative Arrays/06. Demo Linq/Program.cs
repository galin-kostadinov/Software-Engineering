using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        Console.WriteLine("Select(x => x * 100)--------------------------------------");
        var list = new List<int>() { 1, 2, 3, 4, 5, 6, 50, 60 };
        var result = list.Select(x => x * 100).ToList();
        foreach (var num in result)
        {
            Console.Write(num + " ");
        }
        Console.WriteLine();
        Console.WriteLine("Where(x => x > 5)-------------------------------------");

        var result2 = list.Where(x => x > 5).ToList();
        foreach (var num in result2)
        {
            Console.Write(num + " ");
        }
        Console.WriteLine();
        Console.WriteLine("Where(x => x % 2 == 1)--------------------------------");

        var result3 = list.Where(x => x % 2 == 1).ToList();
        foreach (var num in result3)
        {
            Console.Write(num + " ");
        }
        Console.WriteLine();
        Console.WriteLine("OrderBy(x => x)---------------------------------------");

        var list1 = new List<int>() { 1, 2, 3, 4, 5, 6, 50, 60 };

        var filtredList1 = list1.OrderBy(x => x);

        foreach (var num in result)
        {
            Console.Write(num + " ");
        }
        Console.WriteLine();
        Console.WriteLine("OrderBy(w => w.Length)------------------------------------");

        string[] words = Console.ReadLine().Split(' ');

        words = words
            .OrderBy(w => w.Length)
            .ToArray();

        foreach (var word in words)
        {
            Console.WriteLine(word);
        }
        Console.WriteLine();

    }
}