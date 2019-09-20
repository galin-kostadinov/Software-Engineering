using System;

namespace Demo

{
    public class Dog
    {
        public string Name { get; set; }

        public int Age { get; set; }

        public string Color { get; set; }
    }

    public class Horse
    {
        public string Name { get; set; }

        public int Age { get; set; }

        public bool IsSleeping { get; set; }

        public void GoToSleep()
        {
            if (!IsSleeping)
            {
                IsSleeping = true;
            }
        }

        public void WakeUp()
        {
            if (IsSleeping)
            {
                IsSleeping = false;
            }
        }

        public string SayHello()
        {
            return $"Hello. I am a horse. My name is: {Name} and I am {Age} years old.";
        }

        public void GrowOlder()
        {
            Age++;
            if (Age > 25)
            {
                //Remove cat from the field
            }
        }
    }



    public class Program
    {
        public static void Main()
        {
            var firsCat = new
            {
                Name = "Pesho",
                Age = 6,
                Color = "Black"
            };

            var secondCat = new//Read-only, only get;
            {
                Name = "Pesho",
                Age = 6,
                Color = "Black"
            };
            int fisthCatAge = firsCat.Age;

            var firstDog = new Dog // instance
            {
                Name = "Ivan",
                Age = 15,
                Color = "Brown"
            };

            firstDog.Age = 16;

            var secondDog = new Dog();
            secondDog.Color = "Black";



            var firstHorse = new Horse
            {
                Name = "Ivan",
                Age = 5
            };

            firstHorse.GoToSleep();
            Console.WriteLine(firstHorse.IsSleeping);

            firstHorse.WakeUp();
            Console.WriteLine(firstHorse.IsSleeping);

            var greeting = firstHorse.SayHello();
            Console.WriteLine(greeting);

            firstHorse.GrowOlder();



        }
    }
}
