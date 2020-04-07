package services.base;

import models.entity.Car;
import models.entity.Engine;
import models.entity.User;
import models.service.CarServiceModel;
import org.modelmapper.ModelMapper;
import services.CarValidationService;
import services.CarsService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class CarsServiceImpl implements CarsService {
    private final ModelMapper mapper;
    private final EntityManager entityManager;
    private final CarValidationService carValidationService;

    @Inject
    public CarsServiceImpl(ModelMapper mapper, EntityManager entityManager, CarValidationService carValidationService) {
        this.mapper = mapper;
        this.entityManager = entityManager;
        this.carValidationService = carValidationService;
    }

    @Override
    public List<CarServiceModel> getAll() {
        return entityManager
                .createQuery("select c from Car c", Car.class)
                .getResultList()
                .stream()
                .map(car -> mapper.map(car, CarServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void create(String brand, String model, Integer year, Engine engine, String username) throws Exception {
        if (!carValidationService.isValid(brand, model, year, engine)) {
            throw new Exception("Car cannot be created");
        }

        User user = entityManager
                .createQuery("select u from User u where u.username=:username", User.class)
                .setParameter("username", username)
                .getSingleResult();

        List<Car> cars = entityManager.createQuery("select c from Car c " +
                "where c.brand =:brand and  c.model=:model and c.year=:year and c.engine =:engine", Car.class)
                .setParameter("brand", brand)
                .setParameter("model", model)
                .setParameter("year", year)
                .setParameter("engine", engine)
                .getResultList();

        if (!cars.isEmpty()) {
            return;
        }

        entityManager.getTransaction().begin();
        Car car = new Car(brand, model, year, engine, user);
        entityManager.persist(car);
        entityManager.getTransaction().commit();
    }
}
