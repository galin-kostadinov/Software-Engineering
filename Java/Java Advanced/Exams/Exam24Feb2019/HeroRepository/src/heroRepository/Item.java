package heroRepository;

public class Item {
    private int strength;
    private int agility;
    private int intelligence;

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Item:").append(System.lineSeparator());
        sb.append("  *  Strength: ").append(this.getStrength()).append(System.lineSeparator());
        sb.append("  *  Agility: ").append(this.getAgility()).append(System.lineSeparator());
        sb.append("  *  Intelligence: ").append(this.getIntelligence());

        return sb.toString();
    }
}
