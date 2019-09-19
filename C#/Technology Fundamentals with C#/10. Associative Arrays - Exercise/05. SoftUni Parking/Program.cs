using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        var carsRegister = new Dictionary<string, string>();

        for (int i = 0; i < n; i++)
        {
            List<string> registration = Console.ReadLine()
                .Split()
                .ToList();

            string command = registration[0];
            string username = registration[1];


            if (command == "register")
            {
                string licensePlateNumber = registration[2];
                if (!carsRegister.ContainsKey(username))
                {
                    carsRegister[username] = licensePlateNumber;
                    Console.WriteLine($"{username} registered {licensePlateNumber} successfully");
                }
                else
                {
                    Console.WriteLine($"ERROR: already registered with plate number {licensePlateNumber}");
                }
            }
            if (command == "unregister")
            {
                if (carsRegister.ContainsKey(username))
                {
                    carsRegister.Remove(username);
                    Console.WriteLine($"{username} unregistered successfully");
                }
                else
                {
                    Console.WriteLine($"ERROR: user {username} not found");
                }
            }
        }

        foreach (var kvp in carsRegister)
        {
            string username = kvp.Key;
            string licensePlateNumber = kvp.Value;
            Console.WriteLine($"{username} => {licensePlateNumber}");
        }
    }
}