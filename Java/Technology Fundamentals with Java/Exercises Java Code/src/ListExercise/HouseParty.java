package ListExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int commandsCount = Integer.parseInt(sc.nextLine());

        List<String> people = new ArrayList<>(0);

        for (int i = 0; i < commandsCount; i++) {
            String[] command = sc.nextLine().split("\\s+");
            String name = command[0];
            if (command[2].equals("not")){
                int indexOfPerson = people.indexOf(name);
                if (indexOfPerson!=-1){
                    people.remove(indexOfPerson);
                }else{
                    System.out.printf("%s is not in the list!%n",name);
                }
            }else{
                int indexOfPerson = people.indexOf(name);
                if (indexOfPerson==-1){
                    people.add(name);
                }else{
                    System.out.printf("%s is already in the list!%n",name);
                }
            }
        }
        people.forEach(e-> System.out.println(e));
    }
}
