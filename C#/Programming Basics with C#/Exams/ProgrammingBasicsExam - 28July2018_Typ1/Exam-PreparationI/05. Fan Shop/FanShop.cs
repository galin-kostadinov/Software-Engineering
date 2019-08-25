using System;

class Program
{
    static void Main()
    {
        int buget = int.Parse(Console.ReadLine());
        int objectNum = int.Parse(Console.ReadLine());
        int totalPrice = 0;

        for (int i = 1; i <= objectNum; i++)
        {
            string objects = Console.ReadLine();

            switch (objects)
            {
                case "hoodie":
                    totalPrice += 30;
                    break;
                case "keychain":
                    totalPrice += 4;
                    break;
                case "T-shirt":
                    totalPrice += 20;
                    break;
                case "flag":
                    totalPrice += 15;
                    break;
                case "sticker":
                    totalPrice += 1;
                    break;
                default:
                    break;
            }
        }

        int leftMoney = buget - totalPrice;

        if (leftMoney >= 0)
        {
            Console.WriteLine($"You bought {objectNum} items and left with {leftMoney} lv.");
        }
        else
        {
            Console.WriteLine($"Not enough money, you need {Math.Abs(leftMoney)} more lv.");
        }
    }
}
