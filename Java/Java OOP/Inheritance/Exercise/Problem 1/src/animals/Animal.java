package animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.setAge(age);
        this.gender = gender;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public abstract String produceSound();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String animalType = this.getClass().getSimpleName();

        sb.append(animalType).append(System.lineSeparator());
        sb.append(this.name + " " + this.age + " " + this.gender).append(System.lineSeparator());
        sb.append(this.produceSound());

        return sb.toString();
    }
}
