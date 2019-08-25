using System;

class CharityCampaign
{
    static void Main()
    {
        int days = int.Parse(Console.ReadLine());
        int cookers = int.Parse(Console.ReadLine());
        int cakesCount = int.Parse(Console.ReadLine());
        int waffelCount = int.Parse(Console.ReadLine());
        int pancakeslCount = int.Parse(Console.ReadLine());

        double cakesSum = cakesCount * 45;
        double waffelSum = waffelCount * 5.8;
        double pancakeslSum = pancakeslCount * 3.2;

        double dayTotalSum = (cakesSum + waffelSum + pancakeslSum) * cookers;
        double totalSum = dayTotalSum * days;

        //double result = totalSum - totalSum/8;
        double result = (1 - (1 / 8.0)) * totalSum;

        Console.WriteLine("{0:F2}", result);
    }
}
