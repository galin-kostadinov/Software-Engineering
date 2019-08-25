using System;

class BachelorParty
{
    static void Main()
    {
        int guestPerformer = int.Parse(Console.ReadLine());
        int gusetsNum = 0;
        int income = 0;

        while (true)
        {
            string input = Console.ReadLine();
            if (input == "The restaurant is full")
            {
                break;
            }
            int guestsGroup = int.Parse(input);
            gusetsNum += guestsGroup;
            if (guestsGroup < 5)
            {
                income += guestsGroup * 100;
            }
            else if (guestsGroup >= 5)
            {
                income += guestsGroup * 70;
            }
        }

        if (income >= guestPerformer)
        {
            Console.WriteLine($"You have {gusetsNum} guests and {income - guestPerformer} leva left.");
        }
        else
        {
            Console.WriteLine($"You have {gusetsNum} guests and {income} leva income, but no singer.");
        }

    }
}