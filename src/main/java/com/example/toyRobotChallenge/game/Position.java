package com.example.toyRobotChallenge.game;

public class Position {
    int x;
    int y;
    Facing facing;

    public Position(int x, int y, Facing facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.facing = position.getFacing();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Facing getFacing() {
        return this.facing;
    }

    public Position movePosition() {
        Position newPosition = new Position(this);
        switch (this.facing) {
            case NORTH:
                newPosition.changePosition(0, 1);
                break;
            case EAST:
                newPosition.changePosition(1, 0);
                break;
            case SOUTH:
                newPosition.changePosition(0, -1);
                break;
            case WEST:
                newPosition.changePosition(-1, 0);
                break;
        }
        return newPosition;
    }

    public void changePosition(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }
}
