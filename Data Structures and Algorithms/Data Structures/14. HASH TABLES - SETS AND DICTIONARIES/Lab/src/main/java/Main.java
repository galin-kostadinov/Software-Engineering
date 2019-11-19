public class Main {

    public static void main(String[] args) {
        HashSet<Integer> setA = new HashSet<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);

        HashSet<Integer> setB = new HashSet<>();

        setB.add(1);
        setB.add(5);
        setB.add(6);
        setB.add(7);

        HashSet<Integer> unionSet = setA.unionWith(setB);

        HashSet<Integer> intersectSet = setA.intersectWith(setB);

        HashSet<Integer> exeptSet = setA.exept(setB);

        HashSet<Integer> symetricExeptSet = setA.symetricExept(setB);

        System.out.println();
    }
}
