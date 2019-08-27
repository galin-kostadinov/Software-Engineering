package animal;

import food.Food;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return super.toString().replace("region", this.getLivingRegion());
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void eat(Food food) {
        boolean foodIsMeat = food.getClass().getSimpleName().equals("Meat");
        String message = (this.getAnimalType() + "s are not eating that type of food!")
                .replace("Mouses", "Mice");

        if (foodIsMeat && !(this instanceof Felime)) {
            throw new IllegalArgumentException(message);
        } else if (!foodIsMeat && this.getAnimalType().equals("Tiger")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }

        super.eat(food);
    }
}
