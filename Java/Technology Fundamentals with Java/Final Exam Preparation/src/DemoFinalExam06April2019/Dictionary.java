package DemoFinalExam06April2019;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s*\\|\\s*".trim());

        Map<String, List<String>> wordsAndDefinitions = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            String[] token = input[i].split("\\s*:\\s*".trim());
            String word = token[0];
            String definition = token[1];

            if (!wordsAndDefinitions.containsKey(word)) {
                List<String> definitions = new ArrayList<>();
                definitions.add(definition);
                wordsAndDefinitions.put(word, definitions);
            } else {
                List<String> definitions = wordsAndDefinitions.get(word);
                definitions.add(definition);
            }
        }
        String[] wordAndDefToPrint = sc.nextLine().split("\\s*\\|\\s*".trim());
        for (int i = 0; i < wordAndDefToPrint.length; i++) {
            String currentWord = wordAndDefToPrint[i];
            if (wordsAndDefinitions.containsKey(currentWord)) {
                List<String> definitions = wordsAndDefinitions.get(currentWord);
                System.out.println(currentWord);
                definitions.stream()
                        .sorted((e1,e2)->Integer.compare(e2.length(),e1.length()))
                        .forEach(e-> System.out.printf(" -%s%n",e));
            }
        }
        String command = sc.nextLine();
        if(command.equals("List")){
            wordsAndDefinitions.keySet()
                    .stream()
                    .sorted((w1,w2)->w1.compareTo(w2))
                    .forEach(e-> System.out.printf("%s ",e));
            System.out.println();
        }
    }
}
