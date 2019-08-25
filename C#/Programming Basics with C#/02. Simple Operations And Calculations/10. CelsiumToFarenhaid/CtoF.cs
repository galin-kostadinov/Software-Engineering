using System;

class CtoF
{
    static void Main()
    {
        double C = double.Parse(Console.ReadLine());

        double F = C * 1.8 + 32;
        Console.WriteLine("{0:F2}", F);
    }
}
