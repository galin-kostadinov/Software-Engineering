using System;

public class FactorialDivision
{
    public static void Main()
    {
        int firstNumber = int.Parse(Console.ReadLine());
        int secondNumber = int.Parse(Console.ReadLine());

        long factorialFirstNumber = factorial(firstNumber);
        long factorialSecondNumber = factorial(secondNumber);
        double result = 1.0 * factorialFirstNumber / factorialSecondNumber;
        Console.WriteLine($"{result:F2}");
    }

    private static long factorial(int firstNumber)
    {
        long factorial = 1;
        for (int i = 2; i <= firstNumber; i++)
        {
            factorial *= i;
        }
        return factorial;
    }
}
