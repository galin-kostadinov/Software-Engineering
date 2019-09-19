using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var cousreCount = new Dictionary<string, int>();
        var sudentsName = new Dictionary<string, string>();

        while (true)
        {
            List<string> input = Console.ReadLine()
                .Split(" : ")
                .ToList();

            if (input[0] == "end")
            {
                break;
            }

            string courseName = input[0];
            string sudentName = input[1];


            if (!cousreCount.ContainsKey(courseName))
            {
                cousreCount[courseName] = 0;


            }
            cousreCount[courseName]++;
            sudentsName[sudentName] = courseName;
        }

        var sortedCousreCount = cousreCount
            .OrderByDescending(x => x.Value)
            .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);

        foreach (var kvp in sortedCousreCount)
        {
            string courseName = kvp.Key;
            int count = kvp.Value;
            Console.WriteLine($"{courseName}: {count}");

            var students = sudentsName
                .Where(x => x.Value == courseName)
                .OrderBy(x => x.Key)
                .ToDictionary(x => x.Key, x => x.Value);
            foreach (var student in students)
            {
                Console.WriteLine($"-- {student.Key}");
            }
        }
    }
}