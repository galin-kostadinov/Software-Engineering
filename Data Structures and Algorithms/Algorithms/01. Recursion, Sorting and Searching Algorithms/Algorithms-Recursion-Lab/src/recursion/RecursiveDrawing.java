package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveDrawing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int index = Integer.parseInt(reader.readLine());

        print(index);
    }

    private static void print(int index) {
        if (index == 0) {
            return;
        }

        for (int i = 0; i < index; i++) {
            System.out.print("*");
        }
        System.out.println();

        print(index - 1);

        for (int i = index; i > 0; i--) {
            System.out.print("#");
        }
        System.out.println();
    }
}
