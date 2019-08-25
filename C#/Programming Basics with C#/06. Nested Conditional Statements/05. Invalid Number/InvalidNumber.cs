using System;

class InvalidNumber
{
    static void Main()
    {
        int num = int.Parse(Console.ReadLine());
        if (!(num == 0 || (num >= 100 && num <= 200)))
        {
            Console.WriteLine("invalid");
        }
    }
}
