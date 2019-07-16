package MethodExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NxNMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        printNxNMatrix(number);
    }

    private static void printNxNMatrix(int number) {
        for (int i = 0; i <number ; i++) {
            for (int j = 0; j <number ; j++) {
                System.out.print(number+" ");
            }
            System.out.println();
        }
    }


}
