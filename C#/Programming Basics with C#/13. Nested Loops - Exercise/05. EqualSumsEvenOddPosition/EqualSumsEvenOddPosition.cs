using System;

class EqualSumsEvenOddPosition
{
    static void Main()
    {
        int firstNumber = int.Parse(Console.ReadLine());
        int secondNumber = int.Parse(Console.ReadLine());

        for (int num = firstNumber; num <= secondNumber; num++)
        {
            int lastNum = 0;
            int evenSum = 0;
            int oddSum = 0;
            int reduceNum = num;

            for (int i = 5; i >= 0; i--)
            {
                lastNum = reduceNum % 10;
                reduceNum = (reduceNum - lastNum) / 10;
                if (i % 2 == 0)
                {
                    evenSum = evenSum + lastNum;
                }
                else
                {
                    oddSum = oddSum + lastNum;
                }
            }

            if (evenSum == oddSum)
            {
                Console.Write(num + " ");
            }
        }
    }
}
