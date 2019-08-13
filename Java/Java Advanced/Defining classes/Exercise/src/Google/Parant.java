package Google;

public class Parant {
    private String parentName;
    private String parentBirthday;


    public Parant(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s",
                this.parentName,
                this.parentBirthday);
    }
}
