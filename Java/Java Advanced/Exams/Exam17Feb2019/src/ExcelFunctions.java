import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ExcelFunctions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        List<String> allHeaders = Arrays.stream(reader.readLine().split("\\s*,\\s++"))
                .collect(Collectors.toList());

        List<List<String>> data = new ArrayList<>();

        for (int i = 0; i < rows - 1; i++) {
            List<String> row = Arrays.stream(reader.readLine().split("\\s*,\\s++"))
                    .collect(Collectors.toList());
            data.add(row);
        }

        String[] token = reader.readLine().split("\\s++");
        String command = token[0];
        String header = token[1];

        if (command.equals("hide")) {
            hide(data, allHeaders, header);
            printHeader(allHeaders);
            print(data);
        } else if (command.equals("sort")) {
            sort(data, allHeaders, header);
            printHeader(allHeaders);
            print(data);
        } else if (command.equals("filter")) {
            String value = token[2];

            List<List<String>> filteredData = filterRows(data, allHeaders, header, value);

            printHeader(allHeaders);

            if (filteredData != null) {
                print(filteredData);
            }
        }
    }

    private static void printHeader(List<String> allHeaders) {
        System.out.println(String.join(" | ", allHeaders));
    }

    private static void print(List<List<String>> data) {
        for (int row = 0; row < data.size(); row++) {
            System.out.println(String.join(" | ", data.get(row)));
        }
    }

    private static List<List<String>> filterRows(List<List<String>> data, List<String> allHeaders, String header, String value) {
        int indexOfHeader = allHeaders.indexOf(header);
        List<List<String>> filterRows = new ArrayList<>();

        if (indexOfHeader >= 0) {
            for (int row = 0; row < data.size(); row++) {
                if (data.get(row).get(indexOfHeader).equals(value)) {
                    filterRows.add(data.get(row));
                }
            }
        }

        return filterRows;
    }


    private static void sort(List<List<String>> data, List<String> allHeaders, String header) {
        int indexOfHeader = allHeaders.indexOf(header);
        if (indexOfHeader >= 0) {
            Map<String, List<String>> result = new TreeMap<>();
            for (int r = 0; r < data.size(); r++) {
                result.put(data.get(r).get(indexOfHeader), data.get(r));
            }

            int row = 0;
            for (List<String> value : result.values()) {
                data.set(row++, value);
            }
        }
    }

    private static void hide(List<List<String>> data, List<String> allHeaders, String header) {
        int col = allHeaders.indexOf(header);
        if (col >= 0) {
            allHeaders.remove(col);
            for (int r = 0; r < data.size(); r++) {
                data.get(r).remove(col);
            }
        }
    }
}
