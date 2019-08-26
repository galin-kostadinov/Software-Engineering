package military.helperClasses.interfaces;

import military.enums.State;

public interface Mission {
    String getCodeName();

    State getState();

    void completeMission();
}
