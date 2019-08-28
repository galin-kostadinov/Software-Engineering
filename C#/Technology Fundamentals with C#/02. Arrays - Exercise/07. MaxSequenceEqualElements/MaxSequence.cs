using System;
using System.Linq;

public class MaxSequence
{
    public static void Main()
    {
        int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();


        int counterFirstSequence = 0;
        int counterSecondSequence = 0;
        int firstNumberPerSequence = 0;
        int secondNumberPerSequence = 0;
        int firstNumIndex = -1;
        int secondNumIndex = -1;

        for (int i = 0; i < numbers.Length - 1; i++)
        {
            if (numbers[i] == numbers[i + 1])
            {
                if (counterFirstSequence == 0)
                {
                    firstNumberPerSequence = numbers[i];
                    counterFirstSequence = 2;
                    firstNumIndex = i;
                }
                else if (firstNumberPerSequence == numbers[i] && firstNumIndex + 1 == i)
                {
                    counterFirstSequence++;
                    firstNumIndex = i;
                }
                else if (firstNumberPerSequence == numbers[i] && firstNumIndex + 1 != i && counterSecondSequence == 0)
                {
                    secondNumberPerSequence = numbers[i];
                    counterSecondSequence = 2;
                    secondNumIndex = i;
                }
                else if (secondNumberPerSequence == numbers[i] && secondNumIndex + 1 == i)
                {
                    counterSecondSequence++;
                    secondNumIndex = i;
                }
                else
                {
                    if (counterFirstSequence < counterSecondSequence)
                    {
                        counterFirstSequence = counterSecondSequence;
                        firstNumberPerSequence = secondNumberPerSequence;
                        firstNumIndex = secondNumIndex;
                        counterSecondSequence = 2;
                        secondNumberPerSequence = numbers[i];
                        secondNumIndex = i;
                    }
                    else
                    {
                        counterSecondSequence = 2;
                        secondNumberPerSequence = numbers[i];
                        secondNumIndex = i;
                    }
                }
            }
        }

        if (counterFirstSequence > 0 && counterFirstSequence >= counterSecondSequence)
        {
            for (int i = 1; i <= counterFirstSequence; i++)
            {
                Console.Write((firstNumberPerSequence) + " ");
            }
        }
        else if (counterFirstSequence > 0 && counterFirstSequence < counterSecondSequence)
        {
            for (int i = 1; i <= counterSecondSequence; i++)
            {
                Console.Write((secondNumberPerSequence) + " ");
            }
        }
        else
        {
            Console.WriteLine(numbers[0]);
        }

    }
}