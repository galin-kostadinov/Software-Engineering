using System;

class FamilyHouse
{
    static void Main()
    {
        int months = int.Parse(Console.ReadLine());
        double electricity = 0;
        double water = 20;
        double internet = 15;
        double other = 0;

        for (int i = 0; i < months; i++)
        {
            double input = double.Parse(Console.ReadLine());
            electricity += input;
            other += (water + internet + input) * 1.2;
        }

        double average = (electricity + other) / months + water + internet;

        Console.WriteLine($"Electricity: {electricity:F2} lv");
        Console.WriteLine($"Water: {months * water:F2} lv");
        Console.WriteLine($"Internet: {months * internet:F2} lv");
        Console.WriteLine($"Other: {other:F2} lv");
        Console.WriteLine($"Average: {average:F2} lv");

    }
}