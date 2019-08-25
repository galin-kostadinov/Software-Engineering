using System;

class EqualSumsLeftRightPosition
{
    static void Main()
    {
        int firstNumber = int.Parse(Console.ReadLine());
        int secondNumber = int.Parse(Console.ReadLine());

        for (int num = firstNumber; num <= secondNumber; num++)
        {

            int lastRemainder = 0;
            int startNumsSum = 0;
            int endNumsSum = 0;
            int middleNum = 0;
            int reduceNum = num;

            for (int i = 4; i >= 0; i--)
            {
                lastRemainder = reduceNum % 10;
                reduceNum = (reduceNum - lastRemainder) / 10;

                if (i == 0 || i == 1)
                {
                    startNumsSum = startNumsSum + lastRemainder;
                }
                else if (i == 3 || i == 4)
                {
                    endNumsSum = endNumsSum + lastRemainder;
                }
                else
                {
                    middleNum = lastRemainder;
                }
            }

            if (startNumsSum == endNumsSum)
            {
                Console.Write(num + " ");
            }
            else if (startNumsSum > endNumsSum)
            {

                endNumsSum = endNumsSum + middleNum;
                if (startNumsSum == endNumsSum)
                {
                    Console.Write(num + " ");
                }
            }
            else
            {
                startNumsSum = startNumsSum + middleNum;
                if (startNumsSum == endNumsSum)
                {
                    Console.Write(num + " ");
                }
            }
        }
    }
}
