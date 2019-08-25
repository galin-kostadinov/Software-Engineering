using System;

class OperationsBetweenNum
{
    static void Main()
    {
        int N1 = int.Parse(Console.ReadLine());
        int N2 = int.Parse(Console.ReadLine());
        string Operator = Console.ReadLine();
        double result = 0;

        if (Operator == "+")
        {
            result = N1 + N2;
            if (result % 2 == 0)
            {
                Console.WriteLine($"{N1} {Operator} {N2} = {result} - even");
            }
            else
            {
                Console.WriteLine($"{N1} {Operator} {N2} = {result} - odd");
            }
        }
        else if (Operator == "-")
        {
            result = N1 - N2;
            if (result % 2 == 0)
            {
                Console.WriteLine($"{N1} {Operator} {N2} = {result} - even");
            }
            else
            {
                Console.WriteLine($"{N1} {Operator} {N2} = {result} - odd");
            }
        }
        else if (Operator == "/")
        {
            if (N2 != 0)
            {
                result = 1.0 * N1 / N2;
                Console.WriteLine($"{N1} {Operator} {N2} = {result:F2}");
            }
            else
            {
                Console.WriteLine($"Cannot divide {N1} by zero");
            }
        }
        else if (Operator == "*")
        {
            result = N1 * N2;
            if (result % 2 == 0)
            {
                Console.WriteLine($"{N1} {Operator} {N2} = {result} - even");
            }
            else
            {
                Console.WriteLine($"{N1} {Operator} {N2} = {result} - odd");
            }
        }
        else if (Operator == "%")
        {
            if (N2 != 0)
            {
                result = N1 % N2;
                Console.WriteLine($"{N1} {Operator} {N2} = {result}");
            }
            else
            {
                Console.WriteLine($"Cannot divide {N1} by zero");
            }
        }
    }
}