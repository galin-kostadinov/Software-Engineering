using System;
using System.Linq;
using System.Collections.Generic;

namespace _06._Match_Full_Name
{
    class Program
    {
        static void Main()
        {
            string[] names = Console.ReadLine().Replace(", ", ",").Replace(" ,", ",").Replace("\b", "").Split(",");

            List<string> vallidFullName = new List<string>();

            for (int i = 0; i < names.Length; i++)
            {
                string[] splitedNames = names[i].Split(' ');

                if (splitedNames.Length != 2)
                {
                    continue;
                }

                if (char.IsLower(splitedNames[0][0]) || char.IsLower(splitedNames[1][0]))
                {
                    continue;
                }

                bool isUpperCase = false;
                foreach (string name in splitedNames)
                {
                    for (int j = 1; j < name.Length; j++)
                    {
                        if (char.IsUpper(name[j]))
                        {
                            isUpperCase = true;
                            break;
                        }
                    }
                    if (isUpperCase)
                    {
                        break;
                    }
                }
                if (isUpperCase)
                {
                    continue;
                }
                if (splitedNames[0].Length < 2 || splitedNames[1].Length < 2)
                {
                    continue;
                }

                vallidFullName.Add(names[i]);
            }

            Console.WriteLine(string.Join(" ", vallidFullName));
        }
    }
}
