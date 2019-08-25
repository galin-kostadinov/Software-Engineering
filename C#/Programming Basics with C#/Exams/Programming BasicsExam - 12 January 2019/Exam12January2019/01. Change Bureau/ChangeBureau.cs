using System;

class ChangeBureau
{
    static void Main()
    {
        int bitcoin = int.Parse(Console.ReadLine());
        double yan = double.Parse(Console.ReadLine());
        double commision = double.Parse(Console.ReadLine());


        double totalSum = bitcoin * 1168 + yan * 0.15 * 1.76;
        double totalEuro = (totalSum / 1.95) * (1 - commision / 100);

        Console.WriteLine($"{totalEuro:F2}");
    }
}

