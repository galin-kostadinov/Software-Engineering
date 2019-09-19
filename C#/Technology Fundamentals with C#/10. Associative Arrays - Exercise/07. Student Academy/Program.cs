using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        var studentsGrades = new Dictionary<string, List<double>>();

        for (int i = 0; i < n; i++)
        {
            string studentName = Console.ReadLine();
            double studentGrade = double.Parse(Console.ReadLine());

            if (!studentsGrades.ContainsKey(studentName))
            {

                //studentsGrades.Add(studentName, new List<double>()); second variant
                studentsGrades[studentName] = new List<double>();
            }
            studentsGrades[studentName].Add(studentGrade);
        }
        Dictionary<string, List<double>> filtredStudentsGrades = studentsGrades
            .Where(x => x.Value.Average() >= 4.5)
            .OrderByDescending(x => x.Value.Average())
            .ToDictionary(x => x.Key, x => x.Value);

        foreach (var kvp in filtredStudentsGrades)
        {
            string name = kvp.Key;
            List<double> grades = kvp.Value;
            Console.WriteLine($"{name} -> {grades.Average():F2}");
        }
    }
}