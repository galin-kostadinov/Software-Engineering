using System;

public class AddAndSubtract
{
    public static void Main()
    {
        int firstNum = int.Parse(Console.ReadLine());
        int secondNum = int.Parse(Console.ReadLine());
        int thirdNum = int.Parse(Console.ReadLine());
        int sum = Sum(firstNum, secondNum);
        int substracedNumbers = Subtract(sum, thirdNum);
        Console.WriteLine(substracedNumbers);
    }

    private static int Subtract(int sum, int thirdNum)
    {
        int subtractedNumbers = sum - thirdNum;
        return subtractedNumbers;
    }

    private static int Sum(int firstNum, int secondNum)
    {
        int sum = firstNum + secondNum;
        return sum;
    }
}
