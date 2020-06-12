function pressHouse() {

    class Article {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        toString() {
            return `Title: ${this.title}\nContent: ${this.content}`;
        }
    }

    class ShortReports extends Article {
        constructor(title, content, originalResearches = {}) {
            if (content.length >= 150) {
                throw new Error("Short reports content should be less then 150 symbols.");
            }

            if (originalResearches.title === undefined  || originalResearches.author === undefined) {
                throw new Error("The original research should have author and title.");
            }

            super(title, content)
            this.originalResearches = originalResearches;
            this.comments = [];
        }

        addComment(comment) {
            this.comments.push(comment);
            return "The comment is added.";
        }

        toString() {
            let result = super.toString() + `\nOriginal Research: ${this.originalResearches.title} by ${this.originalResearches.author}`;

            if (this.comments.length > 0) {
                result += `\nComments:`;
            }

            for (let comment of this.comments) {
                result += `\n${comment}`;
            }

            return result;
        }
    }

    class BookReview extends Article {
        constructor(title, content, book) {
            super(title, content)
            this.book = book;
            this.clients = [];
        }

        addClient(clientName, orderDescription) {
            for (let client of this.clients) {
                if (client.clientName === clientName && client.orderDescription === orderDescription) {
                    throw new Error("This client has already ordered this review.");
                }
            }

            this.clients.push({ clientName: clientName, orderDescription: orderDescription });
            return `${clientName} has ordered a review for ${this.book.name}`;
        }

        toString() {
            let result = super.toString() + `\nBook: ${this.book.name}`;


            if (this.clients.length > 0) {
                result += `\nOrders:`;
            }

            for (let client of this.clients) {
                result += `\n${client.clientName} - ${client.orderDescription}`;
            }

            return result;
        }
    }

    return {
        Article,
        ShortReports,
        BookReview
    }
}

let classes = pressHouse();
// let lorem = new classes.Article("Lorem", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non tortor finibus, facilisis mauris vel…");
// console.log(lorem.toString()); 



// ShortReports -- The original research should have author and title. -- no author"

let content = 'Yes, its damn true.SpaceX in its recent launch Dragon 2 Flight has used a technology based on Chromium and Javascript.'



let longContent = 'Yes, its damn true.SpaceX in its recent launch Dragon 2 Flight has used a technology based on Chromium and Javascript. What are your views on this ?Yes, its damn true.SpaceX in its recent launch Dragon 2 Flight has used a technology based on Chromium and Javascript. What are your views on this ?'
let short = new classes.ShortReports("SpaceX and Javascript", content,  { title: 'Dragon 2' });
console.log(short.addComment("Thank god they didn't use java."))
short.addComment("In the end JavaScript`s features are executed in C++ — the underlying language.")
console.log(short.toString());

// let book = new classes.BookReview("The Great Gatsby is so much more than a love story", "The Great Gatsby is in many ways similar to Romeo and Juliet, yet I believe that it is so much more than just a love story. It is also a reflection on the hollowness of a life of leisure. ...", { name: "The Great Gatsby", author: "F Scott Fitzgerald" });
// console.log(book.addClient("The Guardian", "100 symbols"));
// console.log(book.addClient("Goodreads", "30 symbols"));
// console.log(book.toString()); 