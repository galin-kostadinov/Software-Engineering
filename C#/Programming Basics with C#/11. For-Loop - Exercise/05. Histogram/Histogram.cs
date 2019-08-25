using System;

class Histogram
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        int counterP1 = 0;
        int counterP2 = 0;
        int counterP3 = 0;
        int counterP4 = 0;
        int counterP5 = 0;

        for (int i = 1; i <= n; i++)
        {
            int inputNum = int.Parse(Console.ReadLine());
            if (inputNum < 200)
            {
                ++counterP1;
            }
            else if (inputNum < 400)
            {
                ++counterP2;
            }
            else if (inputNum < 600)
            {
                ++counterP3;
            }
            else if (inputNum < 800)
            {
                ++counterP4;
            }
            else if (inputNum >= 800)
            {
                ++counterP5;
            }
        }

        Console.WriteLine($"{100.0 * counterP1 / n:F2}%");
        Console.WriteLine($"{100.0 * counterP2 / n:F2}%");
        Console.WriteLine($"{100.0 * counterP3 / n:F2}%");
        Console.WriteLine($"{100.0 * counterP4 / n:F2}%");
        Console.WriteLine($"{100.0 * counterP5 / n:F2}%");
    }
}


