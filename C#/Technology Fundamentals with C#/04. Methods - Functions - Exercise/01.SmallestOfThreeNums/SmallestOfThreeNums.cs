using System;

public class SmallestOfThreeNums
{
    public static void Main()
    {
        int firstNumber = int.Parse(Console.ReadLine());
        int secondNumber = int.Parse(Console.ReadLine());
        int thirdNumber = int.Parse(Console.ReadLine());

        int smallarNum = SmallerNumber(firstNumber, secondNumber);
        int result = SmallerNumber(smallarNum, thirdNumber);
        Console.WriteLine(result);
    }
    public static int SmallerNumber(int firstNumber, int secondNumber)
    {
        if (firstNumber <= secondNumber)
        {
            return firstNumber;
        }
        else
        {
            return secondNumber;
        }
    }
}
