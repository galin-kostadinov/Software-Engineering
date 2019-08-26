package commands.interfaces;

import military.interfaces.Soldier;

import java.util.List;

public interface Command {
    void execute(List<String> args);

    List<Soldier> getSoldiers();
}
