using System;

class PastryShop
{
    static void Main()
    {
        string sweets = Console.ReadLine();
        int sweetsNum = int.Parse(Console.ReadLine());
        int day = int.Parse(Console.ReadLine());
        double TotalPrice = 0;

        if (day <= 15)
        {
            switch (sweets)
            {
                case "Cake":
                    TotalPrice = 24.0 * sweetsNum;
                    break;
                case "Souffle":
                    TotalPrice = 6.66 * sweetsNum;
                    break;
                case "Baklava":
                    TotalPrice = 12.60 * sweetsNum;
                    break;

                default:
                    break;
            }
        }
        else
        {
            switch (sweets)
            {
                case "Cake":
                    TotalPrice = 28.7 * sweetsNum;
                    break;
                case "Souffle":
                    TotalPrice = 9.8 * sweetsNum;
                    break;
                case "Baklava":
                    TotalPrice = 16.98 * sweetsNum;
                    break;

                default:
                    break;
            }
        }

        if (day <= 22)
        {
            if (TotalPrice > 200)
            {
                TotalPrice *= 0.75;
            }
            else if (TotalPrice >= 100)
            {
                TotalPrice *= 0.85;
            }
        }

        if (day <= 15)
        {
            TotalPrice *= 0.90;
        }

        Console.WriteLine($"{TotalPrice:F2}");
    }
}