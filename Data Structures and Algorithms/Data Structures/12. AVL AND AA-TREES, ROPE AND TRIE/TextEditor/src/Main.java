import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TextEditor editor = new TextEditorImpl();
        Map<String, Boolean> users = new LinkedHashMap<>();

        String line = "";

        while (!"end".equals(line = reader.readLine())) {
            String[] token = line.split("\\s+");
            String text = "";
            boolean readCommand = false;
            switch (token[0]) {
                case "login":
                    users.putIfAbsent(token[1], true);
                    editor.login(token[1]);
                    readCommand = true;
                    break;
                case "logout":
                    users.put(token[1], false);
                    editor.logout(token[1]);
                    readCommand = true;
                    break;
                case "users":
                    if (token.length == 2) {
                        for (String user : editor.users(token[1])) {
                            System.out.println(user);
                        }
                    } else {
                        for (var kvp : users.entrySet()) {
                            if (kvp.getValue()) {
                                System.out.println(kvp.getKey());
                            }
                        }
                    }
                    readCommand = true;
                    break;
                default:
                    break;
            }

            if (readCommand) {
                continue;
            }

            String username = token[0];

            if (!users.containsKey(username) || !users.get(username)) {
                continue;
            }

            switch (token[1]) {
                case "insert":
                    text = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
                    editor.insert(username, Integer.parseInt(token[2]), text);
                    break;
                case "prepend":
                    text = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
                    editor.prepend(username, text);
                    break;
                case "substring":
                    editor.substring(username, Integer.parseInt(token[2]), Integer.parseInt(token[3]));
                    break;
                case "delete":
                    editor.delete(username, Integer.parseInt(token[2]), Integer.parseInt(token[3]));
                    break;
                case "clear":
                    editor.clear(username);
                    break;
                case "length":
                    System.out.println(editor.length(username));
                    break;
                case "print":
                    System.out.println(editor.print(username));
                    break;
                case "undo":
                    editor.undo(username);
                    break;
                default:
                    break;
            }
        }
    }
}
