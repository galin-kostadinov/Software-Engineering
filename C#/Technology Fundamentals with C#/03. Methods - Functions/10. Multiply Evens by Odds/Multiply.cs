using System;

public class Multiply
{
    public static void Main()
    {
        int number = int.Parse(Console.ReadLine());
        number = Math.Abs(number);

        Console.WriteLine(GetMultipleOfEvenAndOdds(number));
    }

    public static int GetMultipleOfEvenAndOdds(int number)
    {
        int multiple = GetSumOfEvenDigits(number) * GetSumOfOddDigits(number);
        return multiple;
    }

    public static int GetSumOfEvenDigits(int number)
    {
        return GetSumOfDigits(number, 0);
    }

    public static int GetSumOfOddDigits(int number)
    {
        return GetSumOfDigits(number, 1);
    }
    public static int GetSumOfDigits(int number, int expectedRemainder)
    {
        string numberToSting = number.ToString();
        int result = 0;

        for (int i = 0; i < numberToSting.Length; i++)
        {
            if (numberToSting[i] % 2 == expectedRemainder)
            {
                result += int.Parse(numberToSting[i] + "");
            }
        }

        return result;
    }
}
