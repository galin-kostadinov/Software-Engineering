package entities;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private int age;
    private Date registrationDate;

    public User(String username, int age, Date registrationDate) {
        this.setUsername(username);
        this.setAge(age);
        this.setRegistrationDate(registrationDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
