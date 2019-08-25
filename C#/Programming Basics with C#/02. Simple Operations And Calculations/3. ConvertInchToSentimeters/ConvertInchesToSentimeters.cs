using System;

    class ConvertInchesToSentimeters
{
    static void Main()
    {
        double inches = double.Parse(Console.ReadLine());

        double convertRatio = 2.54;
        double centimeters = inches * convertRatio;
        Console.WriteLine("{0:F2}", centimeters);
     }
}
