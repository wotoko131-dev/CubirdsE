
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

    public int seleccionarCarta(Player player){
        this.displayMessage("Turno de "+ player.getName());
        int cardPosition= this.readNumber("Escribe la posicion de la carta (1 es más izquierda,jugaras todas las de la misma especie) ");
        while(cardPosition-1<0||cardPosition>player.getNumCartasMano()){
            cardPosition= this.readNumber("No existe esa posición en tu mano, prueba otro valor (1 mas izquierda, juegas toda la especie) ");
        }
        
        return (cardPosition-1);
    }

    public int seleccionarRow(){
        int selectedRow=this.readNumber("Seleccione fila para colocar ");
        while (selectedRow>4||selectedRow<1){
            System.out.println("Solo hay filas 1-4 ");
            selectedRow=this.readNumber("Seleccione fila para colocar ");
        }
        return (selectedRow-1);
    }

    public int seleccionarLado(){
        int sideRow=this.readNumber("Seleccione 0 para izquierda, 1 para derecha ");
        while (sideRow!= 0 && sideRow!=1){
            System.out.println("Solo 0 para izquierda, 1 para derecha ");
            sideRow=this.readNumber("Seleccione 0 para izquierda, 1 para derecha ");
        }
        return sideRow;
    }
     
    

}
