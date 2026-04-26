
package gal.uvigo.esei.aed1.cubirds.core;

import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.list.LinkedList;
import gal.uvigo.esei.aed1.cubirds.iu.IU;

public class Game {

    private DeckOfCards deck;
    private List<Player> players;
    private Table table;
    private IU iu;

    public Game(IU iu) {
        this.iu = iu;
        this.players = new LinkedList<>();
        this.deck = new DeckOfCards();
        this.table = new Table();
    }
    //Duda: como añadir nuevas funciones al play sin que quede feo
    
    public void play() {
        //fase inicial
        loadPlayers();
        deck.shuffle();
        dealCards();
        table.createTableRows(deck);
        showState();


        
        

        //fase de juego
        gameTurns();
    }

    // Pedimos los jugadores al IU, recorremos la lista y los añadimos al juego
     
    private void loadPlayers() {
        List<Player> inputPlayers = iu.readPlayers();

        for (Player p : inputPlayers) {
            players.addLast(p);
        }
    }

    // Repartimos 8 cartas a cada jugador
     
    private void dealCards() {
        for (Player p : players) {
            for (int i = 0; i < 7; i++) {
                p.addCard(deck.drawCard());
            }
        }
    }


    // Creamos las 4 filas de la mesa con 3 especies distintas por fila
    //CORRECCION: llenar la mesa en la clase mesa
   

    // Mostramos jugadores y mesa tras la inicialización
     
    private void showState() {
        iu.displayMessage("\nJUGADORES:");
        for (Player p : players) {
            iu.displayMessage(p.toString());
        }

        iu.displayMessage("\nMESA:");
        iu.displayMessage(table.toString());
    }

    private void gameTurns(){
        boolean fin=false;
        while (fin==false) {
        
            for (Player player : players) {
                iu.displayMessage("Turno de "+ player.getName());
                int cardPosition= iu.readNumber("Elige que carta quieres jugar (jugaras todas las de la misma especie)");
                cardPosition--;

                int selectedRow=iu.readNumber("Seleccione fila para colocar");
                while (selectedRow>4||selectedRow<1){
                    System.out.println("Solo hay filas 1-4");
                    selectedRow=iu.readNumber("Seleccione fila para colocar");
                }
                selectedRow--;

                int sideRow=iu.readNumber("Seleccione 0 para izquierda, 1 para derecha");
                while (sideRow!= 0 && sideRow!=1){
                    System.out.println("Solo 0 para izquierda, 1 para derecha");
                    selectedRow=iu.readNumber("Seleccione fila para colocar");
                    sideRow=iu.readNumber("Seleccione 0 para izquierda, 1 para derecha");
                }

                

                fin=table.tableGameTurn(selectedRow, sideRow, player, cardPosition);
                
                
                if (fin){
                    iu.displayMessage("El jugador " + player.getName()+ " se quedo sin cartas");
                    break;
                }

                showState();

                
                
            }
        }
        iu.displayMessage("Un jugador se quedo si cartas. FIN");

    }

    public static void main(String[] args) {
        IU iu = new IU();
        Game game = new Game(iu);

        game.play();
    }
}
