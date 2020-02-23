package app.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity implements Serializable {
    private Team homeTeam;
    private Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private LocalDateTime dateTime;
    private int homeTeamWinBetRate;
    private int awayTeamWinBetRate;
    private int drawGameBetRate;
    private Round round;
    private Competition competition;

    public Game() {
    }

    @OneToOne
    @JoinColumn(name = "home_team")
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @OneToOne
    @JoinColumn(name = "away_team")
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_team_goals")
    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    @Column(name = "away_team_goals")
    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Column(name = "date_time")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "home_team_win_bet_rate")
    public int getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(int homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    @Column(name = "away_team_win_bet_rate")
    public int getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(int awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    @Column(name = "draw_game_bet_rate")
    public int getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(int drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    @ManyToOne
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
