package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Iterator;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<String> items = planet.getItems();
        Iterator<String> iterator = items.iterator();
        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath() && iterator.hasNext()) {
                String item = iterator.next().replace("[", "").replace("]", "");
                astronaut.breath();

                astronaut.getBag().getItems().add(item);
                iterator.remove();
            }
        }
    }
}
