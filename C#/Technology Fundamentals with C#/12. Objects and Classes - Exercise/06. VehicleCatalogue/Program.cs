using System;
using System.Collections.Generic;
using System.Linq;

namespace VehicleCatalogue
{
    public class Program
    {
        public class Vehicle
        {
            public Vehicle(string typeOfVehicle, string model, string color, int horsepower)
            {
                TypeOfVehicle = typeOfVehicle;
                Model = model;
                Color = color;
                Horsepower = horsepower;
            }

            public string TypeOfVehicle { get; set; }

            public string Model { get; set; }

            public string Color { get; set; }

            public int Horsepower { get; set; }
        }

        public static void Main()
        {
            List<Vehicle> vehicles = new List<Vehicle>();

            while (true)
            {
                string input = Console.ReadLine();

                if (input == "End")
                {
                    break;
                }

                var someVehicle = input.Split().ToList();

                string typeOfVehicle = someVehicle[0];
                if (typeOfVehicle.ToLower()=="car")
                {
                    typeOfVehicle = "Car";
                }
                if (typeOfVehicle.ToLower() == "truck")
                {
                    typeOfVehicle = "Truck";
                }

                string model = someVehicle[1];
                string color = someVehicle[2];
                int horsepower = int.Parse(someVehicle[3]);

                Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsepower);
                vehicles.Add(vehicle);

            }

            while (true)
            {
                string input = Console.ReadLine();

                if (input == "Close the Catalogue")
                {
                    break;
                }
                var someVehicle = vehicles
                    .Where(x => x.Model == input)
                    .ToList();

                foreach (var vehicle in someVehicle)
                {
                    Console.WriteLine($"Type: {vehicle.TypeOfVehicle}");
                    Console.WriteLine($"Model: {vehicle.Model}");
                    Console.WriteLine($"Color: {vehicle.Color}");
                    Console.WriteLine($"Horsepower: {vehicle.Horsepower}");
                }
            }

            if (vehicles.Any(x=>x.TypeOfVehicle == "Car"))
            {
                double carAverageHorsepower = vehicles.Where(x => x.TypeOfVehicle == "Car").Average(x => x.Horsepower);
                Console.WriteLine($"Cars have average horsepower of: {carAverageHorsepower:F2}.");
            }
            else
            {
                Console.WriteLine($"Cars have average horsepower of: {0:F2}.");
            }
            if (vehicles.Any(x => x.TypeOfVehicle == "Truck"))
            {
                double truckAverageHorsepower = vehicles.Where(x => x.TypeOfVehicle == "Truck").Average(x => x.Horsepower);
                Console.WriteLine($"Trucks have average horsepower of: {truckAverageHorsepower:F2}.");
            }
            else
            {
                Console.WriteLine($"Trucks have average horsepower of: {0:F2}.");
            }
        }
    }
}
