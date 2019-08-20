package JediGalaxy;

public class Player {
    private long stars;

    public Player() {
        this.stars = 0L;
    }

    public void addStars(long starsToAdd) {
        this.stars += starsToAdd;
    }

    public long getStars() {
        return this.stars;
    }
}
