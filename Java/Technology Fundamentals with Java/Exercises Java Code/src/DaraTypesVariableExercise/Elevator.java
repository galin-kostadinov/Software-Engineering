package DaraTypesVariableExercise;

        import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int peopleCount = Integer.parseInt(sc.nextLine());
        int elevatorCapacity = Integer.parseInt(sc.nextLine());

        int coursesNum =(int) Math.ceil(1.0*peopleCount/elevatorCapacity);

        System.out.println(coursesNum);
    }
}
