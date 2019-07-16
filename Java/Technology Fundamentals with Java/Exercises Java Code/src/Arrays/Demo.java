package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] arrAsString = new String[arr.length];
        for (int i = 0; i < arrAsString.length; i++) {
            arrAsString[i] = arr[i] + "";
        }
        System.out.println(String.join(", ", arrAsString));
        


    }
}
