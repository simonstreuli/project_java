package src.main.java.game;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private String name;
    private int length;
    private List<Cell> position;
    private boolean sunk;

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.position = new ArrayList<>();
        this.sunk = false;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void addPosition(Cell cell) {
        this.position.add(cell);
    }

    public List<Cell> getPosition() {
        return position;
    }

    public boolean isSunk() {
        for (Cell cell : position) {
            if (!cell.isHit()) {
                return false;
            }
        }
        sunk = true;
        return true;
    }

    public boolean isSunkStatus() {
        return sunk;
    }
}
