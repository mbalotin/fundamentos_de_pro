package com.pucrs.mars.exception;

import com.pucrs.mars.control.RoverCommand;

public class UnsupportedRoverCommandException extends Exception {

	private RoverCommand command;
	private String input;

	public UnsupportedRoverCommandException(RoverCommand command) {
		this.command = command;
	}

	public UnsupportedRoverCommandException(String inputCommand) {
		this.input = inputCommand;
	}

	@Override
	public String getMessage() {
		return String.format("Unsupporte Rover Command [%s]", (command != null) ? command : input);
	}

}
