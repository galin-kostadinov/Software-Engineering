using System;

class Time
{
    static void Main()
    {
        int startHour = int.Parse(Console.ReadLine());
        int startMinutes = int.Parse(Console.ReadLine());
        int timeInMinutes = startHour * 60 + startMinutes;
        int timePlus15 = timeInMinutes + 15;

        int finalHour = timePlus15 / 60;
        int finalMinutes = timePlus15 % 60;


        if (finalMinutes < 10 && finalHour < 24)
        {
            Console.WriteLine($"{finalHour}:0{finalMinutes}");
        }
        else if (finalMinutes >= 10 && finalHour < 24)
        {
            Console.WriteLine($"{finalHour}:{finalMinutes}");
        }


        if (finalMinutes < 10 && finalHour >= 24)
        {
            Console.WriteLine($"{finalHour - 24}:0{finalMinutes}");
        }
        else if (finalMinutes >= 10 && finalHour >= 24)
        {
            Console.WriteLine($"{finalHour - 24}:{finalMinutes}");
        }
    }
}
