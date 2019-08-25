using System;

class Everest
{
    static void Main()
    {
        int level = 5364;
        int EverestLevel = 8848;
        int days = 1;

        while (level < EverestLevel)
        {
            string overnight = Console.ReadLine();

            if (overnight == "END")
            {
                break;
            }
            if (overnight == "Yes"&& days<5)
            {
                days++;
            }
            else if (overnight == "Yes" && days == 5)
            {
                break;
            }
            if (level >= EverestLevel)
            {
                break;
            }
            level += int.Parse(Console.ReadLine());
            
        }

        if (level >= EverestLevel)
        {
            Console.WriteLine($"Goal reached for {days} days!");
        }
        else
        {
            Console.WriteLine("Failed!");
            Console.WriteLine(level);
        }

    }
}