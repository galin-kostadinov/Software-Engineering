package services;

import models.entity.Engine;

public interface CarValidationService {
    boolean isValid(String brand, String model, Integer year, Engine engine);
}
