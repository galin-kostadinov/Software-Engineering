using System;

    class Program
{
    static void Main()
    {
        double testNumber = 4;

        Console.WriteLine(Math.Ceiling(testNumber));
        Console.WriteLine(Math.Floor(testNumber));
        Console.WriteLine(Math.Round(testNumber, 2));
        Console.WriteLine("{0:F2}", testNumber);

    }
}
