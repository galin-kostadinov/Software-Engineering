using System;

public class SmallestOfThreeNums
{
    public static void Main()
    {
        int firstNumber = int.Parse(Console.ReadLine());
        int secondNumber = int.Parse(Console.ReadLine());
        int thirdNumber = int.Parse(Console.ReadLine());

        int result = SmallerNumber(firstNumber, secondNumber, thirdNumber);
        Console.WriteLine(result);
    }
    public static int SmallerNumber(int firstNumber, int secondNumber, int thirdNumber)
    {
        int firstSmallerNum = firstNumber <= secondNumber ? firstNumber : secondNumber;
        return firstSmallerNum <= thirdNumber ? firstSmallerNum : thirdNumber;//Тернарен оператор
    }

}
