package MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int playerRow = 7;
        int playerCol = 7;

        int playerHp = 18500;
        double heiganHp = 3000000d;

        double playerDamage = Double.parseDouble(sc.nextLine());
        String lastSpell = "";
        while (true) {
            if (playerHp >= 0) {
                heiganHp -= playerDamage;
            }
            if (lastSpell.equals("Cloud")) {
                playerHp -= 3500;
            }
            if (heiganHp <= 0 || playerHp <= 0) {
                break;
            }

            String[] input = sc.nextLine().split("\\s+");
            String currentSpell = input[0];
            int targetRow = Integer.parseInt(input[1]);
            int targetCol = Integer.parseInt(input[2]);

            if (isInDamageArea(targetRow, targetCol, playerRow, playerCol)) {
                if (!isInDamageArea(targetRow, targetCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)) {
                    playerCol++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                } else {
                    if (currentSpell.equals("Cloud")) {
                        playerHp -= 3500;
                        lastSpell = "Cloud";
                    } else if (currentSpell.equals("Eruption")) {
                        playerHp -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }

        if (lastSpell.equals("Cloud")) {
            lastSpell = "Plague Cloud";
        } else {
            lastSpell = "Eruption";
        }

        String heiganState = "";
        if (heiganHp <= 0) {
            heiganState = "Heigan: Defeated!";
        } else {
            heiganState = String.format("Heigan: %.2f", heiganHp);
        }

        String playerState = "";
        if (playerHp <= 0) {
            playerState = String.format("Player: Killed by %s", lastSpell);
        } else {
            playerState = String.format("Player: %d", playerHp);
        }

        String playerEndCoordinates = String.format("Final position: %d, %d", playerRow, playerCol);
        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);
    }

    private static boolean isWall(int moveCell) {
        return moveCell < 0 || moveCell >= 15;
    }

    private static boolean isInDamageArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }
}
