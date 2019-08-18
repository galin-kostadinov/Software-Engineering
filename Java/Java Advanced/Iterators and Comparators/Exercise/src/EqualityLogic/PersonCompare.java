package EqualityLogic;

import java.util.Comparator;

public class PersonCompare implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
        int result = f.getName().compareTo(s.getName());

        if (result == 0) {
            result = f.getAge() - s.getAge();
        }


        return result;
    }
}
