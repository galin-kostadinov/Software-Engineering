package spaceStationRecruitment;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpaceStation {
    private String name;
    private int capacity;
    private Map<String, Astronaut> data;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Astronaut astronaut) {
        if (this.data.size() < this.capacity) {
            this.data.putIfAbsent(astronaut.getName(), astronaut);
        }
    }

    public boolean remove(String name) {
        if (this.data.containsKey(name)) {
            this.data.remove(name);
            return true;
        }

        return false;
    }

    public Astronaut getOldestAstronaut() {
        String name = "";
        int age = 0;
        for (Map.Entry<String, Astronaut> astronautEntry : data.entrySet()) {
            if (astronautEntry.getValue().getAge() > age) {
                name = astronautEntry.getKey();
                age = astronautEntry.getValue().getAge();
            }
        }

        if (!name.isEmpty()) {
            return this.data.get(name);
        } else {
            return null;
        }
    }

    public Astronaut getAstronaut(String name) {
        return this.data.get(name);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        String text = String.format("Astronauts working at Space Station %s:", this.getName());
        sb.append(text).append(System.lineSeparator());
        for (Astronaut astronaut : data.values()) {
            sb.append(astronaut.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
