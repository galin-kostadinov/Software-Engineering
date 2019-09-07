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
            if (input[0] == "end")
            {
                break;
            }
            else if (input[0] == "Delete")
            {
                int deletedNumber = int.Parse(input[1]);
                listNumbers.RemoveAll(num => num == deletedNumber);

            }
            else if (input[0] == "Insert")
            {
                int insertElement = int.Parse(input[1]);
                int insertElementPosition = int.Parse(input[2]);
                listNumbers.Insert(insertElementPosition, insertElement);
            }
        }
        Console.WriteLine(string.Join(" ", listNumbers));

    }
}