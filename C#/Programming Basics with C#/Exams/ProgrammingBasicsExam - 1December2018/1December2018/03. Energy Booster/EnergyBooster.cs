using System;

class EnergyBooster
{
    static void Main()
    {
        string fruit = Console.ReadLine();
        string stackSize = Console.ReadLine();
        int stackNum = int.Parse(Console.ReadLine());
        double totalPrice = 0;
        double price = 0;

        switch (fruit)
        {
            case "Watermelon":
                if (stackSize == "small")
                {
                    price = 56;
                }
                else
                {
                    price = 28.70;
                }
                break;
            case "Mango":
                if (stackSize == "small")
                {
                    price = 36.66;
                }
                else
                {
                    price = 19.60;
                }
                break;
            case "Pineapple":
                if (stackSize == "small")
                {
                    price = 42.10;
                }
                else
                {
                    price = 24.80;
                }
                break;
            case "Raspberry":
                if (stackSize == "small")
                {
                    price = 20;
                }
                else
                {
                    price = 15.20;
                }
                break;

            default:
                break;
        }

        if (stackSize == "small")
        {
            totalPrice = stackNum * price * 2;
        }
        else
        {
            totalPrice = stackNum * price * 5;
        }

        if (totalPrice > 1000)
        {
            totalPrice *= 0.5;
        }
        else if (totalPrice >= 400)
        {
            totalPrice *= 0.85;
        }

        Console.WriteLine($"{totalPrice:F2} lv.");
    }
}