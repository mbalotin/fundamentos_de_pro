package com.pucrs.mars.control;

import com.pucrs.mars.exception.InvalidOrientationException;

public enum Orientation {
	NORTH, SOUTH, EAST, WEST;

	@Override
	public String toString() {
		return String.valueOf(super.toString().charAt(0));
	}

	public static Orientation fromString(String string) throws InvalidOrientationException {
		for (int i = 0; i < values().length; i++) {
			if (values()[i].toString().equalsIgnoreCase(string))
				return values()[i];
		}
		throw new InvalidOrientationException(string);
	}

}
