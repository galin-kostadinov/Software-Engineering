import commands.*;
import commands.interfaces.Command;
import military.interfaces.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Command> commands = new HashMap<>();

        List<Soldier> soldiers = new ArrayList<>();

        commands.put("Private", new PrivateCommand(soldiers));
        commands.put("LieutenantGeneral", new LieutenantGeneralCommand(soldiers));
        commands.put("Engineer", new EngineerCommand(soldiers));
        commands.put("Commando", new CommandoCommand(soldiers));
        commands.put("Spy", new SpyCommand(soldiers));

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String command = input.substring(0, input.indexOf(" "));
            if (command.equals("LeutenantGeneral")) {
                command = "LieutenantGeneral";
            }
            commands.get(command).execute(
                    Arrays.stream(input.split("\\s+"))
                            .skip(1)
                            .collect(Collectors.toList()));
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }
    }
}
