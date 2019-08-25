using System;

class WeddingInvestment
{
    static void Main()
    {
        string termOfTheContract = Console.ReadLine();
        string contractType = Console.ReadLine();
        string dessert = Console.ReadLine();
        int months = int.Parse(Console.ReadLine());
        double totalPrice = 0;
        double monthPrice = 0;

        switch (contractType)
        {
            case "Small":
                if (termOfTheContract == "one")
                {
                    monthPrice = 9.98;
                }
                else
                {
                    monthPrice = 8.58;
                }
                break;
            case "Middle":
                if (termOfTheContract == "one")
                {
                    monthPrice = 18.99;
                }
                else
                {
                    monthPrice = 17.09;
                }
                break;
            case "Large":
                if (termOfTheContract == "one")
                {
                    monthPrice = 25.98;
                }
                else
                {
                    monthPrice = 23.59;
                }
                break;
            case "ExtraLarge":
                if (termOfTheContract == "one")
                {
                    monthPrice = 35.99;
                }
                else
                {
                    monthPrice = 31.79;
                }
                break;
            default:
                break;
        }

        if (dessert == "yes")
        {
            if (monthPrice <= 10)
            {
                monthPrice += 5.5;
            }
            else if (monthPrice <= 30)
            {
                monthPrice += 4.35;
            }
            else if (monthPrice > 30)
            {
                monthPrice += 3.85;
            }
        }

        if (termOfTheContract == "two")
        {
            monthPrice -= monthPrice * 3.75 / 100;
        }
        totalPrice = monthPrice * months;

        Console.WriteLine($"{totalPrice:F2} lv.");
    }
}