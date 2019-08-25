using System;

class WeddingHall
{
    static void Main()
    {
        double hallLenght = double.Parse(Console.ReadLine());
        double hallWidth = double.Parse(Console.ReadLine());
        double barSite = double.Parse(Console.ReadLine());

        double hallArea = hallLenght * hallWidth;
        double dancingArea = hallArea * 0.19;
        double freeSpace = hallArea - dancingArea - barSite * barSite;
        double People = Math.Ceiling(freeSpace / 3.2);

        Console.WriteLine(People);
    }
}