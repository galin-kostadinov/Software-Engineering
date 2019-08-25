using System;

class WorldSwimmingRecord
{
    static void Main()
    {
        double WorldSwimmingRecord = double.Parse(Console.ReadLine());
        double DistanceMeters = double.Parse(Console.ReadLine());
        double IvanTimeFotMeter = double.Parse(Console.ReadLine()); //seconds
        double IvanSwimingTime = DistanceMeters * IvanTimeFotMeter + Math.Floor(DistanceMeters / 15.0) * 12.5;
        if (WorldSwimmingRecord > IvanSwimingTime)
        {
            Console.WriteLine($"Yes, he succeeded! The new world record is {IvanSwimingTime:F2} seconds.");
        }
        else
        {
            Console.WriteLine($"No, he failed! He was {(IvanSwimingTime - WorldSwimmingRecord):F2} seconds slower.");
        }
    }
}