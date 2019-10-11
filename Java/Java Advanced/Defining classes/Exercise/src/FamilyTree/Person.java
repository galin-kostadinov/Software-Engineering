package FamilyTree;

public class Person {
    private String name;
    private String birthday;

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public Person(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

