using System;


class Sum_Seconds
{
    static void Main()
    {
        int racer1 = int.Parse(Console.ReadLine());
        int racer2 = int.Parse(Console.ReadLine());
        int racer3 = int.Parse(Console.ReadLine());
        int sum = racer1 + racer2 + racer3;
        if (sum < 60 && sum > 0)
        {
            if (sum <= 9)
            {
                Console.WriteLine($"0:0{sum}");
            }
            else { Console.WriteLine($"0:{sum}"); }
        }
        if (sum > 59 && sum < 120)
        {
            if (sum <= 69)
            {
                Console.WriteLine($"1:0{sum - 60}");
            }
            else { Console.WriteLine($"1:{sum - 60}"); }
        }
        if (sum > 119 && sum < 179)
        {
            if (sum <= 129)
            {
                Console.WriteLine($"2:0{sum - 120}");
            }
            else { Console.WriteLine($"2:{sum - 120}"); }
        }
    }
}
