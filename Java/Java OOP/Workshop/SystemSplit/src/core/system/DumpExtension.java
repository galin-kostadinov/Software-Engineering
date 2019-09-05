package core.system;

import core.model.hardware.Hardware;
import core.model.software.Software;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class DumpExtension extends SystemSplit {
    private Map<String, Hardware> dumpHardwareCollection;

    private Map<String, Hardware> sharedHardware;

    public DumpExtension() {
        this.dumpHardwareCollection = new LinkedHashMap<>();
        this.initialSharedHardware();
    }

    private void initialSharedHardware() {
        Class<?> systemSplitClass = this.getClass().getSuperclass();

        try {
            Field hardwareComponents = systemSplitClass.getDeclaredField("hardwareComponents");
            hardwareComponents.setAccessible(true);

            Field sharedHardware = this.getClass().getDeclaredField("sharedHardware");
            sharedHardware.setAccessible(true);
            sharedHardware.set(this, hardwareComponents.get(this));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void addHardwareComponentToDump(Hardware hardware) {
        this.dumpHardwareCollection.put(hardware.getName(), hardware);
    }

    public void addHardwareComponentToSharedHardware(Hardware hardware) {
        this.sharedHardware.put(hardware.getName(), hardware);
    }

    public void removeHardwareComponentFromSharedHardware(Hardware hardware) {
        this.sharedHardware.remove(hardware.getName());
    }

    public void removeHardwareComponentFromDumpHardwareCollection(Hardware hardware) {
        this.dumpHardwareCollection.remove(hardware.getName());
    }

    public Hardware getHardwareComponentFromSharedHardware(String name) {
        if (this.sharedHardware.containsKey(name)) {
            return this.sharedHardware.get(name);
        }
        return null;
    }

    public Hardware getHardwareComponentFromDumpHardwareCollection(String name) {
        if (this.dumpHardwareCollection.containsKey(name)) {
            return this.dumpHardwareCollection.get(name);
        }
        return null;
    }

    public long getCountOfPowerHardwareComponents() {
        return getCountOfCurrentTypeHardwareComponent(h -> h.getType().equalsIgnoreCase("Power"));
    }

    public long getCountOfHeavyHardwareComponents() {
        return getCountOfCurrentTypeHardwareComponent(h -> h.getType().equalsIgnoreCase("Heavy"));
    }

    public int getCountOfExpressSoftwareComponents() {
        return getCountOfCurrentTypeSoftwareComponent("EXPRESS");
    }

    public int getCountOfLightSoftwareComponents() {
        return getCountOfCurrentTypeSoftwareComponent("LIGHT");
    }

    public int getTotalDumpedMemory() {
        return this.getSumValue(Hardware::getUsedMemory);
    }

    public int getTotalDumpedCapacity() {
        return this.getSumValue(Hardware::getUsedCapacity);
    }

    private int getSumValue(ToIntFunction<Hardware> function) {
        return this.dumpHardwareCollection
                .values()
                .stream()
                .mapToInt(function)
                .sum();
    }

    private long getCountOfCurrentTypeHardwareComponent(Predicate<Hardware> isType) {
        return this.dumpHardwareCollection
                .values()
                .stream()
                .filter(isType)
                .count();
    }

    public int getCountOfCurrentTypeSoftwareComponent(String typeName) {
        int count = 0;
        for (Hardware hardware : dumpHardwareCollection.values()) {
            try {
                Field softwares = hardware.getClass().getSuperclass().getDeclaredField("softwares");
                softwares.setAccessible(true);
                List<Software> list = (List<Software>) softwares.get(hardware);

                for (Software software : list) {
                    Field type = software.getClass().getSuperclass().getDeclaredField("type");
                    type.setAccessible(true);

                    Enum typeEnum = (Enum) type.get(software);

                    if (typeEnum.name().equals(typeName)) {
                        count++;
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return count;
    }
}
