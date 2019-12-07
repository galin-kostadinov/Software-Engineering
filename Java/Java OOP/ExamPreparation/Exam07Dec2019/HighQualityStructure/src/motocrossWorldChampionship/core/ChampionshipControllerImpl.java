package motocrossWorldChampionship.core;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.common.OutputMessages;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.RaceRepository;
import motocrossWorldChampionship.repositories.RiderRepository;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ChampionshipControllerImpl implements ChampionshipController {
    private static final int MIN_COUNT_OF_PARTICIPANTS = 3;

    Repository<Rider> riderRepository;
    Repository<Motorcycle> motorcycleRepository;
    Repository<Race> raceRepository;

    public ChampionshipControllerImpl() {
        this.riderRepository = new RiderRepository();
        this.motorcycleRepository = new MotorcycleRepository();
        this.raceRepository = new RaceRepository();
    }

    @Override
    public String createRider(String riderName) {
        if (riderRepository.getByName(riderName) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_EXISTS, riderName));
        }

        riderRepository.add(new RiderImpl(riderName));

        return String.format(OutputMessages.RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        if (motorcycleRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.MOTORCYCLE_EXISTS, model));
        }

        Motorcycle motorcycle = null;

        switch (type) {
            case "Speed":
                motorcycle = new SpeedMotorcycle(model, horsePower);
                break;
            case "Power":
                motorcycle = new PowerMotorcycle(model, horsePower);
                break;
            default:
                break;
        }

        motorcycleRepository.add(motorcycle);

        return String.format(OutputMessages.MOTORCYCLE_CREATED, type + "Motorcycle", model);
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        Rider rider = riderRepository.getByName(riderName);

        if (rider == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }

        Motorcycle motorcycle = motorcycleRepository.getByName(motorcycleModel);

        if (motorcycle == null) {
            throw new NullPointerException(String.format(ExceptionMessages.MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }

        rider.addMotorcycle(motorcycle);

        return String.format(OutputMessages.MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        Race race = raceRepository.getByName(raceName);

        if (race == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        Rider rider = riderRepository.getByName(riderName);

        if (rider == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }

        race.addRider(rider);

        return String.format(OutputMessages.RIDER_ADDED, riderName, raceName);

    }

    @Override
    public String startRace(String raceName) {

        Race race = raceRepository.getByName(raceName);

        if (race == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        if (race.getRiders().size() < MIN_COUNT_OF_PARTICIPANTS) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.RACE_INVALID, raceName, MIN_COUNT_OF_PARTICIPANTS));
        }

        int labs = race.getLaps();
        List<Rider> collect = race.getRiders()
                .stream()
                .sorted((f, s) -> Double.compare(s.getMotorcycle().calculateRacePoints(labs), f.getMotorcycle().calculateRacePoints(labs)))
                .collect(Collectors.toList());

        String result = String.format(OutputMessages.RIDER_FIRST_POSITION, collect.get(0).getName(), raceName)
                + System.lineSeparator() +
                String.format(OutputMessages.RIDER_SECOND_POSITION, collect.get(1).getName(), raceName)
                + System.lineSeparator() +
                String.format(OutputMessages.RIDER_THIRD_POSITION, collect.get(2).getName(), raceName);

        raceRepository.remove(race);

        return result;
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }

        raceRepository.add(new RaceImpl(name, laps));

        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
