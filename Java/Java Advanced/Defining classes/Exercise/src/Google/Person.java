package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String personName;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parant> parants;
    private List<Child> children;

    public String getPersonName() {
        return personName;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parant> getParants() {
        return parants;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Person(String personName) {
        this.personName = personName;
        this.pokemons = new ArrayList<>();
        this.parants = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParants(Parant parant) {
        this.parants.add(parant);
    }

    public void addChildren(Child child) {
        this.children.add(child);
    }

}
