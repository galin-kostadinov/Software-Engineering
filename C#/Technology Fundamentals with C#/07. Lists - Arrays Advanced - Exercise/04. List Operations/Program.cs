using System;
using System.Linq;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        List<int> listNumbers = Console.ReadLine().Split().Select(int.Parse).ToList();
        while (true)
        {
            List<string> input = Console.ReadLine().Split().ToList();
            if (input[0] == "End")
            {
                break;
            }
            else if (input[0] == "Add")
            {
                int numberToAdd = int.Parse(input[1]);
                listNumbers.Add(numberToAdd);

            }
            else if (input[0] == "Insert")
            {
                int insertElement = int.Parse(input[1]);
                int insertElementPosition = int.Parse(input[2]);
                if (insertElementPosition > listNumbers.Count - 1 || insertElementPosition < 0)
                {
                    Console.WriteLine("Invalid index");
                    continue;
                }
                listNumbers.Insert(insertElementPosition, insertElement);
            }
            else if (input[0] == "Remove")
            {
                int removeIndex = int.Parse(input[1]);
                if (removeIndex > listNumbers.Count - 1 || removeIndex < 0)
                {
                    Console.WriteLine("Invalid index");
                    continue;
                }
                listNumbers.RemoveAt(removeIndex);
            }
            else if (input[0] == "Shift")
            {
                int count = int.Parse(input[2]);
                if (input[1] == "left")
                {
                    for (int i = 0; i < count; i++)
                    {
                        int firstNumber = listNumbers[0];
                        listNumbers.RemoveAt(0);
                        listNumbers.Add(firstNumber);
                    }
                }
                else
                {
                    for (int i = 0; i < count; i++)
                    {
                        int lastNumber = listNumbers[listNumbers.Count - 1];
                        listNumbers.RemoveAt(listNumbers.Count - 1);
                        listNumbers.Insert(0, lastNumber);
                    }
                }
            }
        }
        Console.WriteLine(string.Join(" ", listNumbers));
    }
}