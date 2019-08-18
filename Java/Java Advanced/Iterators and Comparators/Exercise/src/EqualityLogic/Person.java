package EqualityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other instanceof Person) {
            if (this.name.equals(((Person) other).name)
                    && this.age.equals(((Person) other).age)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.age.hashCode();
    }


    @Override
    public int compareTo(Person other) {
        int result = this.getName().compareTo(other.getName());

        if (result == 0) {
            result = this.getAge() - other.getAge();
        }

        return result;
    }
}
