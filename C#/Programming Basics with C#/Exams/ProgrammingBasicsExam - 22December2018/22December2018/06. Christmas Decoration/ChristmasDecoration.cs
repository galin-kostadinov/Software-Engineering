using System;

class ChristmasDecoration
{
    static void Main()
    {
        int buget = int.Parse(Console.ReadLine());
        int leftMoney = buget;
        while (true)
        {
            string input = Console.ReadLine();
            if (input != "Stop")
            {
                int itemPrice = 0;
                for (int i = 0; i < input.Length; i++)
                {
                    itemPrice += input[i];
                }

                if (leftMoney >= itemPrice)
                {
                    leftMoney -= itemPrice;
                    Console.WriteLine("Item successfully purchased!");
                }
                else
                {
                    Console.WriteLine("Not enough money!");
                    break;
                }
            }
            else
            {
                Console.WriteLine($"Money left: {leftMoney}");
                break;
            }
        }
    }
}