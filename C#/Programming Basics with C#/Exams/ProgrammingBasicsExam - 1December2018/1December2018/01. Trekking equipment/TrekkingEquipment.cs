using System;

class TrekkingEquipment
{
    static void Main()
    {
        int climbers = int.Parse(Console.ReadLine());
        int carabiners = int.Parse(Console.ReadLine());
        int ropes = int.Parse(Console.ReadLine());
        int pickeys = int.Parse(Console.ReadLine());

        double totalPrice = climbers * (carabiners * 36 + ropes * 3.60 + pickeys * 19.80) * 1.2;
        Console.WriteLine($"{totalPrice:F2}");
    }
}