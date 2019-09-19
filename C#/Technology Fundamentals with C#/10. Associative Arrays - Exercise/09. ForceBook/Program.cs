using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var nameSide = new Dictionary<string, string>();

        while (true)
        {
            string input = Console.ReadLine();

            if (input == "Lumpawaroo")
            {
                break;
            }

            string forceSide = string.Empty;
            string forceUser = string.Empty;

            List<string> inputUsers = new List<string>();
            string symbol = string.Empty;
            if (input.Contains("|"))
            {

                inputUsers = input.Split(" | ").ToList();
                forceSide = inputUsers[0];
                forceUser = inputUsers[1];
                if (!nameSide.ContainsKey(forceUser))
                {
                    nameSide[forceUser] = forceSide;
                }
            }
            else
            {
                inputUsers = input.Split(" -> ").ToList();
                forceSide = inputUsers[1];
                forceUser = inputUsers[0];

                if (!nameSide.ContainsKey(forceUser))
                {
                    nameSide[forceUser] = forceSide;
                }
                else
                {
                    nameSide[forceUser] = forceSide;
                }
                Console.WriteLine($"{forceUser} joins the {forceSide} side!");
            }

        }

        var filtredNameSide = nameSide
           .GroupBy(x => x.Value)
           .OrderByDescending(x => x.Count())
           .ThenBy(x => x.Key);

        foreach (var kvp in filtredNameSide)
        {
            string side = kvp.Key;
            var nameSideValue = kvp;

            Console.WriteLine($"Side: {side}, Members: {nameSideValue.Count()}");

            foreach (var kvpValue in nameSideValue.OrderBy(x => x.Key))
            {
                string name = kvpValue.Key;
                Console.WriteLine($"! {name}");
            }
        }
    }
}