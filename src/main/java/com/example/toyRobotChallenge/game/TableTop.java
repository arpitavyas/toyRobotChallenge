package com.example.toyRobotChallenge.game;

public class TableTop {
    int rows;
    int columns;

    public TableTop(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public boolean isValidPosition(Position position) {
        if (position.getX() >= columns || position.getX() < 0 || position.getY() >= rows || position.getY() < 0) {
            return false;
        }
        return true;
    }

}
