package PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] coordinates = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point bottomLeft = new Point(coordinates[0], coordinates[1]);
        Point topRight = new Point(coordinates[2], coordinates[3]);

        Rectangular rectangular = new Rectangular(bottomLeft, topRight);

        int pointCount = Integer.parseInt(reader.readLine());

        while (pointCount-- > 0) {
            int[] pointCoordinates = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point newPoint = new Point(pointCoordinates[0], pointCoordinates[1]);

            System.out.println(rectangular.contains(newPoint));
        }
    }
}
