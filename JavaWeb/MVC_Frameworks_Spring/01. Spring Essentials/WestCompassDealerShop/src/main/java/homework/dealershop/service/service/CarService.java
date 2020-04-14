package homework.dealershop.service.service;

import homework.dealershop.service.model.CarServiceModel;

import java.util.List;

public interface CarService {
    CarServiceModel save(CarServiceModel carServiceModel);

    List<CarServiceModel> getCars();
}
