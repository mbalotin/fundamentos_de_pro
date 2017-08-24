package com.pucrs.mars.exception;

public class InvalidPositionExcpetion extends Exception {

	private final int x, y;

	public InvalidPositionExcpetion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String getMessage() {
		return String.format("Invalid position < %d , %d >", x, y);
	}

}
