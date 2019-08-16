import java.util.Iterator;

public class LibIterator1 implements Iterator<Book> {
    private Book[] data;
    private int index;

    public LibIterator1(Book[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.data.length;
    }

    @Override
    public Book next() {
        return this.data[this.index++];
    }
}
