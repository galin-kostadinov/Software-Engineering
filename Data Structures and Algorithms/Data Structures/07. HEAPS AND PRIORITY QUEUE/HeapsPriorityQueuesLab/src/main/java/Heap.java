public class Heap<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void sort(T[] array) {
        constructionHeap(array);
        heapSort(array);
    }

    private static <T extends Comparable<T>> void heapSort(T[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapifyDown(array, 0, i);
        }
    }

    private static <T extends Comparable<T>> void constructionHeap(T[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            heapifyDown(array, i, array.length);
        }
    }

    private static <T extends Comparable<T>> void heapifyDown(T[] array, int index, int length) {
        int parentIndex = index;
        while (parentIndex < length / 2) {
            int childIndex = (parentIndex * 2) + 1;

            if (childIndex + 1 < length && isGreater(array, childIndex, childIndex + 1)) {
                childIndex += 1;
            }

            int compare = array[parentIndex].compareTo(array[childIndex]);
            if (compare < 0) {
                swap(array, childIndex, parentIndex);
            }
            parentIndex = childIndex;
        }
    }

    private static <T extends Comparable<T>> boolean isGreater(T[] heap, int left, int right) {
        return heap[left].compareTo(heap[right]) < 0;
    }

    private static <T extends Comparable<T>> void swap(T[] heap, int parentIndex, int childIndex) {
        T parent = heap[parentIndex];
        T child = heap[childIndex];

        heap[parentIndex] = child;
        heap[childIndex] = parent;
    }
}
