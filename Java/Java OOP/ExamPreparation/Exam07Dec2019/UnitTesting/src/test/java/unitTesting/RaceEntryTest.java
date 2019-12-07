package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RaceEntryTest {
    RaceEntry raceEntry;

    @Before
    public void init() {
        this.raceEntry = new RaceEntry();
    }

    @Test(expected = NullPointerException.class)
    public void addRiderSholdThrowExeptionWhenTryToAddNull() {
        this.raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRiderSholdThrowExeptionWhenAddElementWithSameName() {
        UnitMotorcycle unitMotorcycle = new UnitMotorcycle("ABC", 100, 100);
        UnitRider unitRider = new UnitRider("Ivan", unitMotorcycle);

        this.raceEntry.addRider(unitRider);
        this.raceEntry.addRider(unitRider);
    }

    @Test
    public void getRidersShouldReturnTheSameCollectionLikeAddedArrange() {
        UnitMotorcycle unitMotorcycle1 = new UnitMotorcycle("ABC" + 1, 100 + 1, 100 + 1);
        UnitRider unitRider1 = new UnitRider("Ivan" + 1, unitMotorcycle1);
        this.raceEntry.addRider(unitRider1);

        UnitMotorcycle unitMotorcycle2 = new UnitMotorcycle("ABC" + 2, 100 + 2, 100 + 2);
        UnitRider unitRider2 = new UnitRider("Ivan" + 2, unitMotorcycle2);
        this.raceEntry.addRider(unitRider2);

        int i = 1;
        for (UnitRider rider : this.raceEntry.getRiders()) {
            if (i == 1) {
                Assert.assertEquals(unitRider1, rider);
                i++;
            } else if (i == 2) {
                Assert.assertEquals(unitRider2, rider);
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerShouldThrowExceptionWHenParticipantAreLessThenTwo() {
        UnitMotorcycle unitMotorcycle = new UnitMotorcycle("ABC" + 1, 100, 100 + 1);

        UnitRider unitRider1 = new UnitRider("Ivan" + 1, unitMotorcycle);


        this.raceEntry.addRider(unitRider1);

        this.raceEntry.calculateAverageHorsePower();
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerShouldThrowExceptionWHenParticipantAreLess() {
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void calculateAverageHorsePowerShouldReturnCorrectValue() {
        UnitMotorcycle unitMotorcycle = new UnitMotorcycle("ABC" + 1, 100, 100 + 1);

        UnitRider unitRider1 = new UnitRider("Ivan" + 1, unitMotorcycle);
        UnitRider unitRider2 = new UnitRider("Ivan" + 2, unitMotorcycle);
        UnitRider unitRider3 = new UnitRider("Ivan" + 3, unitMotorcycle);

        this.raceEntry.addRider(unitRider1);
        this.raceEntry.addRider(unitRider2);
        this.raceEntry.addRider(unitRider3);

        double expectedValue = 100;
        double result = this.raceEntry.calculateAverageHorsePower();

        Assert.assertTrue(expectedValue == result);
    }

    @Test
    public void getRidersOnEmptyCollectionShouldReturnEmpty() {
        Assert.assertTrue(this.raceEntry.getRiders().isEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getRidersShouldReturnUnmodifiableCollectio() {
        UnitMotorcycle unitMotorcycle = new UnitMotorcycle("ABC" + 1, 100, 100 + 1);

        UnitRider unitRider1 = new UnitRider("Ivan" + 1, unitMotorcycle);
        UnitRider unitRider2 = new UnitRider("Ivan" + 2, unitMotorcycle);
        UnitRider unitRider3 = new UnitRider("Ivan" + 3, unitMotorcycle);

        this.raceEntry.addRider(unitRider1);
        this.raceEntry.addRider(unitRider2);
        this.raceEntry.addRider(unitRider3);

        this.raceEntry.getRiders().remove(unitRider1);
    }


}
