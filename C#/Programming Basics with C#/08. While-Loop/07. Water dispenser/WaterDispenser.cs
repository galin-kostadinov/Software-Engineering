using System;

class WaterDispenser
{
    static void Main()
    {
        string button;
        int glassVolume = int.Parse(Console.ReadLine());
        int sum = 0;
        int counter = 0;

        while (glassVolume > sum)
        {
            button = Console.ReadLine().ToLower();
            if (button == "easy")
            {
                sum = sum + 50;
            }
            else if (button == "medium")
            {
                sum = sum + 100;
            }
            else if (button == "hard")
            {
                sum = sum + 200;
            }
            ++counter;
        }

        if (sum == glassVolume)
        {
            Console.WriteLine($"The dispenser has been tapped {counter} times.");
        }
        else
        {
            Console.WriteLine($"{sum - glassVolume}ml has been spilled.");
        }

    }
}