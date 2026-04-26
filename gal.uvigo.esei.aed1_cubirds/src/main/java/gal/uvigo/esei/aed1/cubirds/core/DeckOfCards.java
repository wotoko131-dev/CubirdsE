
package gal.uvigo.esei.aed1.cubirds.core;

import es.uvigo.esei.aed1.tads.queue.Queue;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.list.LinkedList;

public class DeckOfCards {

    private Queue<Card> cards;

    public DeckOfCards() {
        cards = new LinkedQueue<>();
        for (Card c : Card.values()) {
            cards.add(c);
        }
    }

    // Extraemos la primera carta de la baraja   
    public Card drawCard() {
        return cards.remove();
    }

    // Añadimos una carta al fondo de la baraja   
    public void addToBottom(Card c) {
        cards.add(c);
    }

    //Barajamos   
    public void shuffle() {
        List<Card> auxiliary = new LinkedList<>();

        // Pasamos todas las cartas a una lista auxiliar
        while (!cards.isEmpty()) {
            auxiliary.addLast(cards.remove());
        }

        // Reinsertamos las cartas aleatoriamente
        while (!auxiliary.isEmpty()) {
            int index = (int) (Math.random() * auxiliary.size());
            cards.add(auxiliary.remove(index));
        }
    }

    public int size() {
        return cards.size();
    }
}
