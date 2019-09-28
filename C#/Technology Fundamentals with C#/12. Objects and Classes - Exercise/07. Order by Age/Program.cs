using System;
using System.Collections.Generic;
using System.Linq;

namespace OrderByAge
{
    public class People
    {
        public People(string name, string id, int age)
        {
            Name = name;
            Id = id;
            Age = age;
        }
        public string Name { get; set; }

        public string Id { get; set; }

        public int Age { get; set; }
    }

    public class Program
    {
        public static void Main()
        {
            List<People> people = new List<People>();

            while (true)
            {
                string input = Console.ReadLine();

                if (input == "End")
                {
                    break;
                }

                List<string> someMan = input.Split().ToList();

                string name = someMan[0];
                string id = someMan[1];
                int age = int.Parse(someMan[2]);

                People man = new People(name, id, age);
                people.Add(man);
            }

            people = people
                .OrderBy(x => x.Age)
                .ToList();

            foreach (var man in people)
            {
                Console.WriteLine($"{man.Name} with ID: {man.Id} is {man.Age} years old.");
            }
        }
    }
}
