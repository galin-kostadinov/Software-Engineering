using System;

class Program
{
    static void Main()
    {
        int number = int.Parse(Console.ReadLine());
        int pos = int.Parse(Console.ReadLine());
        int mask = (7 << pos);//This is 0111
        int res = number ^ mask;
        Console.WriteLine(res);
    }
}

