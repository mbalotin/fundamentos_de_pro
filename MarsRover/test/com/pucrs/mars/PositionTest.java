package com.pucrs.mars;

import org.junit.Test;

import com.pucrs.mars.exception.InvalidPositionExcpetion;

public class PositionTest {

	@Test(expected = InvalidPositionExcpetion.class)
	public void negativePositionXaxisTest() throws InvalidPositionExcpetion {
		new Position(-1, 0);
	}

	@Test(expected = InvalidPositionExcpetion.class)
	public void negativePositionYaxisTest() throws InvalidPositionExcpetion {
		new Position(0, -1);
	}

	@Test(expected = InvalidPositionExcpetion.class)
	public void negativePositionTest() throws InvalidPositionExcpetion {
		new Position(-1, -1);
	}
}
