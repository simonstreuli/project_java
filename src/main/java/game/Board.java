package src.main.java.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private Cell[][] grid;
    private List<Ship> ships;

    public Board() {
        this.ships = new ArrayList<>();
        grid = new Cell[10][10];
        for (char row = 0; row < 10; row++) {
            char rowChar = (char) ('A' + row);
            for (int column = 0; column < 10; column++) {
                grid[row][column] = new Cell(rowChar, column + 1);
            }
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void placeRandomShip(Ship ship) {
        Random random = new Random();
        boolean placed = false;
        while (!placed) { // bracke point
            boolean horizontal = random.nextBoolean();
            int row = random.nextInt(10 - ship.getLength());
            int column = random.nextInt(10 - ship.getLength());
            placed = this.placeShip(ship, row, column, horizontal);
        }
    }

    public boolean placeShip(Ship ship, int row, int column, boolean horizontal) {
        if (canPlaceShip(row, column, ship.getLength(), horizontal)) {
            for (int i = 0; i < ship.getLength(); i++) {
                Cell cell;
                if (horizontal) {
                    cell = grid[row][column + i];
                } else {
                    cell = grid[row + i][column];
                }
                cell.setOccupied(true);
                ship.addPosition(cell);
            }
            ships.add(ship);
            return true; // bracke point
        }
        return false; // bracke point
    }

    private boolean canPlaceShip(int row, int column, int length, boolean horizontal) {
        for (int i = 0; i < length; i++) {
            if (horizontal) {
                if (grid[row][column + i].isOccupied()) {
                    return false;
                }
            } else {
                if (grid[row][column + i].isOccupied()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean attackCell(int row, int column) {
        if (grid[row][column].isOccupied()) {
            grid[row][column].setHit(true);
            return true;
        } else {
            grid[row][column].setHit(false);
            grid[row][column].setMiss(true);
            return false;
        }
    }

    public void printBoard() {
        System.out.println("Aktuelles Board: ");
        System.out.println(" ");
        this.playBoard();

    }

    public void playBoard() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(" ");
            System.out.print(i + "");
        }
        System.out.println();

        for (int row = 0; row < 10; row++) {
            System.out.print((char) ('A' + row) + " ");
            for (int column = 0; column < 10; column++) {
                System.out.print(grid[row][column].toString() + " ");
            }
            System.out.println();
        }
    }

    public boolean allShipsSunk() {
        return ships.stream().allMatch(Ship::isSunk);
    }

    public List<Ship> getShips() {
        return ships;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 1; i <= 10; i++) {
            s += " ";
            s += (i + "");
        }
        s += "\n";

        for (int row = 0; row < 10; row++) {
            s += ((char) ('A' + row) + " ");
            for (int column = 0; column < 10; column++) {
                s += grid[row][column].toString() + " ";
            }
            s += "\n";
        }
        return s;
    }
}
