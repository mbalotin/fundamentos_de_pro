package com.pucrs.mars;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pucrs.mars.control.Orientation;
import com.pucrs.mars.exception.InvalidPositionExcpetion;

public class RoverTest {

	Rover rover;
	static final int ROVER_X = 0;
	static final int ROVER_Y = 0;
	static final Orientation ROVER_ORIENTATION= Orientation.NORTH;
	
	@Before
	public void setUp() throws InvalidPositionExcpetion {
		rover = new Rover(ROVER_X, ROVER_Y, ROVER_ORIENTATION);
	}
	
	@Test
	public void testTurnLeftNORTH() {
		rover.setOrientation(Orientation.NORTH);
		rover.turnLeft();
		assertEquals(Orientation.WEST, rover.getOrientation());
	}

	@Test
	public void testTurnLeftEAST() {
		rover.setOrientation(Orientation.EAST);
		rover.turnLeft();
		assertEquals(Orientation.NORTH, rover.getOrientation());
	}
	@Test
	public void testTurnLeftWEST() {
		rover.setOrientation(Orientation.WEST);
		rover.turnLeft();
		assertEquals(Orientation.SOUTH, rover.getOrientation());
	}

	@Test
	public void testTurnLeftSOUTH() {
		rover.setOrientation(Orientation.SOUTH);
		rover.turnLeft();
		assertEquals(Orientation.EAST, rover.getOrientation());
	}
	
	@Test
	public void testTurnRightNorth() {
		rover.setOrientation(Orientation.NORTH);
		rover.turnRight();
		assertEquals(Orientation.EAST, rover.getOrientation());
	}

	@Test
	public void testTurnRightSOUTH() {
		rover.setOrientation(Orientation.SOUTH);
		rover.turnRight();
		assertEquals(Orientation.WEST, rover.getOrientation());
	}

	@Test
	public void testTurnRightWEST() {
		rover.setOrientation(Orientation.WEST);
		rover.turnRight();
		assertEquals(Orientation.NORTH, rover.getOrientation());
	}

	@Test
	public void testTurnRightEAST() {
		rover.setOrientation(Orientation.EAST);
		rover.turnRight();
		assertEquals(Orientation.SOUTH, rover.getOrientation());
	}

	
}
