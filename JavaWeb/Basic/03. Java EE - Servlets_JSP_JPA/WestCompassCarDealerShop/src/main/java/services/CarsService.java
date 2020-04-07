package services;

import models.entity.Engine;
import models.service.CarServiceModel;

import java.util.List;

public interface CarsService {
    List<CarServiceModel> getAll();

    void create(String brand, String model, Integer year, Engine engine, String username) throws Exception;
}
