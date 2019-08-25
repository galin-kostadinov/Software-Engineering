using System;

class OddEvenSum
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 1; i <= n; i++)
        {
            int num = int.Parse(Console.ReadLine());
            if (i % 2 == 0)
            {
                sumEven = sumEven + num;
            }
            else
            {
                sumOdd = sumOdd + num;
            }
        }

        if (sumOdd == sumEven)
        {
            Console.WriteLine("Yes");
            Console.WriteLine($"Sum = {sumOdd}");
        }
        else
        {
            Console.WriteLine("No");
            Console.WriteLine($"Diff = {Math.Abs(sumOdd - sumEven)}");
        }
    }
}