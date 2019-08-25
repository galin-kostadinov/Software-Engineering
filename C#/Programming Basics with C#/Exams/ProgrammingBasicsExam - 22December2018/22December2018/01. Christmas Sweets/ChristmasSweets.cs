using System;

class ChristmasSweets
{
    static void Main()
    {
        double baklavaPrice = double.Parse(Console.ReadLine());
        double muffinsPrice = double.Parse(Console.ReadLine());

        double stollenKg = double.Parse(Console.ReadLine());
        double candyKg = double.Parse(Console.ReadLine());
        int biscuitsKg = int.Parse(Console.ReadLine());

        double totalPrice = stollenKg * baklavaPrice * 1.6 + candyKg * muffinsPrice * 1.8 + biscuitsKg * 7.5;
        Console.WriteLine($"{totalPrice:F2}");
    }
}