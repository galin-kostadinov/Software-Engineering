using System;
using System.Collections.Generic;
using System.Linq;

namespace Articles
{
    public class Article
    {
        public Article(string title, string content, string author)
        {
            Title = title;
            Content = content;
            Author = author;
        }

        public string Title { get; set; }

        public string Content { get; set; }

        public string Author { get; set; }

        public void Edit(string newContent)
        {
            Content = newContent;
        }

        public void ChangeAuthor(string newAuthor)
        {
            Author = newAuthor;
        }

        public void Rename(string newTitle)
        {
            Title = newTitle;
        }

        public override string ToString()
        {
            return $"{Title} - {Content}: {Author}";
        }
    }

    public class Program
    {
        public static void Main()
        {
            string[] articleInput = Console.ReadLine().Split(", ").ToArray();
            string title = articleInput[0];
            string content = articleInput[1];
            string author = articleInput[2];

            Article article = new Article(title, content, author);

            int commandCount = int.Parse(Console.ReadLine());

            for (int i = 0; i < commandCount; i++)
            {
                string[] input = Console.ReadLine().Split(": ").ToArray();
                string command = input[0];
                string newText = input[1];
                if (command == "Edit")
                {
                    article.Edit(newText);
                }
                else if (command == "ChangeAuthor")
                {
                    article.ChangeAuthor(newText);
                }
                else if (command == "Rename")
                {
                    article.Rename(newText);
                }
            }

            Console.WriteLine(article.ToString());
        }
    }
}
