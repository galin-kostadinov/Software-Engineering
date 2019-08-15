package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scala = new Scale<>(5,10);

        System.out.println(scala.getHeavier());
    }
}
