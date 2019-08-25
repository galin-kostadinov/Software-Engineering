using System;

class Bus
{
    static void Main()
    {
        int startPassengers = int.Parse(Console.ReadLine());
        int busStops = int.Parse(Console.ReadLine());
        int arrivelPassengers = startPassengers;

        for (int i = 1; i <= busStops; i++)
        {
            int leftPassengers = int.Parse(Console.ReadLine());
            int comePassengers = int.Parse(Console.ReadLine());

            if (i % 2 != 0)
            {
                arrivelPassengers += comePassengers - leftPassengers + 2;
            }
            else
            {
                arrivelPassengers += comePassengers - leftPassengers - 2;
            }
        }

        Console.WriteLine($"The final number of passengers is : {arrivelPassengers}");

    }
}