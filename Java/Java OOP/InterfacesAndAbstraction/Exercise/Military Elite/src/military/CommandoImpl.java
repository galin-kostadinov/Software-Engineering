package military;

import military.enums.Corps;
import military.enums.State;
import military.helperClasses.interfaces.Mission;
import military.interfaces.Commando;

import java.util.Collection;
import java.util.LinkedHashSet;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());

        for (Mission mission : this.missions) {
            if (!mission.getState().equals(State.finished)) {
                sb.append("  ")
                        .append(mission)
                        .append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
