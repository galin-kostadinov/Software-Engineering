using System;

public class Orders
{
    public static void Main()
    {
        string product = Console.ReadLine();
        int quantity = int.Parse(Console.ReadLine());
        double totalPrice = TotalPriceForSelectedProduct(product, quantity);

        Console.WriteLine($"{totalPrice:F2}");

    }

    public static double TotalPriceForSelectedProduct(string product, int quantity)
    {
        double totalPrice = 0;

        switch (product)
        {
            case "coffee":
                totalPrice = 1.5 * quantity;
                break;
            case "water":
                totalPrice = 1.0 * quantity;
                break;
            case "coke":
                totalPrice = 1.4 * quantity;
                break;
            case "snacks":
                totalPrice = 2.0 * quantity;
                break;
            default:
                break;
        }

        return totalPrice;
    }

}