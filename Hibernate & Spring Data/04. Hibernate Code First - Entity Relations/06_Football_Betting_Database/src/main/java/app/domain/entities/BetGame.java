package app.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bet_games")
public class BetGame implements Serializable {
    private Game game;
    private Bet bet;
    private ResultPrediction resultPrediction;

    @Id
    @OneToOne
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Id
    @OneToOne
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @OneToOne
    @JoinColumn(name = "result_prediction")
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        BetGame betGame = (BetGame) o;

        if (game != null ? !game.equals(betGame.game) : betGame.game != null) {
            return false;
        }
        if (bet != null ? !bet.equals(betGame.bet) : betGame.bet != null) {
            return false;
        }
        return resultPrediction != null ? resultPrediction.equals(betGame.resultPrediction) : betGame.resultPrediction == null;
    }

    @Override
    public int hashCode() {
        int result = game != null ? game.hashCode() : 0;
        result = 31 * result + (bet != null ? bet.hashCode() : 0);
        result = 31 * result + (resultPrediction != null ? resultPrediction.hashCode() : 0);
        return result;
    }
}
