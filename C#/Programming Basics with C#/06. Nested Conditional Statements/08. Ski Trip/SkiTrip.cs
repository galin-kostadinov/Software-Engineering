using System;


class SkiTrip
{
    static void Main()
    {
        int days = int.Parse(Console.ReadLine());
        string roomType = Console.ReadLine();
        string raiting = Console.ReadLine();
        double price = 0;
        int night = days - 1;
        if (roomType == "room for one person")
        {
            price = (night) * 18.0;
            if (raiting == "positive")
            {
                price = price + price * 0.25;
            }
            else if (raiting == "negative")
            {
                price = price - price * 0.10;
            }
        }

        else if (roomType == "apartment")
        {
            price = night * 25.0;
            if (night < 10)
            {
                price = price - price * 0.30;
                if (raiting == "positive")
                {
                    price = price + price * 0.25;
                }
                else if (raiting == "negative")
                {
                    price = price - price * 0.10;
                }
            }
            else if (night <= 15)
            {
                price = price - price * 0.35;
                if (raiting == "positive")
                {
                    price = price + price * 0.25;
                }
                else if (raiting == "negative")
                {
                    price = price - price * 0.10;
                };
            }
            else if (night > 15)
            {
                price = price - price * 0.50;
                if (raiting == "positive")
                {
                    price = price + price * 0.25;
                }
                else if (raiting == "negative")
                {
                    price = price - price * 0.10;
                };
            }
        }

        else if (roomType == "president apartment")
        {
            price = night * 35.0;
            if (night < 10)
            {
                price = price - price * 0.10;
                if (raiting == "positive")
                {
                    price = price + price * 0.25;
                }
                else if (raiting == "negative")
                {
                    price = price - price * 0.10;
                }
            }
            else if (night <= 15)
            {
                price = price - price * 0.15;
                if (raiting == "positive")
                {
                    price = price + price * 0.25;
                }
                else if (raiting == "negative")
                {
                    price = price - price * 0.10;
                };
            }
            else if (night > 15)
            {
                price = price - price * 0.20;
                if (raiting == "positive")
                {
                    price = price + price * 0.25;
                }
                else if (raiting == "negative")
                {
                    price = price - price * 0.10;
                }
            }
        }
        Console.WriteLine($"{price:F2}");
    }
}
