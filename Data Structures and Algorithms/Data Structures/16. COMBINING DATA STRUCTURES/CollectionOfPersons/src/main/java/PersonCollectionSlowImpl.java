import java.util.*;

public class PersonCollectionSlowImpl implements PersonCollection {

    @Override
    public boolean addPerson(String email, String name, int age, String town) {
        return false;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Person findPerson(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deletePerson(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Person> findPersons(String emailDomain) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Person> findPersons(String name, String town) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Person> findPersons(int startAge, int endAge) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Person> findPersons(int startAge, int endAge, String town) {
        throw new UnsupportedOperationException();
    }
}
