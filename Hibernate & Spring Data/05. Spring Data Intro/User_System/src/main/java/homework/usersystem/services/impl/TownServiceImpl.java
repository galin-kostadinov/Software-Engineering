package homework.usersystem.services.impl;

import homework.usersystem.entities.Town;
import homework.usersystem.repository.CountryRepository;
import homework.usersystem.repository.TownRepository;
import homework.usersystem.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, CountryRepository countryRepository) {
        this.townRepository = townRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void seedTowns() {
        if (this.townRepository.count() != 0) {
            return;
        }

        Town town = new Town();
        town.setName("Sofia");
        town.setCountry(countryRepository.getOne(1L));

        this.townRepository.saveAndFlush(town);
    }

    @Override
    public Town getTownById(Long id) {
        return this.townRepository.getOne(id);
    }
}
