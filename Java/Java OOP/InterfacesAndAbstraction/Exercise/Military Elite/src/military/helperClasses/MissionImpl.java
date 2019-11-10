package military.helperClasses;

import military.enums.State;
import military.helperClasses.interfaces.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.state = State.finished;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.getCodeName(), this.getState());
    }
}
