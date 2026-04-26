
package gal.uvigo.esei.aed1.cubirds.core;

import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.list.LinkedList;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    // Añadimos una carta a la mano del jugador
     
    //CORRECION: modificar para que se coloque donde la especie de pajaro
    public void addCard(Card c) {
        boolean added=false;
        for (int i=0; i<hand.size();i++) {

            if ((hand.get(i).getTypeBird()).equals(c.getTypeBird())) {
                hand.add(i, c);
                added=true;
            }
            if (added==true){break;}
           
        }
        if (added==false){hand.addLast(c);}
        
    }

    // Devolvemos el nombre del jugador
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ");

        for (Card c : hand) {
            sb.append(c);
        }

        return sb.toString();
    }
}
