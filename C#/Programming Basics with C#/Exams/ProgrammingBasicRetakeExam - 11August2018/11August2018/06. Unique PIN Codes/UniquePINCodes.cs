using System;

class UniquePINCodes
{
    static void Main()
    {
        int ceilingNum1 = int.Parse(Console.ReadLine());
        int ceilingNum2 = int.Parse(Console.ReadLine());
        int ceilingNum3 = int.Parse(Console.ReadLine());

        if (ceilingNum2 > 7)
        {
            ceilingNum2 = 7;
        }

        for (int i = 2; i <= ceilingNum1; i++)
        {
            for (int j = 2; j <= ceilingNum2; j++)
            {
                for (int k = 2; k <= ceilingNum3; k++)
                {
                    bool jPrime = false;

                    if (j == 2 || j == 3 || j == 5 || j == 7)
                    {
                        jPrime = true;
                    }

                    if (i % 2 == 0 && k % 2 == 0 && jPrime)
                    {
                        Console.WriteLine($"{i} {j} {k}");
                    }
                }
            }
        }
    }
}