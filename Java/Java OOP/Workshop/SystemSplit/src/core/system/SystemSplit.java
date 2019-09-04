package core.system;

import core.model.hardware.Hardware;
import core.model.software.Software;

import java.util.HashMap;
import java.util.Map;

public class SystemSplit {
    private Map<String, Hardware> hardwareComponents;

    public SystemSplit() {
        this.hardwareComponents = new HashMap<>();
    }

    public void addHardwareComponent(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }

    public void addSoftwareToHardware(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.addSoftware(software);
        }
    }
}
