package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return this.data.size();
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            Rabbit rabbit = this.data.get(i);
            if (rabbit.getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }

        return false;
    }

    public void removeSpecies(String species) {
        for (int i = 0; i < this.data.size(); i++) {
            Rabbit rabbit = this.data.get(i);
            if (rabbit.getSpecies().equals(species)) {
                this.data.remove(i);
                i--;
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name) && rabbit.isAvailable()) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }

        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> allRabbitsBySpecies = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species) && rabbit.isAvailable()) {
                allRabbitsBySpecies.add(rabbit);
                rabbit.setAvailable(false);
            }
        }

        return allRabbitsBySpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        String strFormat = String.format("Rabbits available at %s:", this.getName());

        StringBuilder sb = new StringBuilder();
        sb.append(strFormat).append(System.lineSeparator());

        for (Rabbit rabbit : this.data) {

            if (rabbit.isAvailable()) {
                sb.append(rabbit).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
