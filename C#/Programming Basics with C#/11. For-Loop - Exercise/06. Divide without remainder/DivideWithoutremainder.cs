using System;

class DivideWithoutremainder
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        int counterP2 = 0;
        int counterP3 = 0;
        int counterP4 = 0;


        for (int i = 1; i <= n; i++)
        {
            int inputNum = int.Parse(Console.ReadLine());
            if (inputNum % 2 == 0)
            {
                ++counterP2;
            }
            if (inputNum % 3 == 0)
            {
                ++counterP3;
            }
            if (inputNum % 4 == 0)
            {
                ++counterP4;
            }

        }

        Console.WriteLine($"{100.0 * counterP2 / n:F2}%");
        Console.WriteLine($"{100.0 * counterP3 / n:F2}%");
        Console.WriteLine($"{100.0 * counterP4 / n:F2}%");
    }
}