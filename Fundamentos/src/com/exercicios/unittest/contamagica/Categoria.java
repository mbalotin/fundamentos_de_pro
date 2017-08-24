package com.exercicios.unittest.contamagica;

import java.math.BigDecimal;

public enum Categoria {
	SILVER(new BigDecimal(0)), GOLD(new BigDecimal(0.01)), PLATINUM(new BigDecimal(0.025));

	private BigDecimal bonus;

	public BigDecimal getBonus() {
		return bonus;
	}

	private Categoria(BigDecimal bonus) {
		this.bonus = bonus;
	}

}
