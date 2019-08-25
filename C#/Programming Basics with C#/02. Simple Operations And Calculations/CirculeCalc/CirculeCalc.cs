using System;

class CirculeCalc
{
    static void Main()
    {
        double r = double.Parse(Console.ReadLine());

        double area = Math.PI * r * r;
        double perimetar = Math.PI * r * 2;
        Console.WriteLine("{0:F2}", area);
        Console.WriteLine("{0:F2}", perimetar);
    }
}
