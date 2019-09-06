package models;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import helpers.Validator;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Race {
    private int distance;
    private int windSpeed;
    private int currentSpeed;
    private boolean AllowMotorboats;
    private Set<Boat> participants;


    public Race(int distance, int windSpeed, int currentSpeed, boolean allowMotorboats) throws ArgumentException {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.currentSpeed = currentSpeed;
        AllowMotorboats = allowMotorboats;
        this.participants = new LinkedHashSet<>();
    }

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public void setDistance(int distance) throws ArgumentException {
        if (Validator.validateParam(distance)) {
            this.distance = distance;
        } else {
            throw new ArgumentException(Validator.generateErrorMessage("Distance"));
        }
    }

    public void addParticipant(Boat participant) throws DuplicateModelException {
        if (!this.participants.add(participant)) {
            throw new DuplicateModelException();
        }
    }

    public Set<Boat> getParticipants() {
        return this.participants;
    }

    public void startRace() {
        this.participants = this.participants
                .stream()
                .sorted((f, s) -> Double.compare(s.calcSpeed(this), f.calcSpeed(this)))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
