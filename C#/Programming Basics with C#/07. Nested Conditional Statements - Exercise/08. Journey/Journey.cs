using System;

class Journey
{
    static void Main()
    {
        double buget = double.Parse(Console.ReadLine());
        string sesson = Console.ReadLine().ToLower();

        if (buget <= 100)
        {
            Console.WriteLine("Somewhere in Bulgaria");
            if (sesson == "summer")
            {
                buget = buget * 0.30;
                Console.WriteLine($"Camp - {buget:F2}");
            }
            else if (sesson == "winter")
            {
                buget = buget * 0.70;
                Console.WriteLine($"Hotel - {buget:F2}");
            }
        }
        else if (buget <= 1000)
        {
            Console.WriteLine("Somewhere in Balkans");
            if (sesson == "summer")
            {
                buget = buget * 0.40;
                Console.WriteLine($"Camp - {buget:F2}");
            }
            else if (sesson == "winter")
            {
                buget = buget * 0.80;
                Console.WriteLine($"Hotel - {buget:F2}");
            }
        }
        else if (buget > 1000)
        {
            Console.WriteLine("Somewhere in Europe");
            buget = buget * 0.90;
            Console.WriteLine($"Hotel - {buget:F2}");
        }
    }
}