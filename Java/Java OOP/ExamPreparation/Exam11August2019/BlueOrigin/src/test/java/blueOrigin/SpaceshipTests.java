package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpaceshipTests {
    Spaceship spaceship;

    @Test(expected = NullPointerException.class)
    public void createSpaceshipWithNullNameShouldThrowException() {
        this.spaceship = new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void createSpaceshipWithWhitespaceNameShouldThrowException() {
        this.spaceship = new Spaceship("   ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createSpaceshipWithNegativeCapacityShouldThrowException() {
        this.spaceship = new Spaceship("Ivan", -1);
    }

    @Test
    public void getCapacityShouldReturnInitCapacity() {
        int initialCapacity = 10;
        this.spaceship = new Spaceship("Ivan", initialCapacity);

        assertEquals(initialCapacity, this.spaceship.getCapacity());
    }

    @Test
    public void getNameShouldReturnInitName() {
        int initialCapacity = 10;
        String initialName = "Ivan";

        this.spaceship = new Spaceship(initialName, initialCapacity);

        assertEquals(initialName, this.spaceship.getName());
    }

    @Test
    public void getCountOnEmptyCollectionShouldReturnZero() {
        int initialCapacity = 10;
        String initialName = "Ivan";

        this.spaceship = new Spaceship(initialName, initialCapacity);

        assertEquals(0, this.spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAstronautIntoFullSpaceshipShouldThrowException() {
        this.spaceship = new Spaceship("Ivan", 0);

        Astronaut astronaut = new Astronaut("Stefan", 100.0);
        spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addExistingAstronautShouldThrowException() {
        this.spaceship = new Spaceship("Ivan", 10);

        Astronaut astronaut = new Astronaut("Stefan", 100.0);
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void removeExistingAstronautShouldReturnTrue() {
        this.spaceship = new Spaceship("Ivan", 10);

        Astronaut astronaut = new Astronaut("Stefan", 100.0);
        spaceship.add(astronaut);

        assertTrue(spaceship.remove(astronaut.getName()));
    }

    @Test
    public void removeNotExistingAstronautShouldReturnFalse() {
        this.spaceship = new Spaceship("Ivan", 10);

        assertFalse(spaceship.remove("Stefan"));
    }
}
