using System;

class Coins
{
    static void Main()
    {
        decimal reset = decimal.Parse(Console.ReadLine());
        decimal numCoins = 0;
        reset = reset * 100;

        while (reset != 0)
        {
            if (reset >= 200)
            {
                numCoins = numCoins + Math.Floor(reset / 200);
                reset = reset % 200;
            }
            if (reset >= 100)
            {
                numCoins = numCoins + Math.Floor(reset / 100);
                reset = reset % 100;
            }
            if (reset >= 50)
            {
                numCoins = numCoins + Math.Floor(reset / 50);
                reset = reset % 50;
            }
            if (reset >= 20)
            {
                numCoins = numCoins + Math.Floor(reset / 20);
                reset = reset % 20;
            }
            if (reset >= 10)
            {
                numCoins = numCoins + Math.Floor(reset / 10);
                reset = reset % 10;
            }
            if (reset >= 5)
            {
                numCoins = numCoins + Math.Floor(reset / 5);
                reset = reset % 5;
            }
            if (reset >= 2)
            {
                numCoins = numCoins + Math.Floor(reset / 2);
                reset = reset % 2;
            }
            if (reset >= 1)
            {
                numCoins = numCoins + Math.Floor(reset / 1);
                reset = reset % 1;
            }
        }

        Console.WriteLine(numCoins);

    }
}
