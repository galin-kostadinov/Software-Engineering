package homework.cardealer.service;

import homework.cardealer.domain.dto.seed.CarSeedDto;
import homework.cardealer.domain.dto.view.CarIdMakeModelTravelledDistanceViewRootDto;
import homework.cardealer.domain.dto.view.CarMakeModelTravelledDistanceViewRootDto;
import homework.cardealer.domain.entity.Car;

import java.util.List;

public interface CarService {
    void seedCars(List<CarSeedDto> cars);

    List<Car> getAllCastWithoutCustomer();

    CarIdMakeModelTravelledDistanceViewRootDto getAllCarsMakeToyota();

    CarMakeModelTravelledDistanceViewRootDto getAllCarsWithListedParts();
}
