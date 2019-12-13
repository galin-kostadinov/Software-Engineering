package parkingSystem;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

public class SoftParkTest {
    public SoftPark softPark;

    @Before
    public void createParking() {
        softPark = new SoftPark();
    }

    @Test
    public void constructorCreatesParkingCorrectly() {
        Assert.assertEquals(12, this.softPark.getParking().size());
    }

    @Test
    public void getParkingOnEmptyParkingShouldReturnEmptyPlaces() {
        boolean isEmpty = true;

        Map<String, Car> parking = softPark.getParking();

        for (Car value : parking.values()) {
            if (value != null) {
                isEmpty = false;
                break;
            }
        }

        Assert.assertTrue(isEmpty);
    }

    @Test
    public void getParkingOnNotEmptyParkingShouldReturnNotEmptyPlace() {

        int index = 0;
        for (String s : softPark.getParking().keySet()) {
            Car car = new Car("Audi" + index, "A1111A" + index);
            if (s == null) {
                softPark.parkCar(s, car);
                index++;
            }

            break;
        }

        boolean isEmpty = false;
        for (String s : softPark.getParking().keySet()) {
            Car car = new Car("Audi" + index, "A1111A" + index);
            if (s == null) {
                isEmpty = true;
            }

            break;
        }

        Assert.assertFalse(isEmpty);
    }


    @Test(expected = IllegalArgumentException.class)
    public void parkOnNotExistedParkSpotShouldThrowException() {
        Car car = Mockito.mock(Car.class);
        softPark.parkCar("H123h", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkOnNotEmptyParkSpotShouldThrowException() {
        Car car = Mockito.mock(Car.class);
        Car car1 = Mockito.mock(Car.class);


        String spot = null;
        for (String s : softPark.getParking().keySet()) {
            spot = s;
            break;
        }

        softPark.parkCar(spot, car);
        softPark.parkCar(spot, car1);
    }

    @Test(expected = IllegalStateException.class)
    public void callParkCarOnParkedCarShouldThrowException() {
        Car car = new Car("Audi", "A1111A");

        String spot = null;
        String spot2 = null;
        for (String s : softPark.getParking().keySet()) {
            if (spot == null) {
                spot = s;
            } else {
                spot2 = s;
                break;
            }
        }

        softPark.parkCar(spot, car);
        softPark.parkCar(spot2, car);
    }

    @Test
    public void parkCarOnEmptySpotShouldReturnAppropriateMessage() {
        Car car = new Car("Audi", "A1111A");

        String spot = null;
        for (String s : softPark.getParking().keySet()) {
            spot = s;
            break;
        }

        String message = softPark.parkCar(spot, car);
        String expectedMessage = "Car:A1111A parked successfully!";

        Assert.assertEquals(expectedMessage, message);
    }

    @Test
    public void parkCarOnEmptySpotShouldParkSuccessfully() {
        Car car = new Car("Audi", "A1111A");

        String spot = null;
        for (String s : softPark.getParking().keySet()) {
            spot = s;
            break;
        }

        softPark.parkCar(spot, car);

        Assert.assertEquals(car, softPark.getParking().get(spot));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarFromNotExistedParkingSpotShouldThrowException() {
        Car car = Mockito.mock(Car.class);
        softPark.removeCar("H123h", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarFromEmptyParkingSpotShouldThrowException() {
        Car car = Mockito.mock(Car.class);

        String spot = null;
        for (String s : softPark.getParking().keySet()) {
            spot = s;
            break;
        }

        softPark.removeCar(spot, car);
    }

    @Test
    public void removeCarShouldReturnAppropriateMessageWhenOperationIsSuccessful() {
        Car car = new Car("Audi", "A1111A");

        String spot = null;
        for (String s : softPark.getParking().keySet()) {
            spot = s;
            break;
        }

        softPark.parkCar(spot, car);

        String message = softPark.removeCar(spot, car);
        String expectedMessage = "Remove car:A1111A successfully!";

        Assert.assertEquals(expectedMessage, message);
    }

    @Test
    public void removeCarShouldMakeEmptySpot() {
        Car car = new Car("Audi", "A1111A");

        String spot = null;
        for (String s : softPark.getParking().keySet()) {
            spot = s;
            break;
        }

        softPark.parkCar(spot, car);
        softPark.removeCar(spot, car);

        Assert.assertEquals(null, softPark.getParking().get(spot));
    }

}