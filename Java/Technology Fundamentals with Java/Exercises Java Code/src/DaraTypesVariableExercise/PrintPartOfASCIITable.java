package DaraTypesVariableExercise;

        import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startIndex = Integer.parseInt(sc.nextLine());
        int endIndex = Integer.parseInt(sc.nextLine());

        for (int i = startIndex; i <= endIndex; i++) {
            char charOnIndex = (char)i;
            System.out.print(charOnIndex+ " ");
        }
        System.out.println();
    }
}
