package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RiderRepository implements Repository<Rider> {
    Collection<Rider> riders;

    public RiderRepository() {
        this.riders = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        for (Rider rider : this.riders) {
            if (rider.getName().equals(name)) {
                return rider;
            }
        }
        return null;
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.riders);
    }

    @Override
    public void add(Rider rider) {
        this.riders.add(rider);
    }

    @Override
    public boolean remove(Rider rider) {
        return this.riders.remove(rider);
    }
}
