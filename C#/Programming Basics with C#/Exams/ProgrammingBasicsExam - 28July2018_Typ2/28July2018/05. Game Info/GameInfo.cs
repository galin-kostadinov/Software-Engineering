using System;

class GameInfo
{
    static void Main()
    {
        string team = Console.ReadLine();
        int meetingNum = int.Parse(Console.ReadLine());
        int totalMeetingDuration = 0;
        int penalties = 0;
        int additionalTime = 0;

        for (int i = 0; i < meetingNum; i++)
        {
            int meetingDuration = int.Parse(Console.ReadLine());
            totalMeetingDuration += meetingDuration;

            if (meetingDuration > 120)
            {
                penalties++;
            }
            else if (meetingDuration > 90)
            {
                additionalTime++;
            }
        }

        double averageMeetingTime = 1.0 * totalMeetingDuration / meetingNum;
        Console.WriteLine($"{team} has played {totalMeetingDuration} minutes. Average minutes per game: {averageMeetingTime:F2}");
        Console.WriteLine($"Games with penalties: {penalties}");
        Console.WriteLine($"Games with additional time: {additionalTime}");
    }
}