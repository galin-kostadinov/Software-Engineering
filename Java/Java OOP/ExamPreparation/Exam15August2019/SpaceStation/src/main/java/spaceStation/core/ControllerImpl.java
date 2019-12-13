package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    Repository<Astronaut> astronautRepository;
    Repository<Planet> planetRepository;
    Mission mission = new MissionImpl();
    int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository(new LinkedHashSet<>());
        this.planetRepository = new PlanetRepository(new LinkedHashSet<>());
        exploredPlanets = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        switch (type) {
            case "Biologist":
                this.astronautRepository.add(new Biologist(astronautName));
                break;
            case "Geodesist":
                this.astronautRepository.add(new Geodesist(astronautName));
                break;
            case "Meteorologist":
                this.astronautRepository.add(new Meteorologist(astronautName));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        planetRepository.add(new PlanetImpl(planetName, items));

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = null;
        for (Astronaut a : astronautRepository.getModels()) {
            if (a.getName().equals(astronautName)) {
                astronaut = a;
                break;
            }
        }

        if (astronaut != null) {
            this.astronautRepository.remove(astronaut);
            return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = planetRepository.findByName(planetName);
        Collection<Astronaut> astronautLint = astronautRepository
                .getModels()
                .stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if (astronautLint.size() < 1) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        mission.explore(planet, astronautLint);

        int count = 0;
        for (Astronaut astronaut : astronautLint) {
            if (!astronaut.canBreath()) {
                count++;
            }
        }

        exploredPlanets++;

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, count);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        String report = String.format("%d planets were explored!%n" +
                "Astronauts info:%n", exploredPlanets);

        for (Astronaut model : astronautRepository.getModels()) {
            sb.append(model.toString()).append(System.lineSeparator());
        }

        return report + sb.toString().trim();
    }
}
