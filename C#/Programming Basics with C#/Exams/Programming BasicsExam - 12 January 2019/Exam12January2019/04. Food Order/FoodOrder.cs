using System;

class FoodOrder
{
    static void Main()
    {
        double buget = double.Parse(Console.ReadLine());
        double totalSum = 2.5;
        int itemsNumb = 0;

        while (true)
        {
            string product = Console.ReadLine();
            if (product == "Order")
            {
                break;
            }

            double price = double.Parse(Console.ReadLine());

            if (totalSum <= buget)
            {
                totalSum = totalSum + price;
                itemsNumb++;

                if (totalSum > buget)
                {
                    totalSum = totalSum - price;
                    itemsNumb--;
                    Console.WriteLine("You will exceed the budget if you order this!");
                }
            }
        }

        Console.WriteLine($"You ordered {itemsNumb} items!");
        Console.WriteLine($"Total: {totalSum:F2}");
    }
}

