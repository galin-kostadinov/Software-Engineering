package homework.usersystem.services;

import homework.usersystem.entities.Town;

public interface TownService {
    void seedTowns();

    Town getTownById(Long id);
}
