package com.pucrs.mars;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pucrs.mars.exception.InvalidPositionExcpetion;

public class PlateuTest {

	Plateau plateau;
	static final int PLATEAU_X = 5;
	static final int PLATEAU_Y = 5;

	@Before
	public void setUp() throws InvalidPositionExcpetion {
		plateau = new Plateau(PLATEAU_X, PLATEAU_Y);
	}

	@Test(expected = InvalidPositionExcpetion.class)
	public void testInvalidXaxisPlateuInput() throws InvalidPositionExcpetion {
		new Plateau(-1, PLATEAU_Y);
	}

	@Test(expected = InvalidPositionExcpetion.class)
	public void testInvalidYaxisPlateuInput() throws InvalidPositionExcpetion {
		new Plateau(PLATEAU_X, -1);
	}

	@Test(expected = InvalidPositionExcpetion.class)
	public void testInvalidPlateuInput() throws InvalidPositionExcpetion {
		new Plateau(-1, -1);
	}

	@Test
	public void testMovePosibilitieValidTile() throws InvalidPositionExcpetion {
		Position to = new Position(PLATEAU_X, PLATEAU_Y);
		assertTrue(plateau.canMoveTo(to));
	}

	@Test
	public void testMovePosibilitieInvalidTileY() throws InvalidPositionExcpetion {
		Position to = new Position(PLATEAU_X, PLATEAU_Y + 1);
		assertFalse(plateau.canMoveTo(to));
	}

	@Test
	public void testMovePosibilitieInvalidTileX() throws InvalidPositionExcpetion {
		Position to = new Position(PLATEAU_X + 1, PLATEAU_Y);
		assertFalse(plateau.canMoveTo(to));
	}

	@Test
	public void testMovePosibilitieInvalidTile() throws InvalidPositionExcpetion {
		Position to = new Position(PLATEAU_X + 1, PLATEAU_Y + 1);
		assertFalse(plateau.canMoveTo(to));
	}

}
