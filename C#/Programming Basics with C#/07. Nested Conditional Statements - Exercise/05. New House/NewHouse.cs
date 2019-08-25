using System;

class NewHouse
{
    static void Main()
    {
        string flourType = Console.ReadLine();
        int flourNum = int.Parse(Console.ReadLine());
        int budget = int.Parse(Console.ReadLine());
        double totalPrice = 0.0;
        double leftMoney = 0.0;

        if (flourType == "Roses")
        {
            totalPrice = flourNum * 5.0;
            if (flourNum > 80)
            {
                totalPrice = totalPrice - totalPrice * 0.1;
            }
        }
        else if (flourType == "Dahlias")
        {
            totalPrice = flourNum * 3.8;
            if (flourNum > 90)
            {
                totalPrice = totalPrice - totalPrice * 0.15;
            }
        }
        else if (flourType == "Tulips")
        {
            totalPrice = flourNum * 2.8;
            if (flourNum > 80)
            {
                totalPrice = totalPrice - totalPrice * 0.15;
            }
        }
        else if (flourType == "Narcissus")
        {
            totalPrice = flourNum * 3.0;
            if (flourNum < 120)
            {
                totalPrice = totalPrice + totalPrice * 0.15;
            }
        }
        else if (flourType == "Gladiolus")
        {
            totalPrice = flourNum * 2.5;
            if (flourNum < 80)
            {
                totalPrice = totalPrice + totalPrice * 0.20;
            }
        }

        leftMoney = budget - totalPrice;

        if (leftMoney >= 0)
        {
            Console.WriteLine($"Hey, you have a great garden with {flourNum} {flourType} and {leftMoney:F2} leva left.");
        }
        else if (leftMoney < 0)
        {
            Console.WriteLine($"Not enough money, you need {Math.Abs(leftMoney):F2} leva more.");
        }
    }
}