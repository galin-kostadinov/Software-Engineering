using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var keyMaterials = new Dictionary<string, int>
        {
            ["shards"] = 0,
            ["fragments"] = 0,
            ["motes"] = 0
        };

        var junkMaterials = new Dictionary<string, int>();

        while (true)
        {
            List<string> list = Console.ReadLine().Split().ToList();
            for (int i = 1; i < list.Count; i += 2)
            {
                string material = list[i].ToLower();
                int quantity = int.Parse(list[i - 1]);
                if (keyMaterials.ContainsKey(material))
                {
                    keyMaterials[material] += quantity;
                }
                else
                {
                    if (!junkMaterials.ContainsKey(material))
                    {
                        junkMaterials[material] = quantity;
                    }
                    else
                    {
                        junkMaterials[material] += quantity;
                    }
                }

                if (keyMaterials["shards"] >= 250 || keyMaterials["fragments"] >= 250 || keyMaterials["motes"] >= 250)
                {
                    break;
                }
            }

            if (keyMaterials["shards"] >= 250)
            {
                Console.WriteLine("Shadowmourne obtained!");
                keyMaterials["shards"] -= 250;
                break;
            }
            else if (keyMaterials["fragments"] >= 250)
            {
                Console.WriteLine("Valanyr obtained!");
                keyMaterials["fragments"] -= 250;
                break;
            }
            else if (keyMaterials["motes"] >= 250)
            {
                Console.WriteLine("Dragonwrath obtained!");
                keyMaterials["motes"] -= 250;
                break;
            }
        }

        var resultKeyMaterials = keyMaterials
            .OrderByDescending(kvp => kvp.Value)
            .ThenBy(kvp => kvp.Key)
            .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);

        var resultJunkMaterials = junkMaterials
               .OrderBy(kvp => kvp.Key)
               .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);

        foreach (var kvp in resultKeyMaterials)
        {
            Console.WriteLine($"{kvp.Key}: {kvp.Value}");
        }
        foreach (var kvp in resultJunkMaterials)
        {
            Console.WriteLine($"{kvp.Key}: {kvp.Value}");
        }
    }
}