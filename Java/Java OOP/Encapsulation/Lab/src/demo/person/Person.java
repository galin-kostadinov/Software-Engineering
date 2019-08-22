package demo.person;

import static demo.validation.Validator.*;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void setFirstName(String firstName) {
        ensureMinLength(firstName, 3);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        ensureMinLength(firstName, 3);
        this.lastName = lastName;
    }

    public void setAge(int age) {
        ensureValidAge(age);
        this.age = age;
    }

    public void setSalary(double salary) {
      ensureMinNumber(salary, 460);

        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {
            bonus /= 2;
        }
        bonus /= 100;

        double increasedSalary = this.getSalary() * (1 + bonus);
        this.setSalary(increasedSalary);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva.",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary());
    }
}
