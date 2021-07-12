package com.example.toyRobotChallenge;

import com.example.toyRobotChallenge.game.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


@SpringBootTest
public class ToyRobotChallengeApplicationTests {

	final int rows = 5;
	final int columns = 5;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();


	@Test
	public void testRobotPlacing() {

		TableTop tableTop = new TableTop(rows, columns);
		ToyRobot toyRobot = new ToyRobot();
		Game game = new Game(tableTop, toyRobot);

		/** valid test cases **/
		Assert.assertEquals(game.placeToyRobot(new Position(0, 2, Facing.NORTH)),"done");
		Assert.assertEquals(game.placeToyRobot(new Position(2, 3, Facing.EAST)),"done");

		/** invalid test cases **/
		Assert.assertEquals(game.placeToyRobot(new Position(6, 6, Facing.SOUTH)),"invalid position");
		Assert.assertEquals(game.placeToyRobot(new Position(-1, -1, Facing.WEST)),"invalid position");
		Assert.assertEquals(game.placeToyRobot(new Position(1, 5, Facing.NORTH)),"invalid position");
		Assert.assertEquals(game.placeToyRobot(new Position(2, 5, Facing.SOUTH)),"invalid position");
		Assert.assertEquals(game.placeToyRobot(new Position(5, 5, Facing.EAST)),"invalid position");
	}

	//	Covering all unit tests
	@Test
	public void testGame() throws Exception {

		TableTop tableTop = new TableTop(rows, columns);
		ToyRobot toyRobot = new ToyRobot();
		Game game = new Game(tableTop, toyRobot);

		game.play("PLACE 0,0,NORTH");
		Assert.assertEquals("0,0,NORTH", game.play("REPORT"));

		/** ### Example a
		 PLACE 0,0,NORTH
		 MOVE
		 REPORT

		 Expected output:
		 0,1,NORTH **/

		game.play("PLACE 0,0,NORTH");
		game.play("MOVE");
		Assert.assertEquals("0,1,NORTH", game.play("REPORT"));

		/**
		 PLACE 0,0,NORTH
		 LEFT
		 REPORT

		 Expected output:
		 0,0,WEST **/

		game.play("PLACE 0,0,NORTH");
		game.play("LEFT");
		Assert.assertEquals("0,0,WEST", game.play("REPORT"));

		/**
		 PLACE 1,2,EAST
		 MOVE
		 MOVE
		 LEFT
		 MOVE

		 Expected output:
		 3,3,NORTH **/

		game.play("PLACE 1,2,EAST");
		game.play("MOVE");
		game.play("MOVE");
		game.play("LEFT");
		game.play("MOVE");
		Assert.assertEquals("3,3,NORTH", game.play("REPORT"));

		/** invalid test cases **/

		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage("Invalid command");
		Assert.assertEquals("Invalid command", game.play("PLACE123NORTH"));


		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage("Invalid command");
		Assert.assertEquals("Invalid command", game.play("27863whjgdhjsgf"));
	}
}