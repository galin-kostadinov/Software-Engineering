package CatLady;

public class Siamese extends Cat{
    public Siamese(String name, double skillValue) {
        super(name, skillValue);
    }

    @Override
    public String toString() {
        return "Siamese " + super.toString();
    }
}
