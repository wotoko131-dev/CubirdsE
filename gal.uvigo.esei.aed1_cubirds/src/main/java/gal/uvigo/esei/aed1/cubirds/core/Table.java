package gal.uvigo.esei.aed1.cubirds.core;

import java.util.ArrayList;

public class Table {
    private ArrayList<ArrayList<Card>> rows;

    public Table() {
        rows = new ArrayList<>();
    }

    public ArrayList<ArrayList<Card>> getRows() { return rows; }
}