using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var resources = new Dictionary<string, int>();

        while (true)
        {
            string resource = Console.ReadLine();
            if (resource == "stop")
            {
                break;
            }
            int quantity = int.Parse(Console.ReadLine());

            if (!resources.ContainsKey(resource))
            {
                resources[resource] = quantity;
            }
            else
            {
                resources[resource] += quantity;
            }
        }
        foreach (var kvp in resources)
        {
            Console.WriteLine($"{kvp.Key} -> {kvp.Value}");
        }
    }
}