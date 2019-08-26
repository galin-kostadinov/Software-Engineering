public class Cat extends Animal {
    private final static String MEEOW = "MEEOW";

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.baseExplain() + System.lineSeparator() + MEEOW;
    }
}
