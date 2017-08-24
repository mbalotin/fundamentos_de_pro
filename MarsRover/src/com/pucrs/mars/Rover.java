package com.pucrs.mars;

import java.util.List;

import com.pucrs.mars.control.Orientation;
import com.pucrs.mars.control.RoverCommand;
import com.pucrs.mars.exception.InvalidPositionExcpetion;
import com.pucrs.mars.exception.UnableToMoveException;
import com.pucrs.mars.exception.UnsupportedRoverCommandException;

public class Rover {

	private Position position;
	private Orientation orientation;

	public Rover(int x, int y, Orientation orientation) throws InvalidPositionExcpetion {
		this.position = new Position(x, y);
		this.orientation = orientation;
	}

	protected void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	protected Orientation getOrientation() {
		return this.orientation;
	}

	/**
	 * Moves the {@link Rover} on a specific {@link Plateau}
	 * 
	 * @param on
	 *            {@link Plateau} to move on
	 * @throws UnableToMoveException
	 *             if the result {@link Position} of the {@link Rover} is invalid.
	 */
	protected void move(Plateau on) throws UnableToMoveException {

		if (Orientation.NORTH.equals(orientation))
			position.setY(position.getY() + 1);
		else if (Orientation.SOUTH.equals(orientation))
			position.setY(position.getY() - 1);
		else if (Orientation.EAST.equals(orientation))
			position.setX(position.getX() + 1);
		else if (Orientation.WEST.equals(orientation))
			position.setX(position.getX() - 1);
		if (!on.canMoveTo(this.position))
			throw new UnableToMoveException();
	}

	/**
	 * Execute a sequence of commands.
	 * 
	 * @param commands
	 *            a sequence of {@link RoverCommand} to be executed.
	 * 
	 * @param landToExplore
	 *            {@link Plateau} to move explore
	 * @throws UnableToMoveException
	 */
	public void explore(List<RoverCommand> commands, Plateau landToExplore)
			throws UnableToMoveException, UnsupportedRoverCommandException {
		for (RoverCommand command : commands) {
			if (RoverCommand.MOVE.equals(command))
				move(landToExplore);
			else if (RoverCommand.TURN_LEFT.equals(command))
				turnLeft();
			else if (RoverCommand.TURN_RIGHT.equals(command))
				turnRight();
			else
				throw new UnsupportedRoverCommandException(command);
		}
	}

	/**
	 * returns a String containing the {@link Rover} current position in the format
	 * [ x y o], where x and y are the current position and "o" is the
	 * {@link Orientation}.
	 */
	public String currentStatus() {
		return position.toString() + " " + orientation.toString();
	}

	/**
	 * Change the {@link Rover} orientation to the left
	 */
	protected void turnLeft() {
		if (Orientation.NORTH.equals(orientation))
			orientation = Orientation.WEST;
		else if (Orientation.SOUTH.equals(orientation))
			orientation = Orientation.EAST;
		else if (Orientation.EAST.equals(orientation))
			orientation = Orientation.NORTH;
		else if (Orientation.WEST.equals(orientation))
			orientation = Orientation.SOUTH;
	}

	/**
	 * 
	 * Change the {@link Rover} orientation to the right.
	 */
	protected void turnRight() {
		if (Orientation.NORTH.equals(orientation))
			orientation = Orientation.EAST;
		else if (Orientation.SOUTH.equals(orientation))
			orientation = Orientation.WEST;
		else if (Orientation.EAST.equals(orientation))
			orientation = Orientation.SOUTH;
		else if (Orientation.WEST.equals(orientation))
			orientation = Orientation.NORTH;

	}

}
