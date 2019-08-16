package ListyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListyIterator {
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
        if (this.index < list.size()-1) {
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
}
