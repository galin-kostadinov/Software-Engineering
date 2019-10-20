import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int wavesCount = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> trojanWarriors = new ArrayDeque<>();
        ArrayDeque<Integer> spartanPlates = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s++"))
                .forEach(p -> spartanPlates.offer(Integer.parseInt(p)));

        boolean allPlatesAreBroken = false;
        for (int i = 1; i <= wavesCount; i++) {
            Arrays.stream(reader.readLine().split("\\s++"))
                    .forEach(w -> trojanWarriors.push(Integer.parseInt(w)));

            if (i % 3 == 0) {
                int newPlate = Integer.parseInt(reader.readLine());
                spartanPlates.offer(newPlate);
            }

            while (!trojanWarriors.isEmpty() && !allPlatesAreBroken) {
                if (!spartanPlates.isEmpty()) {
                    int firstPlate = spartanPlates.poll();
                    int lastWarrior = trojanWarriors.pop();

                    int result = firstPlate - lastWarrior;
                    if (result > 0) {
                        spartanPlates.push(result);
                    } else if (result < 0) {
                        trojanWarriors.push(-result);
                    }
                } else {
                    allPlatesAreBroken = true;
                }
            }

            if (allPlatesAreBroken) {
                break;
            }
        }

        if (allPlatesAreBroken) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.print("Warriors left: ");
            System.out.println(String.join(", ",
                    trojanWarriors.toString().replace("[", "").replace("]", "")));
        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.print("Plates left: ");
            System.out.println(String.join(", ",
                    spartanPlates.toString().replace("[", "").replace("]", "")));
        }
    }
}
