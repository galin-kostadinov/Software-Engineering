using System;

class MathOperations
{
    public static void Main()
    {
        int firstNumber = int.Parse(Console.ReadLine());
        string command = Console.ReadLine();
        int secondNumber = int.Parse(Console.ReadLine());

        switch (command)
        {
            case "+":
                addCommand(firstNumber, secondNumber);
                break;
            case "*":
                multiplyCommand(firstNumber, secondNumber);
                break;
            case "-":
                subtractCommand(firstNumber, secondNumber);
                break;
            case "/":
                divideCommand(firstNumber, secondNumber);
                break;
            default:
                break;
        }

    }

    public static void addCommand(int a, int b)
    {
        int result = a + b;
        Console.WriteLine(result);
    }

    public static void multiplyCommand(int a, int b)
    {
        int result = a * b;
        Console.WriteLine(result);
    }

    public static void subtractCommand(int a, int b)
    {
        int result = a - b;
        Console.WriteLine(result);
    }

    public static void divideCommand(int a, int b)
    {
        int result = a / b;
        Console.WriteLine(result);
    }

}
