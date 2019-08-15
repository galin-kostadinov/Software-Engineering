package GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        while (count-- > 0) {
            String str = reader.readLine();
            Box<String> box = new Box<>(str);
            System.out.println(box.toString());
        }
    }
}
