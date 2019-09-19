using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var companyEmployees = new Dictionary<string, List<string>>();

        while (true)
        {
            List<string> input = Console.ReadLine()
                .Split(" -> ")
                .ToList();

            if (input[0] == "End")
            {
                break;
            }

            string company = input[0];
            string employeeId = input[1];

            if (!companyEmployees.ContainsKey(company))
            {
                companyEmployees.Add(company, new List<string>());
                companyEmployees[company].Add(employeeId);
            }
            else if (!companyEmployees[company].Contains(employeeId))
            {
                companyEmployees[company].Add(employeeId);
            }

        }

        var sortedCompanyEmployees = companyEmployees
            .OrderBy(x => x.Key)
            .ToDictionary(kvp => kvp.Key, kvp => kvp.Value);

        foreach (var kvp in sortedCompanyEmployees)
        {
            string company = kvp.Key;
            List<string> employees = sortedCompanyEmployees[company]
                .OrderBy(x => x)
                .ToList();

            Console.WriteLine(company);

            foreach (var id in employees)
            {
                Console.WriteLine($"-- {id}");
            }
        }
    }
}