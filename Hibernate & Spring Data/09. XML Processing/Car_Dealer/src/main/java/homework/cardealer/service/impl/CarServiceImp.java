package homework.cardealer.service.impl;

import homework.cardealer.domain.dto.seed.CarSeedDto;
import homework.cardealer.domain.dto.view.*;
import homework.cardealer.domain.entity.Car;
import homework.cardealer.repository.CarRepository;
import homework.cardealer.service.CarService;
import homework.cardealer.service.PartService;
import homework.cardealer.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.List;
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
    public void seedCars(List<CarSeedDto> carsDtos) {
        for (CarSeedDto carDto : carsDtos) {
            if (!this.validatorUtil.isValid(carDto)) {
                this.validatorUtil.validations(carDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

                continue;
            }

            Car car = this.modelMapper.map(carDto, Car.class);
            car.setParts(this.partService.getRandomParts());

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
    public CarIdMakeModelTravelledDistanceViewRootDto getAllCarsMakeToyota() {
        List<CarIdMakeModelTravelledDistanceViewDto> dtos =
                this.carRepository.getAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                        .stream()
                        .map(c -> modelMapper.map(c, CarIdMakeModelTravelledDistanceViewDto.class))
                        .collect(Collectors.toList());

        return new CarIdMakeModelTravelledDistanceViewRootDto(dtos);
    }

    @Override
    public CarMakeModelTravelledDistanceViewRootDto getAllCarsWithListedParts() {
        List<CarMakeModelTravelledDistanceViewDto> dtos = this.carRepository
                .findAll()
                .stream()
                .map(c -> modelMapper.map(c, CarMakeModelTravelledDistanceViewDto.class))
                .collect(Collectors.toList());

        return new CarMakeModelTravelledDistanceViewRootDto(dtos);
    }
}
