package src.main.java.game;

public class Cell {

    private char row;
    private int column;
    public boolean occupied;
    public boolean hit;
    public boolean miss;

    public Cell(char row, int column) {
        this.row = row;
        this.column = column;
        this.occupied = false;
        this.hit = false;
        this.miss = false;
    }

    public char getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean isMiss() {
        return miss;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setMiss(boolean miss) {
        this.miss = miss;
    }

    @Override
    public String toString() {
        if (hit) {
            return "X";
        } else if (occupied) {
            return "S";
        } else if (miss) {
            return "O";
        } else {
            return ".";
        }
    }
}
