using System;

class SquareAreaDouble
{
    static void Main()
    {
        //get square side size
        Console.Write("squareSide = ");
        double squareSide = double.Parse(Console.ReadLine());

        //calculate area
        double squareArea = squareSide * squareSide;
        //write to console
        Console.WriteLine("squareArea = {0}", squareArea);

    }
}
