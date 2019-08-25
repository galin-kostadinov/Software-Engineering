using System;

class SchoolTrip
{
    static void Main()
    {
        int AbsentDays = int.Parse(Console.ReadLine());
        int preparedFood = int.Parse(Console.ReadLine());
        double foodPerDayDog1 = double.Parse(Console.ReadLine());
        double foodPerDayDog2 = double.Parse(Console.ReadLine());
        double foodPerDayDog3 = double.Parse(Console.ReadLine());

        double needFood = (foodPerDayDog1 + foodPerDayDog2 + foodPerDayDog3) * AbsentDays;
        double foodLeft = preparedFood - needFood;

        if (foodLeft >= 0)
        {
            Console.WriteLine($"{Math.Floor(foodLeft)} kilos of food left.");
        }
        else
        {
            Console.WriteLine($"{Math.Ceiling(Math.Abs(foodLeft))} more kilos of food are needed.");
        }
    }
}