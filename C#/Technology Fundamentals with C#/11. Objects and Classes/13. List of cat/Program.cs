using System;
using System.Collections.Generic;

namespace _13._List_of_cat
{
    public class Cat
    {
        public string Name { get; set; }

        public int Age { get; set; }

        public string Color { get; set; }
    }

    public class Bunny
    {
        public Bunny(string name, string image)
        {
            //Validate name and image
            this.Name = name;
            this.Image = image;
        }

        public string Name { get; set; }

        public string Image { get; set; }

        public string SayHello()
        {
            return $"Hi. My name is {Name}. You can see me here : {Image}";
        }
    }

    public class Program
    {
        public static void Main()
        {
            var listOfCat = new List<Cat>();

            listOfCat.Add(new Cat
            {
                Name = "Ivan",
                Age = 5
            });

            listOfCat.Add(new Cat
            {
                Name = "Maria",
                Age = 6
            });

            listOfCat.Add(new Cat
            {
                Name = "Stefan",
                Age = 2
            });

            foreach (var currentCat in listOfCat)
            {
                Console.WriteLine(currentCat.Name);
            }


            var bunny = new Bunny("Bugs", "https://pbs.twimg.com/profile_images/447374371917922304/P4BzupWu.jpeg");

            Console.WriteLine(bunny.SayHello());
        }
    }
}
