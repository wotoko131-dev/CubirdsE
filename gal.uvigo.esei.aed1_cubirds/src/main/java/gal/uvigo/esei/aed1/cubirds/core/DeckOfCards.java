package gal.uvigo.esei.aed1.cubirds.core;

import java.util.ArrayList;

public class DeckOfCards {
    private ArrayList<Card> cards;

    public DeckOfCards() {
        cards = new ArrayList<>();
        for (Card c : Card.values()) {
            cards.add(c);
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}