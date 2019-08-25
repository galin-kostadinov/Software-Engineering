using System;

class Cinema
{
    static void Main()
    {
        string typeOfProjection = Console.ReadLine().ToLower();
        int row = int.Parse(Console.ReadLine());
        int column = int.Parse(Console.ReadLine());
        double profit = 0.0;

        switch (typeOfProjection)
        {
            case "premiere":
                profit = row * column * 12.0;
                Console.WriteLine($"{profit:F2} leva");
                break;
            case "normal":
                profit = row * column * 7.50;
                Console.WriteLine($"{profit:F2} leva");
                break;
            case "discount":
                profit = row * column * 5.00;
                Console.WriteLine($"{profit:F2} leva");
                break;
            default:
                break;
        }
    }
}