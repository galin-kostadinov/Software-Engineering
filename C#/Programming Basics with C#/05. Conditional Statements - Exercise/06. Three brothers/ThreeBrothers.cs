using System;

class ThreeBrothers
{
    static void Main()
    {
        double timeBroutherA = double.Parse(Console.ReadLine());
        double timeBroutherB = double.Parse(Console.ReadLine());
        double timeBroutherC = double.Parse(Console.ReadLine());
        double timeFatherD = double.Parse(Console.ReadLine());
        double timeForClean = 1 / (1 / timeBroutherA + 1 / timeBroutherB + 1 / timeBroutherC);
        double timeForCleanWhitBreak = timeForClean * 1.15;

        Console.WriteLine($"Cleaning time: {timeForCleanWhitBreak:F2}");
        double leftTime = timeFatherD - timeForCleanWhitBreak;
        if (leftTime > 0)
        {
            Console.WriteLine($"Yes, there is a surprise - time left -> {Math.Floor(leftTime)} hours.");
        }
        else
        {
            Console.WriteLine($"No, there isn't a surprise - shortage of time -> {Math.Ceiling(Math.Abs(leftTime))} hours.");
        }
    }
}
