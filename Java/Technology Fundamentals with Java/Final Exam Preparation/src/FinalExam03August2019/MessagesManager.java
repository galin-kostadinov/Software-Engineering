package FinalExam03August2019;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacity = Integer.parseInt(sc.nextLine());

        Map<String, Integer> usersReceivedMessengers = new LinkedHashMap<>();
        Map<String, Integer> usersSendMessengers = new LinkedHashMap<>();

        String input = "";
        while (!"Statistics".equals(input = sc.nextLine())) {
            String[] token = input.split("=".trim());
            String command = token[0];

            if (command.equals("Add")) {
                String username = token[1];
                //"Add={username}={sent}={received}":
                int sentCount = Integer.parseInt(token[2]);
                int receivedCount = Integer.parseInt(token[3]);

                if (!usersReceivedMessengers.containsKey(username)) {
                    usersReceivedMessengers.put(username, receivedCount);
                }

                if (!usersSendMessengers.containsKey(username)) {
                    usersSendMessengers.put(username, sentCount);
                }
            } else if (command.equals("Message")) {
                //"Message={sender}={receiver}":
                String sender = token[1];
                String receiver = token[2];

                if (usersSendMessengers.containsKey(sender) && usersReceivedMessengers.containsKey(receiver)) {
                    usersSendMessengers.put(sender, usersSendMessengers.get(sender) + 1);
                    usersReceivedMessengers.put(receiver, usersReceivedMessengers.get(receiver) + 1);

                    if ((usersSendMessengers.get(sender) + usersReceivedMessengers.get(sender)) == capacity) {
                        usersSendMessengers.remove(sender);

                        if (usersReceivedMessengers.containsKey(sender)) {
                            usersReceivedMessengers.remove(sender);
                        }
                        System.out.printf("%s reached the capacity!%n", sender);
                    }

                    if ((usersSendMessengers.get(receiver) + usersReceivedMessengers.get(receiver)) == capacity) {
                        usersReceivedMessengers.remove(receiver);
                        usersSendMessengers.remove(receiver);

                        if (usersSendMessengers.containsKey(receiver)) {
                            usersSendMessengers.remove(receiver);
                        }

                        System.out.printf("%s reached the capacity!%n", receiver);
                    }
                }
            } else if (command.equals("Empty")) {
                String username = token[1];
                if (username.equals("All")){
                    usersReceivedMessengers.clear();
                    usersSendMessengers.clear();
                    continue;
                }

                if (usersReceivedMessengers.containsKey(username)) {
                    usersReceivedMessengers.remove(username);
                }

                if (usersSendMessengers.containsKey(username)) {
                    usersSendMessengers.remove(username);
                }
            }
        }

        int usersCount = usersReceivedMessengers.size();
        System.out.printf("Users count: %d%n", usersCount);

        usersReceivedMessengers.entrySet()
                .stream()
                .sorted((u1, u2) -> {
                    int sort = Integer.compare(u2.getValue(), u1.getValue());
                    if (sort == 0) {
                        sort = u1.getKey().compareTo(u2.getKey());
                    }
                    return sort;
                })
                .forEach(u -> {
                    String username = u.getKey();
                    int messagesCount = u.getValue() + usersSendMessengers.get(username);
                    System.out.printf("%s - %d%n", username, messagesCount);
                });

    }
}
