package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ExtendedDatabaseTest {
    private static final String[] NAMES = {"A", "B", "C", "D", "E"};

    private Database db;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        Person[] people = new Person[5];

        for (int i = 0; i < 5; i++) {
            people[i] = new Person(i + 1, NAMES[i]);
        }
        this.db = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowAnExceptionWhenCallWittNull() throws OperationNotSupportedException {
        db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowAnExceptionWithDuplicatedUsernames() throws OperationNotSupportedException {
        this.db.add(new Person(13, "A"));
        this.db.findByUsername("A");
    }

    @Test
    public void findByUsernameShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person found = this.db.findByUsername("E");
        boolean areEqual = found.getId() == 5 && found.getUsername().equals("E");
        Assert.assertTrue(areEqual);
    }

    @Test
    public void findByUsernameShouldBeCaseSensitive() throws OperationNotSupportedException {
        this.db.add(new Person(44, "b"));
        Person found = this.db.findByUsername("b");
        boolean areEqual = found.getId() == 44 && found.getUsername().equals("b");
        Assert.assertTrue(areEqual);
    }
}