package pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        Validator.validateFlourType(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        Validator.validateBakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
       Validator.validateDoughWeight(weight);
        this.weight = weight;
    }

    public double calculateCalories() {
        double modifierFlourType = 0;
        double modifierBakingTechnique = 0;

        switch (this.flourType) {
            case "White":
                modifierFlourType = 1.5;
                break;
            case "Wholegrain":
                modifierFlourType = 1.0;
                break;
        }

        switch (this.bakingTechnique) {
            case "Crispy":
                modifierBakingTechnique = 0.9;
                break;
            case "Chewy":
                modifierBakingTechnique = 1.1;
                break;
            case "Homemade":
                modifierBakingTechnique = 1.0;
                break;
        }

        return 2 * this.weight * modifierFlourType * modifierBakingTechnique;
    }

}
