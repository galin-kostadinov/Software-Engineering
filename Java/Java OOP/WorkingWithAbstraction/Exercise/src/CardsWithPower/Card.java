package CardsWithPower;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int calcPower() {
        return this.cardRank.getRankPower() + this.cardSuit.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.cardRank,
                this.cardSuit,
                this.calcPower());
    }
}
