package homework.dealershop.service.service.impl;

import homework.dealershop.data.model.Car;
import homework.dealershop.data.repository.CarRepository;
import homework.dealershop.service.model.CarServiceModel;
import homework.dealershop.service.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CarServiceModel save(CarServiceModel carServiceModel) {
        this.carRepository.save(this.modelMapper.map(carServiceModel, Car.class));

        return carServiceModel;
    }

    @Override
    public List<CarServiceModel> getCars() {
        return this.carRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CarServiceModel.class))
                .collect(Collectors.toList());
    }
}
