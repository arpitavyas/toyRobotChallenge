package com.example.toyRobotChallenge.game;

public class Game {

    TableTop tableTop;
    ToyRobot robot;

    public Game(TableTop tableTop, ToyRobot robot) {
        this.tableTop = tableTop;
        this.robot = robot;
    }

//    check for command and evaluate move based on that
    public String play(String input) throws Exception {
        String[] array = input.split(" ");

        Command command;
        try {
            command = Command.valueOf(array[0]);
        } catch (Exception e) {
            throw new Exception("Invalid command");
        }
        if (command == Command.PLACE && array.length < 2) {
            throw new Exception("Invalid command, need x,y position and facing");
        }

        String[] initPosition;
        int x = 0;
        int y = 0;
        Facing robotFacing = null;
        if (command == Command.PLACE) {
            initPosition = array[1].split(",");
            try {
                x = Integer.parseInt(initPosition[0]);
                y = Integer.parseInt(initPosition[1]);
                robotFacing = Facing.valueOf(initPosition[2]);
            } catch (Exception e) {
                throw new Exception("Invalid command");
            }
        }

        String output;

        switch (command) {
            case PLACE:
                output = placeToyRobot(new Position(x, y, robotFacing));
                break;
            case MOVE:
                Position newPosition = moveToyRobot(robot);

                if (tableTop.isValidPosition(newPosition)) {
                    robot.setPosition(newPosition);
                    output = "done";
                } else {
                    output = "invalid position";
                }
                break;
            case LEFT:
                output = String.valueOf(robot.rotateLeft());
                break;
            case RIGHT:
                output = String.valueOf(robot.rotateRight());
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new Exception("Invalid command");
        }

        return output;
    }


    public String placeToyRobot(Position position) {

        if (!tableTop.isValidPosition(position))
            return "invalid position";

        robot.setPosition(position);
        return "done";
    }

    public Position moveToyRobot(ToyRobot robot) {
        if (robot == null || robot.getPosition() == null)
            return null;
        return robot.getPosition().movePosition();
    }

    public String report() {
        if (robot == null || robot.getPosition() == null)
            return null;

        return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," + robot.getPosition().getFacing().toString();
    }
}
