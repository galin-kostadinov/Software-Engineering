using System;
using System.Linq;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();
        int sum = 0;
        while (numbers.Count > 0)
        {
            int removedIndex = int.Parse(Console.ReadLine());
            int removedElement = 0;
            if (removedIndex < 0)
            {
                removedElement = numbers[0];
                int lastElement = numbers[numbers.Count - 1];

                numbers.RemoveAt(0);
                numbers.Insert(0, lastElement);
            }
            else if (removedIndex > numbers.Count - 1)
            {
                removedElement = numbers[numbers.Count - 1];
                int firstElement = numbers[0];

                numbers.RemoveAt(numbers.Count - 1);
                numbers.Add(firstElement);
            }
            else
            {
                removedElement = numbers[removedIndex];
                numbers.RemoveAt(removedIndex);
            }

            sum += removedElement;

            for (int i = 0; i < numbers.Count; i++)
            {
                int currantElement = numbers[i];
                if (currantElement <= removedElement)
                {
                    numbers[i] = currantElement + removedElement;
                }
                else
                {
                    numbers[i] = currantElement - removedElement;
                }
            }
        }
        Console.WriteLine(sum);
    }
}