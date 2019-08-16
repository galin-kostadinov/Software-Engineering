package GenericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Box<String>> boxes = new ArrayList<>();

        int count = Integer.parseInt(reader.readLine());

        while (count-- > 0) {
            Box<String> element = new Box<>(reader.readLine());
            boxes.add(element);
        }

        String[] indexesToSwap = reader.readLine().split("\\s+");

        int firstIndex = Integer.parseInt(indexesToSwap[0]);
        int secondIndex = Integer.parseInt(indexesToSwap[1]);

        swapElements(boxes, firstIndex, secondIndex);

        for (Box<String> box : boxes) {
            System.out.println(box.toString());
        }
    }

    private static <T> void swapElements(List<Box<T>> boxes, int firstIndex, int secondIndex) {
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
    }
}