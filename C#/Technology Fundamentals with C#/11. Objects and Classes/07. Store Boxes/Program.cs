using System;
using System.Collections.Generic;
using System.Linq;

namespace _07._Store_Boxes
{
    public class Item
    {
        public string ItemName { get; set; }

        public decimal ItemPrice { get; set; }
    }

    public class Box
    {

        public string SerialNumber { get; set; }

        public Item Item { get; set; }

        public int ItemQuantity { get; set; }

        public decimal PriceBox { get; set; }

    }

    public class Program
    {
        public static void Main()
        {
            var boxes = new List<Box>();

            while (true)
            {
                string input = Console.ReadLine();

                if (input == "end")
                {
                    break;
                }

                string[] tokens = input.Split().ToArray();

                string serialNumber = tokens[0];
                string itemName = tokens[1];
                int itemQuantity = int.Parse(tokens[2]);
                decimal itemPrice = decimal.Parse(tokens[3]);

                Box box = new Box();
                box.Item = new Item();

                box.Item.ItemName = itemName;
                box.Item.ItemPrice = itemPrice;
                box.ItemQuantity = itemQuantity;
                box.SerialNumber = serialNumber;
                box.PriceBox = itemQuantity * itemPrice;

                boxes.Add(box);
            }

            var filtredBoxes = boxes
                .OrderByDescending(x => x.PriceBox)
                .ToList();

            foreach (var box in filtredBoxes)
            {
                Console.WriteLine(box.SerialNumber);
                Console.WriteLine($"-- {box.Item.ItemName} - ${box.Item.ItemPrice:F2}: {box.ItemQuantity}");
                Console.WriteLine($"-- ${box.PriceBox:F2}");
            }

        }
    }
}
