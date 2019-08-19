package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> elements;

    public Lake() {
        this.elements = new ArrayList<>();
    }

    public void setElements(List<Integer> elements) {
        this.elements.addAll(elements);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {
        private int indexEven = 0;
        private int indexOdd = 1;

        @Override
        public boolean hasNext() {
            if (indexEven < elements.size() || indexOdd < elements.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            int number;

            if (indexEven < elements.size()) {
                number = elements.get(indexEven);
                indexEven += 2;
            } else {
                number = elements.get(indexOdd);
                indexOdd += 2;
            }

            return number;
        }
    }
}
