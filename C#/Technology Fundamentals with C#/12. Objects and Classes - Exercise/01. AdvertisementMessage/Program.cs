using System;
using System.Collections.Generic;
using System.Linq;

namespace AdvertisementMessage
{
    class Program
    {
        static void Main()
        {
            Random random = new Random();

            List<string> phrases = new List<string>
            {
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."
            };

            List<string> events = new List<string>
            {
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
            };

            List<string> authors = new List<string>
                {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

            List<string> cities = new List<string>
                {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                var randomPhase = random.Next(0, phrases.Count);
                var randomEvent = random.Next(0, events.Count);
                var randomAutor = random.Next(0, authors.Count);
                var randomCities = random.Next(0, cities.Count);

                Console.WriteLine($"{phrases[randomPhase]} {events[randomEvent]} {authors[randomAutor]} – {cities[randomCities]}.");
            }
        }
    }
}
