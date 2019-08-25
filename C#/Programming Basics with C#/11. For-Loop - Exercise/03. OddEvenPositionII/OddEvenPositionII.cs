using System;

class OddEvenPosition
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        double inputNum = 0.0;
        double OddSum = 0;
        double OddMin = 0;
        double OddMax = 0;
        double EvenSum = 0;
        double EvenMin = 0;
        double EvenMax = 0;

        if (n >= 1)
        {
            inputNum = double.Parse(Console.ReadLine());
            OddSum = inputNum;
            OddMin = inputNum;
            OddMax = inputNum;
        }
        if (n >= 2)
        {
            inputNum = double.Parse(Console.ReadLine());
            EvenSum = inputNum;
            EvenMin = inputNum;
            EvenMax = inputNum;
        }

        if (n >= 3)
        {
            for (int i = 1; i <= n - 2; i++)
            {
                inputNum = double.Parse(Console.ReadLine());
                if (!(i % 2 == 0))
                {
                    OddSum = OddSum + inputNum;
                    if (OddMin > inputNum)
                    {
                        OddMin = inputNum;
                    }
                    if (OddMax < inputNum)
                    {
                        OddMax = inputNum;
                    }
                }
                else
                {
                    EvenSum = EvenSum + inputNum;
                    if (EvenMin > inputNum)
                    {
                        EvenMin = inputNum;
                    }
                    if (EvenMax < inputNum)
                    {
                        EvenMax = inputNum;
                    }
                }
            }
        }
        Console.Write($"OddSum={OddSum}, ");
        if (n >= 1)
        {
            Console.Write($"OddMin={OddMin}, ");
            Console.Write($"OddMax={OddMax}, ");
        }
        else
        {
            Console.Write($"OddMin=No, ");
            Console.Write($"OddMax=No, ");
        }

        Console.Write($"EvenSum={EvenSum}, ");
        if (n >= 2)
        {
            Console.Write($"EvenMin={EvenMin}, ");
            Console.WriteLine($"EvenMax={EvenMax}");
        }
        else
        {
            Console.Write($"EvenMin=No, ");
            Console.WriteLine($"EvenMax=No");
        }
    }
}


