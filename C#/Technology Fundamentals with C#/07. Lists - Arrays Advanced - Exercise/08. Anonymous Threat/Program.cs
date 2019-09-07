using System;
using System.Linq;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        List<string> input = Console.ReadLine().Split().ToList();

        while (true)
        {
            List<string> commandProp = Console.ReadLine().Split().ToList();

            string commandType = commandProp[0];

            if (commandType == "3:1")
            {
                break;
            }

            if (commandType == "merge")
            {
                int startIndex = int.Parse(commandProp[1]);
                int endIndex = int.Parse(commandProp[2]);

                if (startIndex < 0)
                {
                    startIndex = 0;
                }
                if (endIndex > input.Count - 1)
                {
                    endIndex = input.Count - 1;
                }
                if (startIndex > input.Count - 1)
                {
                    startIndex = input.Count - 1;
                }
                if (endIndex < 0)
                {
                    endIndex = 0;
                }

                string mergedText = string.Empty;
                for (int i = startIndex; i <= endIndex; i++)
                {
                    mergedText += input[i];
                }
                input[startIndex] = mergedText;
                input.RemoveRange(startIndex + 1, endIndex - startIndex);

            }
            else if (commandType == "divide")
            {
                int inputIndex = int.Parse(commandProp[1]);
                int partitions = int.Parse(commandProp[2]);

                string textToDivide = input[inputIndex];

                input.RemoveAt(inputIndex);
                List<string> toInsert = new List<string>();
                int charsByPart = textToDivide.Length / partitions;

                for (int i = 0; i <= textToDivide.Length - charsByPart + 1; i += charsByPart)
                {
                    string partToAdd = string.Empty;
                    for (int j = 0; j < charsByPart; j++)
                    {
                        partToAdd += textToDivide[i + j];
                    }
                    if (textToDivide.Length % partitions == 1 && i == (textToDivide.Length - charsByPart - 1))
                    {
                        partToAdd += textToDivide[textToDivide.Length - 1];
                    }

                    toInsert.Add(partToAdd);
                }
                input.InsertRange(inputIndex, toInsert);
            }
        }
        Console.WriteLine(string.Join(" ", input));
    }
}