using System;
using System.Collections.Generic;
using System.Linq;

namespace _05._Students
{
    public class Student
    {
        public string FirstName { get; set; }

        public string LastName { get; set; }

        public int Age { get; set; }

        public string Hometown { get; set; }
    }

    public class Program
    {
        public static void Main()
        {
            var students = new List<Student>();

            while (true)
            {
                string input = Console.ReadLine();
                if (input == "end")
                {
                    break;
                }
                string[] tokens = input.Split();

                string firstName = tokens[0];
                string lastName = tokens[1];
                int age = int.Parse(tokens[2]);
                string hometown = tokens[3];

                var student = new Student();

                student.FirstName = firstName;
                student.LastName = lastName;
                student.Age = age;
                student.Hometown = hometown;
                students.Add(student);
            }
            string studetsToPrint = Console.ReadLine();

            var filtredStudents = students
                .Where(x => x.Hometown == studetsToPrint)
                .ToArray();

            foreach (var student in filtredStudents)
            {
                Console.WriteLine($"{student.FirstName} {student.LastName} is {student.Age} years old.");
            }
        }
    }
}
