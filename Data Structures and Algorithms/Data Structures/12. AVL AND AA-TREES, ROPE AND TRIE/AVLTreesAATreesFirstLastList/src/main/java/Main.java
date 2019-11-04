public class Main {

    public static void main(String[] args) {
        FirstLastList<Integer> a = new FirstLastList<>();
        a.add(1);
        a.add(2);
        a.add(1);
        a.removeAll(1);
        System.out.println();
    }
}
