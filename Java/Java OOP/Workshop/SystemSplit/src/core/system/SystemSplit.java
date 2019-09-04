package core.system;

import core.model.hardware.Hardware;

import java.util.HashMap;
import java.util.Map;

public class SystemSplit {
    private Map<String, Hardware> hardwareComponents;

    public SystemSplit() {
        this.hardwareComponents = new HashMap<>();
    }

    public void addHardwareComponent(Hardware hardware){
        this.hardwareComponents.put(hardware.getName(), hardware);
    }
}
