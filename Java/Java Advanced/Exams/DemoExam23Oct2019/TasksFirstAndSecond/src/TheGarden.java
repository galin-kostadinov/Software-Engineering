import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheGarden {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        char[][] garden = new char[rows][];

        for (int row = 0; row < rows; row++) {
            garden[row] = reader.readLine().replace(" ", "").toCharArray();
        }

        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmedVegetables = 0;

        String input;

        while (!"End of Harvest".equals(input = reader.readLine())) {
            String[] token = input.split("\\s++");

            String command = token[0];

            int row = Integer.parseInt(token[1]);
            int col = Integer.parseInt(token[2]);

            if (command.equals("Harvest")) {
                if (isInBound(garden, row, col)) {
                    switch (garden[row][col]) {
                        case 'C':
                            carrots++;
                            garden[row][col] = ' ';
                            break;
                        case 'L':
                            lettuce++;
                            garden[row][col] = ' ';
                            break;
                        case 'P':
                            potatoes++;
                            garden[row][col] = ' ';
                            break;
                        default:
                            break;
                    }
                }
            } else if (command.equals("Mole")) {
                String direction = token[3];

                switch (direction) {
                    case "up":
                        while (isInBound(garden, row, col)) {
                            if (garden[row][col] != ' ') {
                                garden[row][col] = ' ';
                                harmedVegetables++;
                            }
                            row -= 2;
                        }
                        break;
                    case "down":
                        while (isInBound(garden, row, col)) {
                            if (garden[row][col] != ' ') {
                                garden[row][col] = ' ';
                                harmedVegetables++;
                            }
                            row += 2;
                        }
                        break;
                    case "left":
                        while (isInBound(garden, row, col)) {
                            if (garden[row][col] != ' ') {
                                garden[row][col] = ' ';
                                harmedVegetables++;
                            }
                            col -= 2;
                        }

                        break;
                    case "right":
                        while (isInBound(garden, row, col)) {
                            if (garden[row][col] != ' ') {
                                garden[row][col] = ' ';
                                harmedVegetables++;
                            }
                            col += 2;
                        }
                        break;
                    default:
                        break;
                }

            }
        }

        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                System.out.print(garden[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmedVegetables);
    }

    private static boolean isInBound(char[][] garden, int row, int col) {
        return row < garden.length &&
                row >= 0 &&
                col < garden[row].length &&
                col >= 0;
    }
}
