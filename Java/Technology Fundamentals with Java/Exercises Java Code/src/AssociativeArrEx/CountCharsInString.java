package AssociativeArrEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharsInString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = String.join("", reader.readLine().split("\\s+"));

        LinkedHashMap<Character, Integer> countChars = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (!countChars.containsKey(symbol)) {
                countChars.put(symbol, 1);
            } else {
                countChars.put(symbol, countChars.get(symbol) + 1);
            }
        }

        countChars.forEach((key, value) -> System.out.println(
                String.format("%c -> %d", key, value)
        ));

//        countChars.entrySet().forEach(e->{
//            System.out.println(
//                    String.format("%c -> %d",e.getKey(),e.getValue())
//            );
//        });



//        for (Map.Entry<Character, Integer> count : countChars.entrySet()) {
//            System.out.println(String.format("%c -> %d", count.getKey(), count.getValue()));
//        }

    }
}
