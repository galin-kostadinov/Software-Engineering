using System;
using System.Linq;

public class EqualArrays
{
    public static void Main()
    {
        int[] firstArray = Console.ReadLine().Split().Select(int.Parse).ToArray();
        int[] secondArray = Console.ReadLine().Split().Select(int.Parse).ToArray();

        double sum = 0;
        bool identicalArrays = true;

        for (int i = 0; i < firstArray.Length; i++)
        {
            if (firstArray[i] != secondArray[i])
            {
                Console.WriteLine($"Arrays are not identical. Found difference at {i} index");
                identicalArrays = false;
                break;
            }

            sum += firstArray[i];
        }

        if (identicalArrays)
        {
            Console.WriteLine($"Arrays are identical. Sum: {sum}");
        }
    }
}