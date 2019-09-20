using System;
using System.Collections.Generic;
using System.Linq;

namespace _08._Vehicle_Catalogue
{
    public class Truck
    {
        public string Brand { get; set; }

        public string Model { get; set; }

        public int Weight { get; set; }
    }

    public class Car
    {
        public string Brand { get; set; }

        public string Model { get; set; }

        public int HoursePower { get; set; }
    }

    public class CatalogVehicle
    {
        public CatalogVehicle(List<Car> cars, List<Truck> truks)
        {
            this.Cars = cars;
            this.Trucks = truks;
        }
        public List<Car> Cars { get; set; }

        public List<Truck> Trucks { get; set; }
    }


    public class Program
    {
        public static void Main()
        {
            var catalog = new CatalogVehicle(new List<Car>(), new List<Truck>());


            while (true)
            {
                string input = Console.ReadLine();

                if (input == "end")
                {
                    break;
                }
                var tokens = input.Split("/").ToArray();

                string type = tokens[0];
                string brand = tokens[1];
                string model = tokens[2];
                int horsePowerOrWeight = int.Parse(tokens[3]);

                if (type == "Car")
                {
                    var car = new Car
                    {
                        Brand = brand,
                        Model = model,
                        HoursePower = horsePowerOrWeight
                    };

                    catalog.Cars.Add(car);
                }
                else if (type == "Truck")
                {
                    var truck = new Truck
                    {
                        Brand = brand,
                        Model = model,
                        Weight = horsePowerOrWeight
                    };

                    catalog.Trucks.Add(truck);
                }
            }

            var filtredCars = catalog
                .Cars
                .OrderBy(x => x.Brand)
                .ToList();
            var filtredTrucks = catalog
                .Trucks
                .OrderBy(x => x.Brand)
                .ToList();

            if (filtredCars.Count > 0)
            {
                Console.WriteLine("Cars:");
            }
            foreach (var car in filtredCars)
            {
                Console.WriteLine($"{car.Brand}: {car.Model} - {car.HoursePower}hp");
            }

            if (filtredTrucks.Count > 0)
            {
                Console.WriteLine("Trucks:");
            }
            foreach (var truck in filtredTrucks)
            {
                Console.WriteLine($"{truck.Brand}: {truck.Model} - {truck.Weight}kg");
            }
        }
    }
}
