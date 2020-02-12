public class BubbleSort {
    static void bubbleSort(int arr[]) {
        boolean swap = true;
        int temp;

        while (swap) {
            swap = false;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 6, 3, 7, 6};
        bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
