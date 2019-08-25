using System;

class MetricConverter
{
    static void Main()
    {
        double num = double.Parse(Console.ReadLine());
        string inputUnit = Console.ReadLine();
        string outputUnit = Console.ReadLine();

        //inputUnit -> m
        if (inputUnit == "mm")
        {
            num /= 1000;
        }
        else if (inputUnit == "cm")
        {
            num /= 100;
        }
        else if (inputUnit == "mi")
        {
            num /= 0.000621371192;
        }
        else if (inputUnit == "in")
        {
            num /= 39.3700787;
        }
        else if (inputUnit == "km")
        {
            num /= 0.001;
        }
        else if (inputUnit == "ft")
        {
            num /= 3.2808399;
        }
        else if (inputUnit == "yd")
        {
            num /= 1.0936133;
        }

        //m -> outputUnit
        if (outputUnit == "mm")
        {
            num *= 1000;
        }
        else if (outputUnit == "cm")
        {
            num *= 100;
        }
        else if (outputUnit == "mi")
        {
            num *= 0.000621371192;
        }
        else if (outputUnit == "in")
        {
            num *= 39.3700787;
        }
        else if (outputUnit == "km")
        {
            num *= 0.001;
        }
        else if (outputUnit == "ft")
        {
            num *= 3.2808399;
        }
        else if (outputUnit == "yd")
        {
            num *= 1.0936133;
        }

        Console.WriteLine(num);
    }
}

