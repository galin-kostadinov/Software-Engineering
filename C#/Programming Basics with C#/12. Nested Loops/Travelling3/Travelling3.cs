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
            
            double tripPrice = double.Parse(Console.ReadLine());
            while (tripPrice > 0)
            {
                double saveMoney = double.Parse(Console.ReadLine());
                tripPrice -= saveMoney;
            }
            Console.WriteLine($"Going to {destination}!");

        }
    }
}