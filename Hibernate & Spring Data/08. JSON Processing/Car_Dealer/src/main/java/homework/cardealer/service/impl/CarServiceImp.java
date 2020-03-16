package homework.cardealer.service.impl;

import homework.cardealer.domain.dto.seed.CarSeedDto;
import homework.cardealer.domain.dto.view.CarIdMakeModelTravelledDistanceViewDto;
import homework.cardealer.domain.dto.view.CarWithPartsViewDto;
import homework.cardealer.domain.entity.Car;
import homework.cardealer.domain.entity.Part;
import homework.cardealer.repository.CarRepository;
import homework.cardealer.service.CarService;
import homework.cardealer.service.PartService;
import homework.cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImp implements CarService {
    private final CarRepository carRepository;
    private final PartService partService;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    public CarServiceImp(CarRepository carRepository, PartService partService, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCars(CarSeedDto[] carsDtos) {
        for (CarSeedDto carSeedDto : carsDtos) {
            if (!this.validatorUtil.isValid(carSeedDto)) {
                this.validatorUtil.validations(carSeedDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

                continue;
            }

            Car car = this.modelMapper.map(carSeedDto, Car.class);

            Set<Part> parts = this.partService.getRandomPartSet();

            car.setParts(parts);

            this.carRepository.saveAndFlush(car);
        }
    }

    @Override
    public List<Car> getAllCastWithoutCustomer() {
        return carRepository
                .findAll()
                .stream()
                .filter(c -> c.getSale() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarIdMakeModelTravelledDistanceViewDto> getAllCarsMakeToyota() {
        return this.carRepository.getAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(c -> modelMapper.map(c, CarIdMakeModelTravelledDistanceViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarWithPartsViewDto> getAllCarsWithListedParts() {
        return this.carRepository
                .findAll()
                .stream()
                .map(c -> modelMapper.map(c, CarWithPartsViewDto.class))
                .collect(Collectors.toList());
    }
}
