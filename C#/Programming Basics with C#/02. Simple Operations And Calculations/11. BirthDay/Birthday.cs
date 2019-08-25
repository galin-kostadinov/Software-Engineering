using System;

class Birthday
{
    static void Main()
    {
        int L = int.Parse(Console.ReadLine());
        int B = int.Parse(Console.ReadLine());
        int H = int.Parse(Console.ReadLine());
        double percent = double.Parse(Console.ReadLine());

        double volumeAquarium = L * B * H * 0.001;
        double volumeWater = volumeAquarium * (1 - percent * 0.01);

        Console.WriteLine("{0:F3}", volumeWater);
    }
}
