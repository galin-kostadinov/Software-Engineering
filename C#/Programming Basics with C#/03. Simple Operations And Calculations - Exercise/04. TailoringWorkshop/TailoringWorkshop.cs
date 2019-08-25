using System;

class TailoringWorkshop
{
    static void Main()
    {
        int tables = int.Parse(Console.ReadLine());
        double tablesLenght = double.Parse(Console.ReadLine());
        double tablesWidth = double.Parse(Console.ReadLine());

        double coversArea = tables * (tablesLenght + 2 * 0.3) * (tablesWidth + 2 * 0.3);

        //double squareArea = tables * (tablesLenght / 2) * (tablesLenght / 2);
        double squareArea = tables * Math.Pow((tablesLenght / 2), 2);


        double priceUSD = coversArea * 7 + squareArea * 9;
        double priceBGN = priceUSD * 1.85;
        Console.WriteLine("{0:F2} USD", priceUSD);
        Console.WriteLine("{0:F2} BGN", priceBGN);
    }
}
