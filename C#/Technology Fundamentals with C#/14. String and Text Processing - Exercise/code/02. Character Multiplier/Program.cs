using System;

namespace CharacterMultipl
{
    class Program
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();

            string firstString = input[0];
            string secondString = input[1];

            int totalSum = 0;
            int minLenght = Math.Min(firstString.Length, secondString.Length);
            int maxLenght = Math.Max(firstString.Length, secondString.Length);

            for (int i = 0; i < minLenght; i++)
            {
                totalSum += firstString[i] * secondString[i];
            }
            for (int i = minLenght; i < maxLenght; i++)
            {
                if (firstString.Length > secondString.Length)
                {
                    totalSum += firstString[i];
                }
                else
                {
                    totalSum += secondString[i];
                }
            }

            Console.WriteLine(totalSum);
        }
    }
}
