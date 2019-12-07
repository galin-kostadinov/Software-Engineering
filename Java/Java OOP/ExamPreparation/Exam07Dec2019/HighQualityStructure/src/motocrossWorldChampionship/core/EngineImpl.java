package motocrossWorldChampionship.core;

import motocrossWorldChampionship.common.Command;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.io.interfaces.InputReader;
import motocrossWorldChampionship.io.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private ChampionshipController controller;
    private InputReader reader;
    private OutputWriter writer;

    public EngineImpl(ChampionshipController controller, InputReader reader, OutputWriter writer) {
        this.controller = controller;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.End.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            this.writer.writeLine(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case CreateRider:
                result = controller.createRider(data[0]);
                break;
            case CreateMotorcycle:
                result = controller.createMotorcycle(data[0], data[1], Integer.parseInt(data[2]));
                break;
            case AddMotorcycleToRider:
                result = controller.addMotorcycleToRider(data[0], data[1]);
                break;
            case AddRiderToRace:
                result = controller.addRiderToRace(data[0], data[1]);
                break;
            case CreateRace:
                result = controller.createRace(data[0], Integer.parseInt(data[1]));
                break;
            case StartRace:
                result = controller.startRace(data[0]);
                break;
            case End:
                result = "End";
                break;
        }

        return result;
    }
}
