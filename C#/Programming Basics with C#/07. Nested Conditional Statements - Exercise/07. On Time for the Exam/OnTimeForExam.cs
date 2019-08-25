using System;

class FishingBoat
{
    static void Main()
    {
        int examHour = int.Parse(Console.ReadLine());
        int examMinute = int.Parse(Console.ReadLine());
        int arrivalHour = int.Parse(Console.ReadLine());
        int arrivalMinute = int.Parse(Console.ReadLine());

        examMinute = examMinute + examHour * 60;
        arrivalMinute = arrivalMinute + arrivalHour * 60;
        int minuteLeft = 0;
        int hourLeft = 0;


        if (examMinute >= arrivalMinute && (examMinute - arrivalMinute) <= 30)
        {
            Console.WriteLine("On time");
        }
        else if ((examMinute - arrivalMinute) > 30)
        {
            Console.WriteLine("Early");
        }
        else if ((examMinute - arrivalMinute) < 0)
        {
            Console.WriteLine("Late");
        }


        if (examMinute > arrivalMinute && (examMinute - arrivalMinute) < 60)
        {
            Console.WriteLine($"{examMinute - arrivalMinute} minutes before the start");
        }
        else if ((examMinute - arrivalMinute) >= 60)
        {
            hourLeft = (examMinute - arrivalMinute) / 60;
            minuteLeft = (examMinute - arrivalMinute) % 60;
            if (minuteLeft <= 9)
            {
                Console.WriteLine($"{hourLeft}:0{minuteLeft} hours before the start");
            }
            else
            {
                Console.WriteLine($"{hourLeft}:{minuteLeft} hours before the start");
            }
        }

        if (examMinute < arrivalMinute && (arrivalMinute - examMinute) < 60)
        {
            Console.WriteLine($"{arrivalMinute - examMinute} minutes after the start");
        }
        else if ((arrivalMinute - examMinute) >= 60)
        {
            hourLeft = (arrivalMinute - examMinute) / 60;
            minuteLeft = (arrivalMinute - examMinute) % 60;
            if (minuteLeft <= 9)
            {
                Console.WriteLine($"{hourLeft}:0{minuteLeft} hours after the start");//{hourLeft}:{minuteLeft:D2} => 9->09
            }
            else
            {
                Console.WriteLine($"{hourLeft}:{minuteLeft} hours after the start");
            }
        }
    }
}