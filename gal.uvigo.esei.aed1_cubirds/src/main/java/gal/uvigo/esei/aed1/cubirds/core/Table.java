
package gal.uvigo.esei.aed1.cubirds.core;

import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.list.LinkedList;

public class Table {

    private List<List<Card>> rows;

    public Table() {
        rows = new LinkedList<>();

        // En la posición 0 hay una lista vacía
        rows.addLast(new LinkedList<Card>());
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
}
