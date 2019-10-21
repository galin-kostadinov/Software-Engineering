import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SpaceshipCrafting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> chemicalLiquids = new ArrayDeque<>();
        ArrayDeque<Integer> physicalItems = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s++")).forEach(l -> chemicalLiquids.offer(Integer.parseInt(l)));
        Arrays.stream(reader.readLine().split("\\s++")).forEach(l -> physicalItems.push(Integer.parseInt(l)));

        int glass = 0;
        int aluminium = 0;
        int lithium = 0;
        int carbonFiber = 0;

        while (!chemicalLiquids.isEmpty() && !physicalItems.isEmpty()) {
            int liquid = chemicalLiquids.poll();
            int item = physicalItems.pop();

            int result = liquid + item;

            switch (result) {
                case 25:
                    glass++;
                    break;
                case 50:
                    aluminium++;
                    break;
                case 75:
                    lithium++;
                    break;
                case 100:
                    carbonFiber++;
                    break;
                default:
                    physicalItems.push(item + 3);
                    break;
            }
        }

        if (glass > 0 && aluminium > 0 && lithium > 0 && carbonFiber > 0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if (chemicalLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(String.join(", ",
                    chemicalLiquids.toString().replace("[", "").replace("]", "")));
        }

        if (physicalItems.isEmpty()) {
            System.out.println("Physical items left: none");
        } else {
            System.out.print("Physical items left: ");
            System.out.println(String.join(", ",
                    physicalItems.toString().replace("[", "").replace("]", "")));
        }

        System.out.println("Aluminium: " + aluminium);
        System.out.println("Carbon fiber: " + carbonFiber);
        System.out.println("Glass: " + glass);
        System.out.println("Lithium: " + lithium);
    }
}

