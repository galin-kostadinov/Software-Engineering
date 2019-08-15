package ListUtilities;

import java.util.List;

public class  ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> elements) {
        checkSize(elements);

        T minElement = elements.get(0);

        for (T element : elements) {
            if (minElement.compareTo(element) > 0) {
                minElement = element;
            }
        }

        return minElement;
    }


    public static <T extends Comparable<T>> T getMax(List<T> elements) {
        checkSize(elements);

        T maxElement = elements.get(0);

        for (T element : elements) {
            if (maxElement.compareTo(element) < 0) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    private static <T extends Comparable<T>> void checkSize(List<T> elements) {
        if (elements == null || elements.size() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
