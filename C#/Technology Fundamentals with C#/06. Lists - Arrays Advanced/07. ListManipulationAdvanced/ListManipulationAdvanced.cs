using System;
using System.Collections.Generic;
using System.Linq;

class ListManipulationBasics
{
    static void Main()
    {
        List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();
        List<int> originalListNumber = new List<int>();
        for (int i = 0; i < numbers.Count; i++)
        {
            originalListNumber.Add(numbers[i]);
        }
        while (true)
        {
            List<string> command = Console.ReadLine().Split().ToList();
            if (command[0] == "end")
            {
                break;
            }
            else if (command[0] == "Add")
            {
                numbers.Add(int.Parse(command[1]));
            }
            else if (command[0] == "Remove")
            {
                numbers.Remove(int.Parse(command[1]));
            }
            else if (command[0] == "RemoveAt")
            {
                numbers.RemoveAt(int.Parse(command[1]));
            }
            else if (command[0] == "Insert")
            {
                numbers.Insert(int.Parse(command[2]), int.Parse(command[1]));
            }
            else if (command[0] == "Contains")
            {
                bool contains = numbers.Contains(int.Parse(command[1]));
                if (contains)
                {
                    Console.WriteLine("Yes");
                }
                else
                {
                    Console.WriteLine("No such number");
                }
            }
            else if (command[0] == "PrintEven")
            {
                List<int> evenNumbers = numbers.Where(x => x % 2 == 0).ToList();
                Console.WriteLine(string.Join(" ", evenNumbers));
            }
            else if (command[0] == "PrintOdd")
            {
                List<int> oddNumbers = numbers.Where(x => x % 2 != 0).ToList();
                Console.WriteLine(string.Join(" ", oddNumbers));
            }
            else if (command[0] == "GetSum")
            {
                Console.WriteLine(numbers.Sum());
            }
            else if (command[0] == "Filter")
            {
                string filter = command[1];
                int filtredValue = int.Parse(command[2]);
                List<int> filtredNumbers = FiltredList(numbers, filter, filtredValue);
                Console.WriteLine(string.Join(" ", filtredNumbers));
            }
        }

        bool isNotEqual = false;
        if (originalListNumber.Count != numbers.Count)
        {
            Console.WriteLine(string.Join(" ", numbers));
        }
        else
        {
            for (int i = 0; i < numbers.Count; i++)
            {

                if (numbers[i] != originalListNumber[i])
                {
                    isNotEqual = true;
                    break;
                }
            }
        }

        if (isNotEqual)
        {
            Console.WriteLine(string.Join(" ", numbers));
        }
    }

    private static List<int> FiltredList(List<int> numbers, string filter, int filtredValue)
    {
        if (filter == "<")
        {
            List<int> filtredList = numbers.Where(x => x < filtredValue).ToList();
            return filtredList;
        }
        else if (filter == ">")
        {
            List<int> filtredList = numbers.Where(x => x > filtredValue).ToList();
            return filtredList;
        }
        else if (filter == ">=")
        {
            List<int> filtredList = numbers.Where(x => x >= filtredValue).ToList();
            return filtredList;
        }
        else
        {
            List<int> filtredList = numbers.Where(x => x <= filtredValue).ToList();
            return filtredList;
        }
    }
}