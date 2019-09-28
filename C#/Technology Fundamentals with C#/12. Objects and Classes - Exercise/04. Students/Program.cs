using System;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Students
{
    public class Student
    {
        public Student(string firstName, string lastName, double grade)
        {
            FirstName = firstName;
            LastName = lastName;
            Grade = grade;
        }

        public string FirstName { get; set; }

        public string LastName { get; set; }

        public double Grade { get; set; }        
    }

    public class Program
    {
        public static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            List<Student> students = new List<Student>();

            for (int i = 0; i < n; i++)
            {
                string[] currentStudent = Console.ReadLine().Split(' ').ToArray();
                string firstName = currentStudent[0];
                string lastName = currentStudent[1];
                double grade = double.Parse(currentStudent[2]);

                Student student = new Student(firstName, lastName, grade);
                students.Add(student);
            }

            students = students
                .OrderByDescending(x => x.Grade)
                .ToList();

            Console.WriteLine(string.Join(Environment.NewLine, students.Select(x=> $"{x.FirstName} {x.LastName}: {x.Grade:F2}")));         
        }       
    }
}
