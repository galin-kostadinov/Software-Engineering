using System;

class Scholarship
{
    static void Main()
    {
        double income = double.Parse(Console.ReadLine());
        double averageSuccess = double.Parse(Console.ReadLine());
        double minSalary = double.Parse(Console.ReadLine());

        double socialScholarship = 0.0;
        double excellentScholarship = 0.0;

        if (averageSuccess < 4.5)
        {
            Console.WriteLine("You cannot get a scholarship!");
        }
        else if (averageSuccess < 5.5 && income > minSalary)
        {
            Console.WriteLine("You cannot get a scholarship!");
        }
        else if (averageSuccess < 5.5 && income < minSalary)
        {
            socialScholarship = 0.35 * minSalary;
            Console.WriteLine($"You get a Social scholarship {Math.Floor(socialScholarship)} BGN");
        }
        else if (averageSuccess >= 5.5 && income > minSalary)
        {
            excellentScholarship = 25 * averageSuccess;
            Console.WriteLine($"You get a scholarship for excellent results {Math.Floor(excellentScholarship)} BGN");
        }
        else
        {
            excellentScholarship = 25 * averageSuccess;
            socialScholarship = 0.35 * minSalary;
            if (excellentScholarship > socialScholarship)
            {
                Console.WriteLine($"You get a scholarship for excellent results {Math.Floor(excellentScholarship)} BGN");
            }
            else
            {
                Console.WriteLine($"You get a Social scholarship {Math.Floor(socialScholarship)} BGN");
            }
        }
    }
}
