package com.example.toyRobotChallenge.game;

public class ToyRobot {

    private Position position;

    public ToyRobot() {
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean rotateLeft() {
        this.position.facing = this.position.facing.rotate(-1);
        return true;
    }

    public boolean rotateRight() {
        this.position.facing = this.position.facing.rotate(1);
        return true;
    }
}
