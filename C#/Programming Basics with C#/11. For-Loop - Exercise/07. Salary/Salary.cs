using System;

class Salary
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int salary = int.Parse(Console.ReadLine());
        for (int i = 1; i <= n; i++)
        {
            string saitName = Console.ReadLine();
            if (saitName == "Facebook")
            {
                salary = salary - 150;
            }
            else if (saitName == "Instagram")
            {
                salary = salary - 100;
            }
            else if (saitName == "Reddit")
            {
                salary = salary - 50;
            }
            if (salary <= 0)
            {
                break;
            }
        }

        if (salary <= 0)
        {
            Console.WriteLine("You have lost your salary.");
        }
        else
        {
            Console.WriteLine(salary);
        }
    }
}


