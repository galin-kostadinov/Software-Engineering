using System;

class ComputerFirm
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        double TotalPosibleSales = 0;
        int ratingSum = 0;

        for (int i = 0; i < n; i++)
        {
            int input = int.Parse(Console.ReadLine());
            int rating = input % 10;
            double posibleSales = (input - rating) / 10;
            ratingSum += rating;

            if (rating == 3)
            {
                TotalPosibleSales += posibleSales * 0.5;
            }
            else if (rating == 4)
            {
                TotalPosibleSales += posibleSales * 0.7;
            }
            else if (rating == 5)
            {
                TotalPosibleSales += posibleSales * 0.85;
            }
            else if (rating == 6)
            {
                TotalPosibleSales += posibleSales;
            }
        }

        double averageRating = 1.0 * ratingSum / n;

        Console.WriteLine($"{TotalPosibleSales:F2}");
        Console.WriteLine($"{averageRating:F2}");
    }
}