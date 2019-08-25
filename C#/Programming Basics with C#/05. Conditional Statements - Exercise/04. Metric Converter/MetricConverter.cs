using System;

class MetricConverter
{
    static void Main()
    {
        double num = double.Parse(Console.ReadLine());
        string inputUnit = Console.ReadLine();
        string outputUnit = Console.ReadLine();

        double outputNum = 0;

        if (inputUnit == "m")
        {
            if (outputUnit == "mm")
            {
                outputNum = num * 1000;
                Console.WriteLine($"{outputNum:F3}");
            }
            else if (outputUnit == "cm")
            {
                outputNum = num * 100;
                Console.WriteLine($"{outputNum:F3}");
            }
        }

        if (inputUnit == "mm")
        {
            if (outputUnit == "m")
            {
                outputNum = num / 1000;
                Console.WriteLine($"{outputNum:F3}");
            }
            else if (outputUnit == "cm")
            {
                outputNum = num / 10;
                Console.WriteLine($"{outputNum:F3}");
            }
        }

        if (inputUnit == "cm")
        {
            if (outputUnit == "m")
            {
                outputNum = num / 100;
                Console.WriteLine($"{outputNum:F3}");
            }
            else if (outputUnit == "mm")
            {
                outputNum = num * 10;
                Console.WriteLine($"{outputNum:F3}");
            }
        }
    }
}

