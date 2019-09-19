using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        var productQuantity = new Dictionary<string, int>();
        var productPrice = new Dictionary<string, decimal>();

        while (true)
        {
            List<string> products = Console.ReadLine()
                .Split()
                .ToList();

            if (products[0] == "buy")
            {
                break;
            }

            string name = products[0];
            decimal price = decimal.Parse(products[1]);
            int quantity = int.Parse(products[2]);

            if (!productQuantity.ContainsKey(name))
            {
                productQuantity[name] = quantity;
                productPrice[name] = price;

            }
            else
            {
                productQuantity[name] += quantity;

                if (productPrice[name] != price)
                {
                    productPrice[name] = price;
                }
            }
        }
        foreach (var kvp in productQuantity)
        {
            decimal totalPrice = productQuantity[kvp.Key] * productPrice[kvp.Key];
            Console.WriteLine($"{kvp.Key} -> {totalPrice:F2}");
        }
    }
}