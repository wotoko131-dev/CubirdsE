
package gal.uvigo.esei.aed1.cubirds.iu;

import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.list.LinkedList;
import gal.uvigo.esei.aed1.cubirds.core.Player;

import java.util.Scanner;

public class IU {

    private final Scanner keyboard;

    public IU() {
        keyboard = new Scanner(System.in);
    }

    public int readNumber(String msg) {
        boolean repeat;
        int toret = 0;

        do {
            repeat = false;
            System.out.print(msg);
            try {

                toret = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException exc) {
                repeat = true;
            }
        } while (repeat);

        return toret;
    }

    public String readString(String msg) {
        System.out.print(msg);
        return keyboard.nextLine();
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    // Pedimos un número válido de jugadores (2-5),
    // Pedimos los nombres y creamos la lista de jugadores
     
    public List<Player> readPlayers() {
        List<Player> players = new LinkedList<>();

        int numPlayers;

        do {
            numPlayers = readNumber("Número de jugadores (2-5): ");
        } while (numPlayers < 2 || numPlayers > 5);

        for (int i = 0; i < numPlayers; i++) {
            String name = readString("Nombre del jugador " + (i + 1) + ": ");
            players.addLast(new Player(name));
        }

        return players;
    }
}
