package StrategyPattern;

import java.util.Comparator;

public class PersonByAge implements Comparator<Person> {

    @Override
    public int compare(Person f, Person s) {
        return f.getAge() - s.getAge();
    }
}
