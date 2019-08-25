using System;

class Travelling2
{
    static void Main()
    {
        while (true)
        {
            string destination = Console.ReadLine();
            if (destination == "End")
            {
                return;
            }

            int tripPrice = int.Parse(Console.ReadLine());
            while (tripPrice > 0)
            {
                int saveMoney = int.Parse(Console.ReadLine());
                tripPrice -= saveMoney;
            }
            Console.WriteLine($"Going to {destination}!");

        }
    }
}