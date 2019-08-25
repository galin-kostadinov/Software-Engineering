using System;

class ChristmasGifts
{
    static void Main()
    {
        int adults = 0;
        int kids = 0;
        int toysCost = 0;
        int sweatersCost = 0;

        while (true)
        {
            string input = Console.ReadLine();
            if (input == "Christmas")
            {
                break;
            }

            int age = int.Parse(input);

            if (age <= 16)
            {
                kids++;
                toysCost += 5;
            }
            else
            {
                adults++;
                sweatersCost += 15;
            }
        }
        Console.WriteLine($"Number of adults: {adults}");
        Console.WriteLine($"Number of kids: {kids}");
        Console.WriteLine($"Money for toys: {toysCost}");
        Console.WriteLine($"Money for sweaters: {sweatersCost}");
    }
}