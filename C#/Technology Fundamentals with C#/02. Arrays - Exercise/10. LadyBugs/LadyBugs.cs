using System;
using System.Linq;

public class LadyBugs
{
    public static void Main()
    {
        int fieldSize = int.Parse(Console.ReadLine());
        int[] startBugsPositions = Console.ReadLine().Split().Select(int.Parse).ToArray();

        if (fieldSize > 0)
        {
            int[] ladyBugsPositions = new int[fieldSize];

            for (int i = 0; i < ladyBugsPositions.Length; i++)
            {
                for (int j = 0; j < startBugsPositions.Length; j++)
                {
                    if (startBugsPositions[j] == i)
                    {
                        ladyBugsPositions[i] = 1;
                    }
                }
            }

            while (true)
            {
                string input = Console.ReadLine();
                if (input == "end")
                {
                    break;
                }
                string[] ladyBugMove = input.Split().ToArray();
                int startLadyBugIndex = int.Parse(ladyBugMove[0]);

                if (startLadyBugIndex < 0 || startLadyBugIndex >= ladyBugsPositions.Length)
                {
                    continue;
                }

                if (ladyBugsPositions[startLadyBugIndex] == 0)
                {
                    continue;
                }

                string currentLadyBugDirection = ladyBugMove[1];
                int currentLadyBugFlyLength = int.Parse(ladyBugMove[2]);
                int endLadyBugIndex = 0;

                if (currentLadyBugDirection == "left")
                {
                    endLadyBugIndex = startLadyBugIndex - currentLadyBugFlyLength;
                    ladyBugsPositions[startLadyBugIndex] = 0;
                    if (endLadyBugIndex < 0 || endLadyBugIndex>= ladyBugsPositions.Length)
                    {                        
                        continue;
                    }
                    
                    while (endLadyBugIndex < ladyBugsPositions.Length && endLadyBugIndex >= 0)
                    {
                        if (ladyBugsPositions[endLadyBugIndex] == 1)
                        {
                            endLadyBugIndex -= currentLadyBugFlyLength;
                        }
                        else
                        {
                            break;
                        }
                    }
                    if (!(endLadyBugIndex < 0 || endLadyBugIndex >= ladyBugsPositions.Length))
                    {
                        ladyBugsPositions[endLadyBugIndex] = 1;
                    }
                }
                else if(currentLadyBugDirection == "right")
                {
                    endLadyBugIndex = startLadyBugIndex + currentLadyBugFlyLength;
                    ladyBugsPositions[startLadyBugIndex] = 0;

                    if (endLadyBugIndex < 0 || endLadyBugIndex >= ladyBugsPositions.Length)
                    {
                        continue;
                    }

                    while (endLadyBugIndex < ladyBugsPositions.Length && endLadyBugIndex >= 0)
                    {
                        if (ladyBugsPositions[endLadyBugIndex] == 1)
                        {
                            endLadyBugIndex += currentLadyBugFlyLength;
                        }
                        else
                        {
                            break;
                        }
                    }
                    if (!(endLadyBugIndex < 0 || endLadyBugIndex >= ladyBugsPositions.Length))
                    {
                        ladyBugsPositions[endLadyBugIndex] = 1;
                    }
                }           
            }

            Console.WriteLine(string.Join(" ", ladyBugsPositions));
        }
        else
        {
            while (true)
            {
                string input = Console.ReadLine();
                if (input == "end")
                {
                    break;
                }
            }
        }
    }
}