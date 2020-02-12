public class QuickSort {
    static void quickSort(int arr[], int left, int right) {
        int i = left, j = right;

        int tmp;

        int pivot = arr[(left + right) / 2];

        /* partition */
        while (i <= j) {
            while (arr[i] < pivot) i++;

            while (arr[j] > pivot) j--;

            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        /* recursion */
        if (left < j) {
            quickSort(arr, left, j);
        }

        if (i < right) {
            quickSort(arr, i, right);
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 6, 3, 7, 6};
        quickSort(arr, 0, 5);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
