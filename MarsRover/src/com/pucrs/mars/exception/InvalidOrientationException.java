package com.pucrs.mars.exception;

public class InvalidOrientationException extends Exception {

	private String orientation;

	public InvalidOrientationException(String orientation) {
		this.orientation = orientation;
	}

	@Override
	public String getMessage() {
		return String.format("Invalid Orientation [%s]", orientation);
	}

}
