using System;
using System.Linq;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        List<int> wagons = Console.ReadLine().Split().Select(int.Parse).ToList();
        int maxPassangersByWagon = int.Parse(Console.ReadLine());
        while (true)
        {
            List<string> input = Console.ReadLine().Split().ToList();
            if (input[0] == "end")
            {
                break;
            }
            else if (input[0] == "Add")
            {
                wagons.Add(int.Parse(input[1]));
            }
            else
            {
                int newPeoples = int.Parse(input[0]);
                for (int i = 0; i < wagons.Count; i++)
                {
                    int neededPlaces = wagons[i] + newPeoples;
                    if (neededPlaces <= maxPassangersByWagon)
                    {
                        wagons[i] = neededPlaces;
                        break;
                    }
                    else if (i == (wagons.Count - 1) && newPeoples <= maxPassangersByWagon)
                    {
                        wagons.Add(newPeoples);
                        break;
                    }
                }
            }
        }
        Console.WriteLine(string.Join(" ", wagons));
    }
}