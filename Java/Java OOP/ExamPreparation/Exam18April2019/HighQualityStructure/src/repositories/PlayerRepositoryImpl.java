package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private static final String NULL_PLAYER = "Player cannot be null";

    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException(NULL_PLAYER);
        }

        String username = player.getUsername();
        for (Player currPlayer : players) {
            if (currPlayer.getUsername().equals(username)) {
                throw new IllegalArgumentException(
                        String.format("Player %s already exists!", username));
            }
        }

        this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException(NULL_PLAYER);
        }

        return players.remove(player);
    }

    @Override
    public Player find(String name) {
        for (Player currPlayer : players) {
            if (currPlayer.getUsername().equals(name)) {
                return currPlayer;
            }
        }

        return null;
    }
}
