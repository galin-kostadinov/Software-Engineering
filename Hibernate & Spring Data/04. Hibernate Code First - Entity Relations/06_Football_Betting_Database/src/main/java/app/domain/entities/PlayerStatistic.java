package app.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistic implements Serializable {
    private Game game;
    private Player player;
    private int scoredGoals;
    private int playerAssists;
    private int playedMinutes;

    public PlayerStatistic() {
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column(name = "scored_goals")
    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assists")
    public int getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(int playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column(name = "played_minutes")
    public int getPlayedMinutes() {
        return playedMinutes;
    }

    public void setPlayedMinutes(int playedMinutes) {
        this.playedMinutes = playedMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayerStatistic that = (PlayerStatistic) o;

        if (scoredGoals != that.scoredGoals) {
            return false;
        }
        if (playerAssists != that.playerAssists) {
            return false;
        }
        if (playedMinutes != that.playedMinutes) {
            return false;
        }
        if (game != null ? !game.equals(that.game) : that.game != null) {
            return false;
        }
        return player != null ? player.equals(that.player) : that.player == null;
    }

    @Override
    public int hashCode() {
        int result = game != null ? game.hashCode() : 0;
        result = 31 * result + (player != null ? player.hashCode() : 0);
        result = 31 * result + (int) scoredGoals;
        result = 31 * result + (int) playerAssists;
        result = 31 * result + (int) playedMinutes;
        return result;
    }
}
