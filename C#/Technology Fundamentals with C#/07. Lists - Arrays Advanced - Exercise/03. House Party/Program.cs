using System;
using System.Linq;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        int commandsCount = int.Parse(Console.ReadLine());
        List<string> peopleInTheParty = new List<string>();

        for (int i = 0; i < commandsCount; i++)
        {
            List<string> input = Console.ReadLine().Split().ToList();
            bool peopleAddOrRemove = input[2] == "going!" ? true : false;
            string peopleName = input[0];

            if (peopleAddOrRemove)
            {
                if (peopleInTheParty.Contains(peopleName))
                {
                    Console.WriteLine($"{peopleName} is already in the list!");
                }
                else
                {
                    peopleInTheParty.Add(peopleName);
                }
            }
            else if (!peopleAddOrRemove)
            {
                if (peopleInTheParty.Contains(peopleName))
                {
                    peopleInTheParty.Remove(peopleName);
                }
                else
                {
                    Console.WriteLine($"{peopleName} is not in the list!");
                }
            }
        }
        foreach (var name in peopleInTheParty)
        {
            Console.WriteLine(name);
        }
    }
}