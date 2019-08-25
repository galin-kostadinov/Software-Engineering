using System;

class BonusScore
{
    static void Main()
    {
        int num = int.Parse(Console.ReadLine());
        double bonusTyp1 = 0;
        double bonusTyp2 = 0;

        if (num <= 100)
        {
            bonusTyp1 = 5.0;
        }
        else if (num > 100 && num <= 1000)
        {
            bonusTyp1 = num * 0.2;
        }

        else
        {
            bonusTyp1 = num * 0.1;
        }


        if (num % 2 == 0)
        {
            bonusTyp2 = 1.0;
        }
        else if (num % 5 == 0)
        {
            bonusTyp2 = 2.0;
        }

        Console.WriteLine(bonusTyp1 + bonusTyp2);
        Console.WriteLine(num + bonusTyp1 + bonusTyp2);
    }
}
