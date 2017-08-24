package com.pucrs.mars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pucrs.mars.control.Orientation;
import com.pucrs.mars.control.RoverCommand;
import com.pucrs.mars.exception.InvalidOrientationException;
import com.pucrs.mars.exception.InvalidPositionExcpetion;
import com.pucrs.mars.exception.UnableToMoveException;
import com.pucrs.mars.exception.UnsupportedRoverCommandException;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--- Mars Rover System ---");

		System.out.print("Input the Plateu size [ N N ] :");
		String input = scanner.nextLine();
		String[] inputArgs = input.split(" ");
		int x = Integer.valueOf(inputArgs[0]);
		int y = Integer.valueOf(inputArgs[1]);

		Plateau plateau;
		try {
			plateau = new Plateau(x, y);
		} catch (InvalidPositionExcpetion ex) {
			ex.printStackTrace();
			return;
		}
		while (true) {
			try {
				System.out.print("Input the Rover original orientation [ N N O ], or EMPTY to exit :");
				input = scanner.nextLine();
				if (input.isEmpty()) {
					System.out.print("MarsRover commands finished");
					return;
				}
				inputArgs = input.split(" ");
				x = Integer.valueOf(inputArgs[0]);
				y = Integer.valueOf(inputArgs[1]);
				Rover rover = new Rover(x, y, Orientation.fromString(inputArgs[2]));

				System.out.print("Input the sequence of exploratory commands [ C .. C ]:");
				input = scanner.nextLine();
				rover.explore(toRoverCommands(input), plateau);

				System.out.printf("Rover Exploration finished, Rover output: %s\n\n", rover.currentStatus());
			} catch (InvalidOrientationException | InvalidPositionExcpetion | UnableToMoveException
					| UnsupportedRoverCommandException e) {
				e.printStackTrace();
				return;
			}
		}

	}

	private static List<RoverCommand> toRoverCommands(String input) throws UnsupportedRoverCommandException {
		List<RoverCommand> commands = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			String inputCommand = String.valueOf(input.charAt(i));
			if ("M".equalsIgnoreCase(inputCommand))
				commands.add(RoverCommand.MOVE);
			else if ("L".equalsIgnoreCase(inputCommand))
				commands.add(RoverCommand.TURN_LEFT);
			else if ("R".equalsIgnoreCase(inputCommand))
				commands.add(RoverCommand.TURN_RIGHT);
			else
				throw new UnsupportedRoverCommandException(inputCommand);
		}
		return commands;
	}

}
