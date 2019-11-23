import java.util.*;

public class PersonCollectionImpl implements PersonCollection {


    private Map<String, Person> byEmail;
    private Map<String, Map<String, Person>> byDomain;
    private Map<String, Map<String, Person>> byNameAndTown;
    private Map<Integer, Map<String, Person>> byAge;
    private Map<String, Map<String, Person>> byAgeAndTown;

    public PersonCollectionImpl() {
        this.byEmail = new HashMap<>();
        this.byDomain = new HashMap<>();
        this.byNameAndTown = new HashMap<>();
        this.byAge = new TreeMap<>();
        this.byAgeAndTown = new HashMap<>();
    }

    @Override
    public boolean addPerson(String email, String name, int age, String town) {
        if (this.byEmail.containsKey(email)) {
            return false;
        }

        Person person = new Person(email, name, age, town);
        this.byEmail.put(email, person);
        this.addByDomain(email, person);
        this.addByNameTown(person);
        this.addByAge(person);
        this.addByAgeTown(person);
        return true;
    }

    private void addByAgeTown(Person person) {
        String key = person.getAge() + " " + person.getTown();

        if (!this.byAgeAndTown.containsKey(key)) {
            this.byAgeAndTown.put(key, new TreeMap<>());
        }

        this.byAgeAndTown.get(key).put(person.getEmail(), person);
    }

    private void addByAge(Person person) {
        int age = person.getAge();

        if (!this.byAge.containsKey(age)) {
            this.byAge.put(age, new TreeMap<>());
        }
        this.byAge.get(age).put(person.getEmail(), person);

    }

    private void addByNameTown(Person person) {
        String key = person.getTown() + " " + person.getName();

        if (!this.byNameAndTown.containsKey(key)) {
            this.byNameAndTown.put(key, new TreeMap<>());
        }

        this.byNameAndTown.get(key).put(person.getEmail(), person);
    }

    private void addByDomain(String email, Person person) {
        String domain = email.split("@")[1];

        if (!this.byDomain.containsKey(domain)) {
            this.byDomain.put(domain, new TreeMap<>());
        }

        this.byDomain.get(domain).put(email, person);
    }

    @Override
    public int getCount() {
        return this.byEmail.size();
    }

    @Override
    public Person findPerson(String email) {
        if (!this.byEmail.containsKey(email)) {
            return null;
        }

        return this.byEmail.get(email);
    }

    @Override
    public boolean deletePerson(String email) {
        if (!this.byEmail.containsKey(email)) {
            return false;
        }

        Person person = this.byEmail.get(email);
        String domain = email.split("@")[1];

        this.byEmail.remove(email);
        this.byDomain.get(domain).remove(email);

        String keyNameAndTow = person.getTown() + " " + person.getName();
        this.byNameAndTown.get(keyNameAndTow).remove(email);

        this.byAge.get(person.getAge()).remove(email);

        String keyAgeAndTown = person.getAge() + " " + person.getTown();
        this.byAgeAndTown.get(keyAgeAndTown).remove(email);

        return true;
    }

    @Override
    public Iterable<Person> findPersons(String emailDomain) {
        if (!this.byDomain.containsKey(emailDomain)) {
            return new ArrayList<>();
        }

        return this.byDomain.get(emailDomain).values();
    }

    @Override
    public Iterable<Person> findPersons(String name, String town) {
        String key = town + " " + name;

        if (!this.byNameAndTown.containsKey(key)) {
            return new ArrayList<>();
        }

        return this.byNameAndTown.get(key).values();
    }

    @Override
    public Iterable<Person> findPersons(int startAge, int endAge) {
        List<Person> result = new ArrayList<>();

        this.byAge
                .entrySet()
                .stream()
                .filter(kvp -> kvp.getKey() >= startAge && kvp.getKey() <= endAge)
                .forEach(kvp -> result.addAll(kvp.getValue().values()));

        return result;
    }

    @Override
    public Iterable<Person> findPersons(int startAge, int endAge, String town) {
        List<Person> result = new ArrayList<>();

        this.byAgeAndTown
                .entrySet()
                .stream()
                .filter(kvp -> {
                    String key = kvp.getKey();
                    int age = Integer.parseInt(key.split(" ")[0]);
                    String currTown = key.split(" ")[1];

                    if (age >= startAge && age <= endAge && town.equals(currTown)) {
                        return true;
                    }

                    return false;
                })
                .forEach(kvp -> result.addAll(kvp.getValue().values()));

        return result;
    }
}
