package softUniParking;

public class Car {
    private String make;
    private String model;
    private int horsePower;
    private String registrationNumber;

    public Car(String make, String model, int horsePower, String registrationNumber) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Make: ").append(this.getMake()).append(System.lineSeparator());
        sb.append("Model: ").append(this.getModel()).append(System.lineSeparator());
        sb.append("HorsePower: ").append(this.getHorsePower()).append(System.lineSeparator());
        sb.append("RegistrationNumber: ").append(this.getRegistrationNumber());

        return sb.toString();
    }
}
