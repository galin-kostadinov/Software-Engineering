using System;

class RectangleArea
{
    static void Main()
    {
        double x1 = double.Parse(Console.ReadLine());
        double y1 = double.Parse(Console.ReadLine());
        double x2 = double.Parse(Console.ReadLine());
        double y2 = double.Parse(Console.ReadLine());

        double length = Math.Abs(x1 - x2);
        double width = Math.Abs(y1 - y2);
        Console.WriteLine(length);
        Console.WriteLine(width);

        double area = length * width;
        double perimetar = 2 * length + 2 * width;

        Console.WriteLine("{0:F2}", area);
        Console.WriteLine("{0:F2}", perimetar);

    }
}
