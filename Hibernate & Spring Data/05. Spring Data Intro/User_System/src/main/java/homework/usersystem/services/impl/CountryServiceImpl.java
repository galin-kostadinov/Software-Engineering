package homework.usersystem.services.impl;

import homework.usersystem.entities.Country;
import homework.usersystem.repository.CountryRepository;
import homework.usersystem.services.CountryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void seedCountries() {
        if (this.countryRepository.count() != 0) {
            return;
        }

        Country country = new Country();
        country.setName("Bulgaria");
        this.countryRepository.saveAndFlush(country);
    }
}
