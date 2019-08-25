using System;

class WeddingPresents
{
    static void Main()
    {
        int guestsNum = int.Parse(Console.ReadLine());
        int presentNum = int.Parse(Console.ReadLine());
        int money = 0;
        int еlectricalDevice = 0;
        int voucher = 0;
        int other = 0;

        for (int i = 0; i < presentNum; i++)
        {
            string presentCategory = Console.ReadLine();
            if (presentCategory == "A")
            {
                money++;
            }
            else if (presentCategory == "B")
            {
                еlectricalDevice++;
            }
            else if (presentCategory == "V")
            {
                voucher++;
            }
            else if (presentCategory == "G")
            {
                other++;
            }
        }

        Console.WriteLine($"{(100.0 * money / presentNum):F2}%");
        Console.WriteLine($"{(100.0 * еlectricalDevice / presentNum):F2}%");
        Console.WriteLine($"{(100.0 * voucher / presentNum):F2}%");
        Console.WriteLine($"{(100.0 * other / presentNum):F2}%");
        Console.WriteLine($"{(100.0 * presentNum / guestsNum):F2}%");
    }
}