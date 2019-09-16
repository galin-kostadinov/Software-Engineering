using System;
using System.Collections.Generic;
using System.Linq;
using TestDictionaries;

public class Program
{
    public static void Main()
    {
      
        Cat SomeCat = new Cat
        {
            Name = "Ivan",
            Age = 10,
            Color = "White"
        };

        Console.WriteLine(SomeCat.Name);
        SomeCat.Name = "Pesho";
        var catName = SomeCat.Name;
        Console.WriteLine(catName);

        Console.WriteLine("----------------------------------");

        List<int> numbers = new List<int>();

        List<Cat> cats = new List<Cat>();

        var firtCat = new Cat
        {
            Name = "Ivan",
            Age = 10,
            Color = "White"
        };

        var seconCat = new Cat
        {
            Name = "Pesho",
            Age = 2,
            Color = "Black"
        };

        var thirdCat = new Cat
        {
            Name = "Stamat",
            Age = 9,
            Color = "Orange"
        };

        cats.Add(firtCat);
        cats.Add(seconCat);
        cats.Add(thirdCat);

        var result = cats
            .OrderBy(c => c.Name)
            .ToList();

        foreach (var cat in result)
        {
            Console.WriteLine(cat.Name);
        }

        Console.WriteLine("----------------------------------");

        var filtredResult = cats
            .Where(c => c.Age > 4)
            .OrderBy(c => c.Color)
            .Select(c => c.Name)
            .ToList();

        foreach (var cat in filtredResult)
        {
            Console.WriteLine(cat);
        }

        Console.WriteLine("----------------------------------");

        var filtredResult2 = cats
            .OrderBy(c => c.Name)
            .ThenBy(c => c.Age)
            .ToList();

        foreach (var cat in filtredResult2)
        {
            Console.WriteLine($"{cat.Name} - {cat.Age}");
        }
    }
}