using System;

class Command
{
    public static void Main()
    {
        string command = Console.ReadLine();
        int firstNumber = int.Parse(Console.ReadLine());
        int secondNumber = int.Parse(Console.ReadLine());

        switch (command)
        {
            case "add":
                addCommand(firstNumber, secondNumber);
                break;
            case "multiply":
                multiplyCommand(firstNumber, secondNumber);
                break;
            case "subtract":
                subtractCommand(firstNumber, secondNumber);
                break;
            case "divide":
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
