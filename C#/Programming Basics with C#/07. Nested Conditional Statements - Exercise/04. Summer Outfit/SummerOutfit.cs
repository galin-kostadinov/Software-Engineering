using System;

class SummerOutfit
{
    static void Main()
    {
        int degrees = int.Parse(Console.ReadLine());
        string dayTime = Console.ReadLine().ToLower();

        if (degrees >= 10 && degrees <= 18)
        {
            if (dayTime == "morning")
            {
                Console.WriteLine($"It's {degrees} degrees, get your Sweatshirt and Sneakers.");
            }
            else if (dayTime == "afternoon" || dayTime == "evening")
            {
                Console.WriteLine($"It's {degrees} degrees, get your Shirt and Moccasins.");
            }
        }
        if (degrees > 18 && degrees <= 24)
        {
            if (dayTime == "morning" || dayTime == "evening")
            {
                Console.WriteLine($"It's {degrees} degrees, get your Shirt and Moccasins.");
            }
            else if (dayTime == "afternoon")
            {
                Console.WriteLine($"It's {degrees} degrees, get your T-Shirt and Sandals.");
            }
        }
        if (degrees >= 25)
        {
            if (dayTime == "morning")
            {
                Console.WriteLine($"It's {degrees} degrees, get your T-Shirt and Sandals.");
            }
            else if (dayTime == "afternoon")
            {
                Console.WriteLine($"It's {degrees} degrees, get your Swim Suit and Barefoot.");
            }
            else if (dayTime == "evening")
            {
                Console.WriteLine($"It's {degrees} degrees, get your Shirt and Moccasins.");
            }
        }
    }

}