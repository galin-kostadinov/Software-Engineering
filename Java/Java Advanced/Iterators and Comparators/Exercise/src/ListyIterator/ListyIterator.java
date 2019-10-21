package ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index;

    public ListyIterator(List<String> list) {
        this.list = new ArrayList<>(list);
        this.index = 0;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.index++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        if (this.index < list.size() - 1) {
            return true;
        }

        return false;
    }

    public void print() throws IllegalAccessException {
        if (this.list != null && this.list.size() > 0) {
            if (index >= 0 && index < this.list.size()) {
                System.out.println(this.list.get(this.index));
            }
        } else {
            throw new IllegalAccessException("Invalid Operation!");
        }
    }

    public void printAll() {
        for (String element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        //First variant:
        // return this.list.iterator(); - default behavior

        //Second variant: If we want to create iterator with different behavior
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < list.size();
            }

            @Override
            public String next() {
                String element = list.get(this.index);
                this.index++;
                return element;
            }
        };
    }
}
