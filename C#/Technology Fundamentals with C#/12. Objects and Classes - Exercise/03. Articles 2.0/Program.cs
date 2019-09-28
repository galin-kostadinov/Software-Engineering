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

        public override string ToString()
        {
            return $"{Title} - {Content}: {Author}";
        }
    }

    public class Program
    {
        public static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            List<Article> articles = new List<Article>();

            for (int i = 0; i < n; i++)
            {
                string[] articleInput = Console.ReadLine().Split(", ").ToArray();
                string title = articleInput[0];
                string content = articleInput[1];
                string author = articleInput[2];

                Article article = new Article(title, content, author);
                articles.Add(article);
            }

            string arrangeType = Console.ReadLine();

            if (arrangeType == "title")
            {
                articles = articles
                    .OrderBy(x => x.Title)
                    .ToList();
            }
            else if (arrangeType == "content")
            {
                articles = articles
                    .OrderBy(x => x.Content)
                    .ToList();
            }
            else if (arrangeType == "author")
            {
                articles = articles
                    .OrderBy(x => x.Author)
                    .ToList();
            }

            Print(articles);
        }

        private static void Print(List<Article> articles)
        {
            foreach (var article in articles)
            {
                Console.WriteLine(article.ToString());
            }
        }
    }
}
