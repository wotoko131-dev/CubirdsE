
package gal.uvigo.esei.aed1.cubirds.core;

import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.list.LinkedList;

public class Table {

    private List<List<Card>> rows;

    public Table() {
        rows = new LinkedList<>();
    }

    // Añadimos una fila nueva a la mesa
     
    public void addRow(List<Card> row) {
        rows.addLast(row);
    }

    public void createTableRows(DeckOfCards deck) {
        for (int i = 0; i < 4; i++) {

            List<Card> row = new LinkedList<>();

            while (row.size() < 3) {
                Card c = deck.drawCard();
                boolean repeated = false;

                for (Card inRow : row) {
                    if (inRow.getTypeBird() == c.getTypeBird()) {
                        repeated = true;
                        break;
                    }
                }

                if (!repeated) {

                    row.addLast(c);
                } else {
                    deck.addToBottom(c);
                }
            }
            addRow(row);
        }
    }

    public boolean tableGameTurn(int selectedRow, int direction, Player player, int cardPosition){
        List<Card> used= player.playTypeBird(cardPosition);
        int insertedCards= used.size();
        int originalSize=rows.get(selectedRow).size();
        TypeBird birdSelected= used.getFirst().getTypeBird();
        int referenceCounter = -1;

        for (int i = 0; i <originalSize; i++) {
            if (rows.get(selectedRow).get(i).getTypeBird().equals(birdSelected)) {
                referenceCounter = i;
                break;
            }
        }
        boolean sandwich = (referenceCounter != -1);

        
        if (direction==0){
            while (!used.isEmpty()){
                rows.get(selectedRow).addFirst(used.removeFirst());
                
            }
            
            if (sandwich) {
                int toPick = referenceCounter + insertedCards + 1;

                
                int rowSize = rows.get(selectedRow).size();
                toPick = Math.min(toPick, rowSize);

                while (toPick > 0) {
                    player.addCard(rows.get(selectedRow).removeFirst());
                    toPick--;
                }
            }

        }

        if (direction==1){
            while (!used.isEmpty()){
                rows.get(selectedRow).addLast(used.removeFirst());
            }
            if (sandwich) {
                int toPick= (originalSize - referenceCounter) + insertedCards;

                
                int rowSize = rows.get(selectedRow).size();
                toPick = Math.min(toPick, rowSize);

                while (toPick > 0) {
                    player.addCard(rows.get(selectedRow).removeLast());
                    toPick--;
                }
            }
        }

        

        return player.NoCards();
        
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;

        for (List<Card> row : rows) {
            sb.append("Fila ").append(i).append(": ");
            for (Card c : row) {
                sb.append(c);
            }
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }

    public void almacen(){
        
    }
}
