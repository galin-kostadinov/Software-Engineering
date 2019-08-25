using System;

class Travelling
{
    static void Main()
    {
        string destination = " ";
        double tripPrice = 0;
        double sum = 0;

        for (destination = Console.ReadLine(); destination != "End"; destination = Console.ReadLine())
        {
            tripPrice = double.Parse(Console.ReadLine());
            while (tripPrice > sum)
            {
                sum = sum + double.Parse(Console.ReadLine());
            }
            Console.WriteLine($"Going to {destination}!");
            sum = 0;
        }
    }
}
