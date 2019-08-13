package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String input;
        while (!"Tournament".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            trainerMap.putIfAbsent(trainerName, new Trainer(trainerName));
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerMap.get(trainerName).addPokemon(pokemon);
        }

        while (!"End".equals(input = reader.readLine())) {
            if (input.equals("Fire") || input.equals("Water") || input.equals("Electricity")) {
                String element = input;

                for (Map.Entry<String, Trainer> trainerEntry : trainerMap.entrySet()) {
                    boolean[] isContainsElement = {false};
                    trainerEntry.getValue().getPokemonCollection().forEach(pokemon -> {
                        if (pokemon.getElement().equals(element)) {
                            isContainsElement[0] = true;
                        }
                    });

                    if (isContainsElement[0]) {
                        trainerEntry.getValue().setNumberOfBadges();
                    } else {
                        trainerEntry.getValue().setPokemonCollectionHealth();
                    }
                }
            }
        }

        trainerMap.entrySet()
                .stream()
                .sorted((f, s) -> Integer.compare(s.getValue().getNumberOfBadges(), f.getValue().getNumberOfBadges()))
                .forEach(entry -> {
                    System.out.println(entry.getValue().toString());
                });

    }
}
