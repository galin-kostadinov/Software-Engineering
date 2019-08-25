using System;

class Volleyball
{
    static void Main()
    {
        //Console.WriteLine(Math.Floor(-5.2544));//-6
        //Console.WriteLine(Math.Truncate(-5.2544));//-5
        //Console.WriteLine(Math.Floor(5.2544));//5
        //Console.WriteLine(Math.Truncate(5.2544));//5

        string typeOfYear = Console.ReadLine().ToLower();
        int holidays = int.Parse(Console.ReadLine());
        int wikendTripCount = int.Parse(Console.ReadLine());

        double numberSportingDays = 0;
        if (typeOfYear == "normal")
        {
            numberSportingDays = wikendTripCount + (48 - wikendTripCount) * 3 / 4.0 + holidays * 2 / 3.0;
            Console.WriteLine(Math.Floor(numberSportingDays));
        }
        else if (typeOfYear == "leap")
        {
            numberSportingDays = (wikendTripCount + (48 - wikendTripCount) * 3 / 4.0 + holidays * 2 / 3.0) * 1.15;
            Console.WriteLine(Math.Floor(numberSportingDays));
        }
    }
}