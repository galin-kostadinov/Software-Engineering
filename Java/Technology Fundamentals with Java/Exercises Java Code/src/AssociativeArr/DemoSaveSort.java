package AssociativeArr;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoSaveSort {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<>();

        LinkedHashMap<String, Integer> result = keyMaterials
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> {
                            throw new AssertionError();},
                            LinkedHashMap::new
                ));

        //////

        LinkedHashMap<String, Integer> secondResult = new LinkedHashMap<>();

        keyMaterials
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(e->secondResult.put(e.getKey(),e.getValue()));

        keyMaterials = secondResult;
    }
}
