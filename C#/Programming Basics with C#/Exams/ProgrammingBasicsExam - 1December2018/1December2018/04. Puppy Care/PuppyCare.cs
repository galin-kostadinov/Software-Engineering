using System;

class PuppyCare
{
    static void Main()
    {
        int boughtFood = int.Parse(Console.ReadLine());
        boughtFood = boughtFood * 1000;
        int eatenFood = 0;

        while (true)
        {
            string input = Console.ReadLine();

            if (input == "Adopted")
            {
                break;
            }
            eatenFood = eatenFood + int.Parse(input);
        }

        int leftFood = boughtFood - eatenFood;

        if (leftFood >= 0)
        {
            Console.WriteLine($"Food is enough! Leftovers: {leftFood} grams.");
        }
        else
        {
            Console.WriteLine($"Food is not enough. You need {Math.Abs(leftFood)} grams more.");
        }
    }
}

