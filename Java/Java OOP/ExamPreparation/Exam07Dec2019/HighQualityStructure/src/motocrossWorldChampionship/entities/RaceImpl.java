package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race {
    private final static int MIN_NAME_LENGTH = 5;
    private final static int MIN_LABS = 1;

    private String name;
    private int laps;
    private Collection<Rider> riders;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.INVALID_NAME, name, MIN_NAME_LENGTH));
        }

        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < MIN_LABS) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, MIN_LABS));
        }

        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return this.riders;
    }

    @Override
    public void addRider(Rider rider) {
        if (rider == null) {
            throw new NullPointerException(ExceptionMessages.RIDER_INVALID);
        }

        if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.RIDER_NOT_PARTICIPATE, rider.getName()));
        }

        if (riders.contains(rider)) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.RIDER_ALREADY_ADDED, rider.getName(), this.name));
        }

        this.riders.add(rider);
    }
}
