using System;

class SushiTime
{
    static void Main()
    {
        string sushiType = Console.ReadLine();
        string restorant = Console.ReadLine();
        int numberOfPortions = int.Parse(Console.ReadLine());
        char forHome = char.Parse(Console.ReadLine());
        double price = 0;

        switch (restorant)
        {
            case "Sushi Zone":
                if (sushiType == "sashimi")
                {
                    price = 4.99;
                }
                else if (sushiType == "maki")
                {
                    price = 5.29;
                }
                else if (sushiType == "uramaki")
                {
                    price = 5.99;
                }
                else if (sushiType == "temaki")
                {
                    price = 4.29;
                }
                break;

            case "Sushi Time":
                if (sushiType == "sashimi")
                {
                    price = 5.49;
                }
                else if (sushiType == "maki")
                {
                    price = 4.69;
                }
                else if (sushiType == "uramaki")
                {
                    price = 4.49;
                }
                else if (sushiType == "temaki")
                {
                    price = 5.19;
                }
                break;

            case "Sushi Bar":
                if (sushiType == "sashimi")
                {
                    price = 5.25;
                }
                else if (sushiType == "maki")
                {
                    price = 5.55;
                }
                else if (sushiType == "uramaki")
                {
                    price = 6.25;
                }
                else if (sushiType == "temaki")
                {
                    price = 4.75;
                }
                break;

            case "Asian Pub":
                if (sushiType == "sashimi")
                {
                    price = 4.50;
                }
                else if (sushiType == "maki")
                {
                    price = 4.80;
                }
                else if (sushiType == "uramaki")
                {
                    price = 5.50;
                }
                else if (sushiType == "temaki")
                {
                    price = 5.50;
                }
                break;
            default:
                Console.WriteLine($"{restorant} is invalid restaurant!");
                break;
        }

        if (price > 0)
        {
            double totalPrice = price * numberOfPortions;

            if (forHome == 'Y')
            {
                totalPrice *= 1.2;
            }

            Console.WriteLine($"Total price: {Math.Ceiling(totalPrice)} lv.");
        }
    }
}