package arena;

import java.util.LinkedHashMap;
import java.util.Map;

public class FightingArena {
    private Map<String, Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new LinkedHashMap<>();
    }

    public void add(Gladiator gladiator) {
        gladiators.putIfAbsent(gladiator.getName(), gladiator);
    }

    public void remove(String name) {
        gladiators.remove(name);
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        String gladiatorName = "";
        int highestStatPower = 0;
        for (Map.Entry<String, Gladiator> gladiatorEntry : gladiators.entrySet()) {

            if (gladiatorEntry.getValue().getStatPower() > highestStatPower) {
                gladiatorName = gladiatorEntry.getKey();
                highestStatPower = gladiatorEntry.getValue().getStatPower();
            }
        }

        if (gladiatorName.isEmpty()) {
            return null;
        } else {
            return gladiators.get(gladiatorName);
        }
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        String gladiatorName = "";
        int highestWeaponPower = 0;
        for (Map.Entry<String, Gladiator> gladiatorEntry : gladiators.entrySet()) {

            if (gladiatorEntry.getValue().getWeaponPower() > highestWeaponPower) {
                gladiatorName = gladiatorEntry.getKey();
                highestWeaponPower = gladiatorEntry.getValue().getWeaponPower();
            }
        }

        if (gladiatorName.isEmpty()) {
            return null;
        } else {
            return gladiators.get(gladiatorName);
        }
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        String gladiatorName = "";
        int highestTotalPower = 0;
        for (Map.Entry<String, Gladiator> gladiatorEntry : gladiators.entrySet()) {

            if (gladiatorEntry.getValue().getTotalPower() > highestTotalPower) {
                gladiatorName = gladiatorEntry.getKey();
                highestTotalPower = gladiatorEntry.getValue().getTotalPower();
            }
        }

        if (gladiatorName.isEmpty()) {
            return null;
        } else {
            return gladiators.get(gladiatorName);
        }
    }

    public int getCount() {
        return this.gladiators.size();
    }

    @Override
    public String toString() {
        return String.format("%s – %s gladiators are participating.",
                this.name,
                this.getCount());
    }
}
