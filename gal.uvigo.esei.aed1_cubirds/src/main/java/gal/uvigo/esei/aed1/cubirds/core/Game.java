package gal.uvigo.esei.aed1.cubirds.core;

import java.util.ArrayList;
import java.util.Collections;


import gal.uvigo.esei.aed1.cubirds.iu.IU;

public class Game {
    

    public Game(IU iu) {
        
        ArrayList<Player> players = new ArrayList<>();

        int numJugadores;

        // Pedir número válido
        numJugadores = iu.readNumber("Numero de jugadores (2-5)");

        while (numJugadores < 2 || numJugadores > 5){
            numJugadores = iu.readNumber("Numero fuera de rango. Vuelve a ingresar numero de jugadores (2-5)");
        } 

        

        // Crear jugadores
        for (int i = 0; i < numJugadores; i++) {
            String nombre = iu.readString("Nombre del jugador "+ (i+1)+ ": ");
            players.add(new Player(nombre));
        }

        // Crear la baraja
        DeckOfCards deck = new DeckOfCards();

        // Barajar
        Collections.shuffle(deck.getCards());

        // Repartir
        for (Player p : players) {
            for (int i = 0; i < 8; i++) {
                Card carta = deck.getCards().removeFirst();
                p.getHand().add(carta);
            }
        }

        // Ordenar por especie
        for (Player p : players) {
            p.getHand().sort((c1, c2) ->
                c1.getTypeBird().compareTo(c2.getTypeBird())
            );
        }

        // Crear mesa
        Table table = new Table();

        // Crear filas
        for (int i = 0; i < 4; i++) {

            ArrayList<Card> fila = new ArrayList<>();

            while (fila.size() < 3) {

                Card carta = deck.getCards().removeFirst();

                boolean repetida = false;

                for (Card c : fila) {
                    if (c.getTypeBird() == carta.getTypeBird()) {
                        repetida = true;
                        break;
                    }
                }

                if (!repetida) {
                    fila.add(carta);
                } else {
                    deck.getCards().add(carta);
                }
            }

            table.getRows().add(fila);
        }

        // Mostrar jugadores
        System.out.println("\nJUGADORES:");
        for (Player p : players) {
            System.out.println(p.getName() + ": " + p.getHand());
        }

        // Mostrar mesa
        System.out.println("\nMESA:");
        int numFila = 1;
        for (ArrayList<Card> fila : table.getRows()) {
            System.out.println("Fila " + numFila + ": " + fila);
            numFila++;
        }

        System.out.println("\nCartas restantes: " + deck.getCards().size());
    }

    public void play() {}
}