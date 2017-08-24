package com.pucrs.mars;

import com.pucrs.mars.exception.InvalidPositionExcpetion;

public class Plateau {

	private Position upperRight;

	public Plateau(int x, int y) throws InvalidPositionExcpetion {
		this.upperRight = new Position(x, y);
	}

	public boolean canMoveTo(Position to) {
		if (to.getX() <= this.upperRight.getX() && to.getY() <= this.upperRight.getY())
			return true;
		else
			return false;
	}

}
