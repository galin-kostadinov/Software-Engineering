using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        int[] intArray = Console.ReadLine().Split().Select(int.Parse).ToArray();

        for (int i = 0; i < intArray.Length; i++)
        {
            bool bigger = true;

            for (int j = i + 1; j < intArray.Length; j++)
            {
                if (intArray[i] <= intArray[j])
                {
                    bigger = false;
                    break;
                }
            }

            if (bigger)
            {
                Console.Write(intArray[i] + " ");
            }
        }

        Console.WriteLine();
    }
}