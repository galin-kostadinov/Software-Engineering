package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private static final String NULL_CARD = "Card cannot be null!";
    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException(NULL_CARD);
        }

        for (Card c : cards) {
            if (c.getName().equals(card.getName())) {
                throw new IllegalArgumentException(String.format("Card %s already exists!", card.getName()));
            }
        }

        cards.add(card);
    }

    @Override
    public boolean remove(Card card) {
        if (card == null) {
            throw new IllegalArgumentException(NULL_CARD);
        }

        return cards.remove(card);
    }

    @Override
    public Card find(String name) {
        for (Card card : cards) {
            if (card.getName().equals(name)) {
                return card;
            }
        }

        return null;
    }
}
