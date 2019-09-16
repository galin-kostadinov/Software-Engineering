using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var list = new List<int> { 1, 2, 3, 4, 5, 7, 8, 311, 32, 311 };

        var maxValueIndexes = list.IndexOf(list.Max());

        Console.WriteLine(maxValueIndexes);
    }
}