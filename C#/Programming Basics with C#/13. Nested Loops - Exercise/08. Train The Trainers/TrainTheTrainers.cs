using System;

class TrainTheTrainers
{
    static void Main()
    {
        int countJury = int.Parse(Console.ReadLine());
        double sumMultyEvalutions = 0;
        double averageEvalutionByPresentation = 0;
        double averageEvalutionByPresentations = 0;

        int counterPresentation = 0;

        for (string presentationName = Console.ReadLine(); presentationName != "Finish"; presentationName = Console.ReadLine())
        {
            double sumSingleEvalutions = 0;

            for (int i = 0; i < countJury; i++)
            {
                double input = double.Parse(Console.ReadLine());
                sumSingleEvalutions = sumSingleEvalutions + input;
            }

            averageEvalutionByPresentation = sumSingleEvalutions / countJury;
            sumMultyEvalutions = sumMultyEvalutions + averageEvalutionByPresentation;

            Console.WriteLine($"{presentationName} - {averageEvalutionByPresentation:F2}.");
            ++counterPresentation;
        }

        averageEvalutionByPresentations = sumMultyEvalutions / counterPresentation;
        Console.WriteLine($"Student's final assessment is {averageEvalutionByPresentations:F2}.");
    }
}
