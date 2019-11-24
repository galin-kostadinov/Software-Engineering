using System;
using System.Collections.Generic;
using System.Text;

namespace _01._Valid_Usernames
{
    class Program
    {
        static void Main()
        {
            string[] userNames = Console.ReadLine().Split(", ");
            List<string> legalUserNames = new List<string>();

            foreach (var userName in userNames)
            {
                if (userName.Length<3 || userName.Length>16)
                {
                    continue;
                }
                bool isNotLetter = false;
                foreach (var symbol in userName)
                {
                    if (!(symbol=='-' || symbol == '_' || char.IsLetter(symbol) || char.IsDigit(symbol)))
                    {
                        isNotLetter = true;
                        break;
                    }
                }
                if (isNotLetter)
                {
                    continue;
                }

                legalUserNames.Add(userName);
            }
            foreach (var userName in legalUserNames)
            {
                Console.WriteLine(userName);
            }
        }
    }
}
