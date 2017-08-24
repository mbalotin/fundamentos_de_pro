package com.exercicios.unittest.contamagica;

import java.math.BigDecimal;

public class ContaMagica {

	private String nome;
	private BigDecimal saldo;
	private Categoria status;

	public ContaMagica(String nome) {
		this.nome = nome;
		saldo = new BigDecimal(0);
		status = Categoria.SILVER;
	}

	public String getNomeCliente() {
		return nome;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public Categoria getStatus() {
		return status;
	}

	public void deposito(BigDecimal valor) {
		saldo = saldo.add(valor.add(valor.multiply(status.getBonus())));
		if (saldo.floatValue() >= 50000) {
			status = Categoria.GOLD;
			if (saldo.floatValue() >= 200000) {
				status = Categoria.PLATINUM;
			}
		}
	}

	public void retirada(BigDecimal valor) throws Exception {
		if (saldo.floatValue() < valor.floatValue()) {
			throw new Exception("Saldo insuficiente");
		} else {
			saldo = saldo.subtract(valor);
			if (Categoria.PLATINUM.equals(status) && saldo.floatValue() < 100000) {
				status = Categoria.GOLD;
			} else if (Categoria.GOLD.equals(status) && saldo.floatValue() < 25000) {
				status = Categoria.SILVER;
			}
		}
	}

}