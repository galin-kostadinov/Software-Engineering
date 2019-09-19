using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        Dictionary<string, int> usersPoints = new Dictionary<string, int>();
        Dictionary<string, int> languageUsersCount = new Dictionary<string, int>();
        while (true)
        {
            string input = Console.ReadLine();

            if (input == "exam finished")
            {
                break;
            }

            List<string> currentInput = input.Split("-").ToList();

            if (input.Contains("banned"))
            {
                string username = currentInput[0];
                if (usersPoints.ContainsKey(username))
                {
                    usersPoints.Remove(username);
                }
            }
            else
            {
                string username = currentInput[0];
                string language = currentInput[1];
                int points = int.Parse(currentInput[2]);

                if (usersPoints.ContainsKey(username) == false)
                {
                    usersPoints[username] = points;

                    if (languageUsersCount.ContainsKey(language) == false)
                    {
                        languageUsersCount[language] = 0;
                    }
                    languageUsersCount[language]++;
                }
                else
                {
                    int oldPoint = usersPoints[username];

                    if (oldPoint < points)
                    {
                        usersPoints[username] = points;
                    }

                    if (languageUsersCount.ContainsKey(language) == false)
                    {
                        languageUsersCount[language] = 0;
                    }
                    languageUsersCount[language]++;
                }

            }
        }

        var sortedUsersPoints = usersPoints
            .OrderByDescending(x => x.Value)
            .ThenBy(x => x.Key)
            .ToDictionary(x => x.Key, x => x.Value);

        var sorteLanguageUsersCount = languageUsersCount
            .OrderByDescending(x => x.Value)
            .ThenBy(x => x.Key)
            .ToDictionary(x => x.Key, x => x.Value);

        Console.WriteLine("Results:");
        foreach (var kvp in sortedUsersPoints)
        {
            Console.WriteLine($"{kvp.Key} | {kvp.Value}");
        }

        Console.WriteLine("Submissions:");
        foreach (var kvp in sorteLanguageUsersCount)
        {
            Console.WriteLine($"{kvp.Key} - {kvp.Value}");
        }
    }
}