package homework.cardealer.service;

import homework.cardealer.domain.dto.seed.CarSeedDto;
import homework.cardealer.domain.dto.view.CarIdMakeModelTravelledDistanceViewDto;
import homework.cardealer.domain.dto.view.CarWithPartsViewDto;
import homework.cardealer.domain.entity.Car;

import java.util.List;

public interface CarService {
    void seedCars(CarSeedDto[] cars);

    List<Car> getAllCastWithoutCustomer();

    List<CarIdMakeModelTravelledDistanceViewDto> getAllCarsMakeToyota();

    List<CarWithPartsViewDto> getAllCarsWithListedParts();
}
