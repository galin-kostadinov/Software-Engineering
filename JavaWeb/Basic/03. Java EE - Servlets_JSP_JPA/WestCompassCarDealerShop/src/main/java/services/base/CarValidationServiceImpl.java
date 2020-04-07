package services.base;

import models.entity.Engine;
import services.CarValidationService;

public class CarValidationServiceImpl implements CarValidationService {
    @Override
    public boolean isValid(String brand, String model, Integer year, Engine engine) {
        return (brand != null && !brand.isEmpty()) &&
                (model != null && !model.isEmpty()) &&
                (year != null) &&
                (engine != null);
    }
}
