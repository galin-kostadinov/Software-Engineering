package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonCollection;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonCollection = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonCollection.add(pokemon);
    }

    public List<Pokemon> getPokemonCollection() {
        return this.pokemonCollection;
    }

    public void setNumberOfBadges() {
        this.numberOfBadges++;
    }

    public void setPokemonCollectionHealth() {
        this.pokemonCollection.forEach(Pokemon::setHealth);
        for (int i = 0; i < pokemonCollection.size(); i++) {
            if (pokemonCollection.get(i).getHealth() <= 0) {
                pokemonCollection.remove(i);
                i--;
            }
        }
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",
                this.name,
                this.numberOfBadges,
                this.pokemonCollection.size());
    }
}
