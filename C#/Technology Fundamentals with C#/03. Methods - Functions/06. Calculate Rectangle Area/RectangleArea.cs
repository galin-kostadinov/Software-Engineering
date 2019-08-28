using System;

public class RectangleArea
{
    public static void Main()
    {
        double rectangleleWidth = double.Parse(Console.ReadLine());
        double rectangleHight = double.Parse(Console.ReadLine());
        double rectangleArea = CalculateRectangleArea(rectangleleWidth, rectangleHight);

        Console.WriteLine(rectangleArea);
    }

    public static double CalculateRectangleArea(double width, double hight)
    {
        return width * hight;
    }
}