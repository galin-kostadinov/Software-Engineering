package GenericCountMethodStrings;

public class Box<T> {

    private T element;

    public Box(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.element;
    }
}
