package com.example.toyRobotChallenge;

import com.example.toyRobotChallenge.game.Game;
import com.example.toyRobotChallenge.game.TableTop;
import com.example.toyRobotChallenge.game.ToyRobot;
import java.util.Scanner;

public class ToyRobotChallengeApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//define tabletop of 5 x 5
		TableTop tableTop = new TableTop(5, 5);
		ToyRobot robot = new ToyRobot();
		Game game = new Game(tableTop, robot);

		System.out.println("Toy Robot");
		System.out.println("Please enter following commands as below:");
		System.out.println("PLACE X,Y,NORTH|EAST|SOUTH|WEST");
		System.out.println("MOVE, LEFT, RIGHT, REPORT or EXIT");

		boolean move = true;
		while (move) {
			//taking input command from command line
			String command = scanner.nextLine();
			if ("STOP".equals(command)) {
				move = false;
			} else {
				try {
					String output = game.play(command);
					System.out.println(output);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
