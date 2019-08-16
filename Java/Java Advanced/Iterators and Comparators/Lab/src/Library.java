import java.util.Iterator;
import java.util.function.Consumer;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public void forEach() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private final class LibIterator implements Iterator<Book> {
        private int index;

        @Override
        public boolean hasNext() {
            return this.index < books.length;
        }

        @Override
        public Book next() {
            return books[this.index++];
        }
    }

//    @Override
//    public Iterator<Book> iterator() {
//        return new LibIterator1(this.books);
//    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    @Override
    public void forEach(Consumer<? super Book> action) {
        Iterator<Book> iterator = this.iterator();

        while (iterator.hasNext()){
            action.accept(iterator.next());
        }
    }
}
