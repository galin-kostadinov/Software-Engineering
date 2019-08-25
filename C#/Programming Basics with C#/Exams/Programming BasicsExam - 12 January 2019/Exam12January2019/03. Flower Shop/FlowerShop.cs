using System;

class FlowerShop
{
    static void Main()
    {
        int chrysanthemums = int.Parse(Console.ReadLine());
        int roses = int.Parse(Console.ReadLine());
        int tulips = int.Parse(Console.ReadLine());
        string sesson = Console.ReadLine();
        string day = Console.ReadLine();
        double totalSum = 0;
        int totalNumber = chrysanthemums + roses + tulips;

        if (sesson == "Spring" || sesson == "Summer")
        {
            totalSum = chrysanthemums * 2.0 + roses * 4.1 + tulips * 2.5;
        }
        else if (sesson == "Autumn" || sesson == "Winter")
        {
            totalSum = chrysanthemums * 3.75 + roses * 4.5 + tulips * 4.15;
        }

        if (day == "Y")
        {
            totalSum *= 1.15;
        }

        if (tulips > 7 && sesson == "Spring")
        {
            totalSum *= 0.95;
        }

        if (roses >= 10 && sesson == "Winter")
        {
            totalSum *= 0.9;
        }

        if (totalNumber > 20)
        {
            totalSum *= 0.8;
        }

        totalSum += 2;
        Console.WriteLine($"{totalSum:F2}");
    }
}

