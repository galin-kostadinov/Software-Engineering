package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.seed.json.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static softuni.exam.Constant.GlobalConstants.*;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final FileIOUtil fileIOUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public CarServiceImpl(CarRepository carRepository, FileIOUtil fileIOUtil, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.fileIOUtil = fileIOUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return fileIOUtil.readFileContent(CARS_SEED_PATH);
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();

        CarSeedDto[] carSeedDtos = gson.fromJson(fileIOUtil.readFileContent(CARS_SEED_PATH), CarSeedDto[].class);

        for (CarSeedDto carSeedDto : carSeedDtos) {
            if (!validationUtil.isValid(carSeedDto)) {
                sb.append("Invalid car").append(System.lineSeparator());
                continue;
            }

            Car carInDb = carRepository
                    .findByMakeAndModelAndKilometers(carSeedDto.getMake(),
                            carSeedDto.getModel(), carSeedDto.getKilometers());
            if (carInDb != null) {
                sb.append("Invalid car").append(System.lineSeparator());
                continue;
            }


            Car car = this.modelMapper.map(carSeedDto, Car.class);

            LocalDate registeredOn = LocalDate.parse(carSeedDto.getRegisteredOn(), DATE_FORMAT);
            car.setRegisteredOn(registeredOn);

            this.carRepository.saveAndFlush(car);

            sb.append(String.format("Successfully imported car - %s - %s", carSeedDto.getMake(), carSeedDto.getModel()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();

        carRepository
                .getCarsOrderByPicturesCountThenByMake()
                .forEach(c -> {
                    sb.append(String.format("Car make - %s, model - %s", c.getMake(), c.getModel()));
                    sb.append(System.lineSeparator());
                    sb.append(String.format("\tKilometers - %d", c.getKilometers())).append(System.lineSeparator());
                    sb.append(String.format("\tRegistered on - %s", c.getRegisteredOn())).append(System.lineSeparator());
                    sb.append(String.format("\tNumber of pictures - %d", c.getPictures().size())).append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }
}
