package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MotorcycleRepository implements Repository<Motorcycle> {
    Collection<Motorcycle> motorcycles;

    public MotorcycleRepository() {
        this.motorcycles = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        for (Motorcycle motorcycle : this.motorcycles) {
            if (motorcycle.getModel().equals(name)) {
                return motorcycle;
            }
        }

        return null;
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.motorcycles);
    }

    @Override
    public void add(Motorcycle motorcycle) {
        this.motorcycles.add(motorcycle);
    }

    @Override
    public boolean remove(Motorcycle motorcycle) {
        return this.motorcycles.remove(motorcycle);
    }
}
