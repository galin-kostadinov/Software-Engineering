using System;

public class TopNumber
{
    public static void Main()
    {
        int range = int.Parse(Console.ReadLine());

        for (int i = 8; i <= range; i++)
        {
            int num = i;
            bool isDivisibleBy8 = CheckIsDivisibleBy8(num);
            if (isDivisibleBy8)
            {
                bool containsOddNumber = ContainsOddNumber(num);
                if (containsOddNumber)
                {
                    Console.WriteLine(num);
                }
            }
        }
    }

    private static bool CheckIsDivisibleBy8(int num)
    {
        string numberToSting = num + "";
        int sum = 0;
        for (int j = 0; j < numberToSting.Length; j++)
        {
            sum += numberToSting[j];
        }
        return sum % 8 == 0 ? true : false;
    }

    private static bool ContainsOddNumber(int number)
    {
        string numberToSting = number + "";
        for (int i = 0; i < numberToSting.Length; i++)
        {
            if (numberToSting[i] % 2 != 0)
            {
                return true;
            }
        }
        return false;
    }
}
