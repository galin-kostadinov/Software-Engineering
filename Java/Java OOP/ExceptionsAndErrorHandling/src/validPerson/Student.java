package validPerson;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))){
                throw new InvalidPersonNameException("Name have to contains only Letters!");
            }
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
