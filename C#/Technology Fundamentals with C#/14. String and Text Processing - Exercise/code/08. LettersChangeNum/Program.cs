using System;
using System.Linq;

namespace LettersChangeNum
{
    class Program
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split(new char[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
            double totalSum = 0.0;

            for (int i = 0; i < input.Length; i++)
            {
                string currentInput = input[i];
                int numberLength = currentInput.Length - 2;
                double number = double.Parse(currentInput.Substring(1, numberLength));

                char firstLetter = currentInput[0];
                char lastLetter = currentInput[currentInput.Length - 1];

                double result = 0;

                if (char.IsUpper(firstLetter))
                {
                    int letterPossition = firstLetter - 'A' + 1;
                    result = number / letterPossition;
                }
                else
                {
                    int letterPossition = firstLetter - 'a' + 1;
                    result = number * letterPossition;
                }

                if (char.IsUpper(lastLetter))
                {
                    int letterPossition = lastLetter - 'A' + 1;
                    totalSum += result - letterPossition;
                }
                else
                {
                    int letterPossition = lastLetter - 'a' + 1;
                    totalSum += result + letterPossition;
                }
            }

            Console.WriteLine($"{totalSum:F2}");
        }
    }
}
