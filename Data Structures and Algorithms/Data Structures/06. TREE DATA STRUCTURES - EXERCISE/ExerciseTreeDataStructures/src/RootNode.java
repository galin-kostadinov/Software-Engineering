import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RootNode {
    static Map<Integer, Tree<Integer>> treeMap = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfNodes = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfNodes - 1; i++) {
            int[] nodes = Arrays.stream(reader.readLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int parent = nodes[0];
            int child = nodes[1];

            treeMap.putIfAbsent(parent, new Tree<>(parent));
            treeMap.putIfAbsent(child, new Tree<>(child));

            Tree<Integer> parentNode = treeMap.get(parent);
            Tree<Integer> childNode = treeMap.get(child);

            parentNode.addChild(childNode);
            childNode.setParent(parentNode);
        }

        Tree<Integer> valueRootNode = treeMap.entrySet()
                .stream()
                .findFirst()
                .filter(x -> x.getValue().getParent() == null)
                .get()
                .getValue();

        int root = valueRootNode.getNodeValue();

        System.out.println(root);
    }
}

