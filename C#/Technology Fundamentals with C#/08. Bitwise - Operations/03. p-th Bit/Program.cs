using System;

class Program
{
    static void Main()
    {
        int number = int.Parse(Console.ReadLine());
        int pos = int.Parse(Console.ReadLine());

        int mask = 1 << pos;
        int result = number & mask;
        result = result >> pos;
        Console.WriteLine(result);
    }
}

