using System;

class StadiumIncome
{
    static void Main()
    {
        int numSectors = int.Parse(Console.ReadLine());
        int stadiumCapacity = int.Parse(Console.ReadLine());
        double ticketPrice = double.Parse(Console.ReadLine());

        double TotalIncome = stadiumCapacity * ticketPrice;
        double incomeBySector = TotalIncome / numSectors;
        double charity = (TotalIncome - (incomeBySector * 0.75)) / 8;

        Console.WriteLine($"Total income - {TotalIncome:F2} BGN");
        Console.WriteLine($"Money for charity - {charity:F2} BGN");
    }
}
