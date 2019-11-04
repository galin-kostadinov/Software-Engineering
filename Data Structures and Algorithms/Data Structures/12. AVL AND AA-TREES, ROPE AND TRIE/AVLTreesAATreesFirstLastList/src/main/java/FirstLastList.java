import java.util.*;
import java.util.stream.Collectors;

public class FirstLastList<T extends Comparable<T>> implements IFirstLastList<T> {
    private ArrayList<T> elements;

    public FirstLastList() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public int getCount() {
        return this.elements.size();
    }

    @Override
    public Iterable<T> first(int count) {
        if (!countIsInBound(count)) {
            throw new IllegalArgumentException();
        }

        return this.iterateFromFirstToLast(this.elements, count);
    }

    @Override
    public Iterable<T> last(int count) {
        if (!countIsInBound(count)) {
            throw new IllegalArgumentException();
        }

        return this.iterateFromLastToFirst(this.elements, count);
    }

    @Override
    public Iterable<T> min(int count) {
        if (!countIsInBound(count)) {
            throw new IllegalArgumentException();
        }

        return this.elements
                .stream()
                .sorted()
                .limit(count)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Iterable<T> max(int count) {
        if (!countIsInBound(count)) {
            throw new IllegalArgumentException();
        }

        return this.elements
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(count)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public int removeAll(T element) {
        int countOfRemovedElement = 0;

        for (int i = 0; i < this.elements.size(); ) {
            if (this.elements.get(i).compareTo(element) == 0) {
                this.elements.remove(i);
                countOfRemovedElement++;
                continue;
            }

            i++;
        }

        return countOfRemovedElement;
    }

    private boolean countIsInBound(int count) {
        return count >= 0 && count <= this.elements.size();
    }

    private Iterable<T> iterateFromLastToFirst(ArrayList<T> list, int count) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private int index = list.size() - 1;
                    private int leftIndex = index - count;

                    @Override
                    public boolean hasNext() {
                        return this.index > leftIndex;
                    }

                    @Override
                    public T next() {
                        T element = list.get(index);
                        this.index--;
                        return element;
                    }
                };
            }
        };
    }

    private Iterable<T> iterateFromFirstToLast(ArrayList<T> list, int count) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private int index = 0;

                    @Override
                    public boolean hasNext() {
                        return this.index < count;
                    }

                    @Override
                    public T next() {
                        T element = list.get(index);
                        this.index++;
                        return element;
                    }
                };
            }
        };
    }
}