using System;
using System.Linq;

public class EqualSum
{
    public static void Main()
    {
        int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();


        for (int i = 0; i < numbers.Length; i++)
        {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++)
            {
                leftSum += numbers[j];
            }
            for (int k = i; k < numbers.Length; k++)
            {
                rightSum += numbers[k];
            }
            if (leftSum == rightSum)
            {
                Console.WriteLine(i);
                break;
            }
            else if (i == numbers.Length - 2)
            {
                Console.WriteLine("no");
            }
        }

    }
}