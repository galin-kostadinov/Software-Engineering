package validPerson;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Franco", "Aimee", 19);

        try {
            Person noName = new Person(" ", "Aimee", 19);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Person noLastName = new Person("Franco", null, 19);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Person negativeAge = new Person("Franco", "Aimee", -1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Person toOldForThisProgram = new Person("Franco ", "Aimee", 121);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Student student = new Student("4havdar", "4havdar@abv.bg");
        } catch (InvalidPersonNameException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

    }
}
