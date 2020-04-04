package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.seed.json.PassengerSeedDto;
import softuni.exam.models.dto.seed.json.TownSeedDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;

import static softuni.exam.constant.GlobalConstants.*;
import static softuni.exam.constant.GlobalConstants.PASSENGERS_SEED_PATH;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final FileIOUtil fileIOUtil;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, TownService townService, ModelMapper modelMapper,
                                FileIOUtil fileIOUtil, ValidationUtil validationUtil, Gson gson) {
        this.passengerRepository = passengerRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.fileIOUtil = fileIOUtil;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() {
        try {
            return fileIOUtil.readFileContent(PASSENGERS_SEED_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();

        PassengerSeedDto[] passengerSeedDtos = gson.fromJson(fileIOUtil.readFileContent(PASSENGERS_SEED_PATH), PassengerSeedDto[].class);

        for (PassengerSeedDto passengerSeedDto : passengerSeedDtos) {
            if (!validationUtil.isValid(passengerSeedDto)) {
                sb.append("Invalid Passenger").append(System.lineSeparator());
                continue;
            }

            if (passengerRepository.findByEmail(passengerSeedDto.getEmail()) != null) {
                sb.append("Invalid Passenger").append(System.lineSeparator());
                continue;
            }

            Town town = townService.getByName(passengerSeedDto.getTown());

            if (town == null) {
                sb.append("Invalid Passenger").append(System.lineSeparator());
                continue;
            }

            Passenger passenger = this.modelMapper.map(passengerSeedDto, Passenger.class);
            passenger.setTown(town);

            passengerRepository.saveAndFlush(passenger);

            sb.append(String.format("Successfully imported Passenger %s - %s",
                    passenger.getLastName(), passenger.getEmail()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();

        passengerRepository
                .getPassengersOrderByTicketsCountDescendingThenByEmail()
                .forEach(p -> {
                    sb.append(String.format("Passenger %s %s", p.getFirstName(), p.getLastName()))
                            .append(System.lineSeparator());

                    sb.append(String.format("\tEmail - %s", p.getEmail())).append(System.lineSeparator());
                    sb.append(String.format("\tPhone - %s", p.getPhoneNumber())).append(System.lineSeparator());
                    sb.append(String.format("\tNumber of tickets - %d", p.getTickets().size()))
                            .append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    @Override
    public Passenger getByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }
}
