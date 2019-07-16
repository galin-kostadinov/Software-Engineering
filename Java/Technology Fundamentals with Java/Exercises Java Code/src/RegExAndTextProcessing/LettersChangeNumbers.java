package RegExAndTextProcessing;

        import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+".trim());
        double totalSum = 0.0;

        for (int i = 0; i < input.length; i++)
        {
            String currentInput = input[i];
            int numberLength = currentInput.length() - 2;
            double number = Double.parseDouble(currentInput.substring(1, numberLength+1));

            char firstLetter = currentInput.charAt(0);
            char lastLetter = currentInput.charAt(currentInput.length() - 1);

            double result = 0;

            if (Character.isUpperCase(firstLetter))
            {
                int letterPosition = firstLetter - 'A' + 1;
                result = 1.0 * number / letterPosition;
            }
            else
            {
                int letterPosition = firstLetter - 'a' + 1;
                result = number * letterPosition;
            }

            if (Character.isLowerCase(lastLetter))
            {
                int letterPosition = lastLetter - 'a' + 1;
                totalSum += result + letterPosition;
            }
            else
            {
                int letterPosition = lastLetter - 'A' + 1;
                totalSum += result - letterPosition;
            }
        }
        System.out.printf("%.2f%n",totalSum);
    }
}
