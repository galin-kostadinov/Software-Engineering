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

        /*
         double num = 0;
            double oddSum = 0;
            double oddMin = double.MaxValue;
            double oddMax = double.MinValue;
            double evenSum = 0;
            double evenMin = double.MaxValue;
            double evenMax = double.MinValue;
      */

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
        Console.WriteLine($"OddSum={OddSum:F2},");
        if (n >= 1)
        {
            Console.WriteLine($"OddMin={OddMin:F2},");
            Console.WriteLine($"OddMax={OddMax:F2},");
        }
        else
        {
            Console.WriteLine($"OddMin=No,");
            Console.WriteLine($"OddMax=No,");
        }

        Console.WriteLine($"EvenSum={EvenSum:F2},");
        if (n >= 2)
        {
            Console.WriteLine($"EvenMin={EvenMin:F2},");
            Console.WriteLine($"EvenMax={EvenMax:F2}");
        }
        else
        {
            Console.WriteLine($"EvenMin=No,");
            Console.WriteLine($"EvenMax=No");
        }
    }
}


