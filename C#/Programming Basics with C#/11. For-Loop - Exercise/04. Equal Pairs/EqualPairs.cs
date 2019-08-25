using System;

class EqualPairs
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int sum1 = 0;
        int sum2 = 0;
        int maxdiff = 0;
        int maxdiff2 = 0;
        for (int i = 1; i <= n; i++)
        {
            if (!(i % 2 == 0))
            {
                int num1 = int.Parse(Console.ReadLine());
                int num2 = int.Parse(Console.ReadLine());
                sum1 = num1 + num2;
            }
            else if (i % 2 == 0)
            {
                int num1 = int.Parse(Console.ReadLine());
                int num2 = int.Parse(Console.ReadLine());
                sum2 = num1 + num2;
            }
            if (i > 1)
            {
                maxdiff = sum1 - sum2;
                if (Math.Abs(maxdiff) > Math.Abs(maxdiff2))
                {
                    maxdiff2 = maxdiff;
                }
            }
        }

        if (maxdiff2 == 0)
        {
            Console.WriteLine($"Yes, value={sum1}");
        }
        else
        {
            Console.WriteLine($"No, maxdiff={Math.Abs(maxdiff2)}");
        }
    }
}


