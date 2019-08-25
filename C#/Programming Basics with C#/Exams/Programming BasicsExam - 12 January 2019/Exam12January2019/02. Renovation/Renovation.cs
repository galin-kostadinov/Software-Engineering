using System;

class Renovation
{
    static void Main()
    {
        double budjet = double.Parse(Console.ReadLine());
        double floorWhidth = double.Parse(Console.ReadLine());
        double floorLenght = double.Parse(Console.ReadLine());
        double triangleSide = double.Parse(Console.ReadLine());
        double triangleHidht = double.Parse(Console.ReadLine());
        double tilePrice = double.Parse(Console.ReadLine());
        double masterPrice = double.Parse(Console.ReadLine());

        double floorArea = floorWhidth * floorLenght;
        double triangleArea = triangleSide * triangleHidht / 2;
        double tileNum = Math.Ceiling(floorArea / triangleArea) + 5;
        double TotalPrice = tileNum * tilePrice + masterPrice;

        double leftMoney = budjet - TotalPrice;

        if (leftMoney >= 0)
        {

            Console.WriteLine($"{leftMoney:F2} lv left.");
        }
        else
        {
            Console.WriteLine($"You'll need {-1.0 * leftMoney:F2} lv more.");
        }

    }
}

