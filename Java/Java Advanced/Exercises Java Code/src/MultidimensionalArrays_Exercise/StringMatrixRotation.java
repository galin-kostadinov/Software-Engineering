package MultidimensionalArrays_Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[A-Z][a-z]+\\((?<deg>\\d+)\\)");
        Matcher matcher = pattern.matcher(sc.nextLine());

        int deg = 0;
        if (matcher.find()) {
            deg = Integer.parseInt(matcher.group("deg"));
        }

        deg %= 360;

        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        String rowInput;
        while (!"END".equalsIgnoreCase(rowInput = sc.nextLine())) {
            ArrayList<Character> rowMatrix = new ArrayList<>();
            for (int col = 0; col < rowInput.length(); col++) {
                rowMatrix.add(rowInput.charAt(col));
            }
            matrix.add(rowMatrix);
        }

        addSpaces(matrix);

        if (deg == 90) {
            matrix = rotate90Or270Deg(matrix, deg);
        } else if (deg == 180) {
            Collections.reverse(matrix);
            for (int row = 0; row < matrix.size(); row++) {
                Collections.reverse(matrix.get(row));
            }
        } else if (deg == 270) {
            matrix = rotate90Or270Deg(matrix, deg);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<ArrayList<Character>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                char symbol = matrix.get(row).get(col);
                System.out.print(symbol);
            }

            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Character>> rotate90Or270Deg(ArrayList<ArrayList<Character>> matrix, int deg) {
        if (deg == 90) {
            Collections.reverse(matrix);
        }

        ArrayList<ArrayList<Character>> rotatedMatrix = new ArrayList<>();

        for (int col = 0; col < matrix.get(0).size(); col++) {
            ArrayList<Character> rowRotatedMatrix = new ArrayList<>();
            for (int row = 0; row < matrix.size(); row++) {
                char symbol = matrix.get(row).get(col);
                rowRotatedMatrix.add(symbol);
            }
            rotatedMatrix.add(rowRotatedMatrix);
        }

        if (deg == 270) {
            Collections.reverse(rotatedMatrix);
        }

        return rotatedMatrix;
    }

    private static void addSpaces(ArrayList<ArrayList<Character>> matrix) {
        int maxLength = 0;
        for (int row = 0; row < matrix.size(); row++) {
            if (matrix.get(row).size() > maxLength) {
                maxLength = matrix.get(row).size();
            }
        }

        for (int row = 0; row < matrix.size(); row++) {
            while (matrix.get(row).size() < maxLength) {
                matrix.get(row).add(' ');
            }
        }
    }
}
