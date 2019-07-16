package BasicSyntax;

        import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNOddNumbers = Integer.parseInt(sc.nextLine());
        int sum = 0;
        int counter = 1;
        for (int i = 1; i <= 100 && counter<=firstNOddNumbers; i+=2) {
            System.out.println(i);
            sum+=i;
            counter++;
        }
        System.out.printf("Sum: %d%n",sum);
    }
}
