package com.exercicios.unittest.contamagica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ContaMagicaTest {

	private ContaMagica conta;
	private String NOME = "DONO_DA_CONTA";

	@Before
	public void setUp() {
		conta = new ContaMagica(NOME);
	}

	@Test
	public void testCategoriaGOLDSingleDeposit() {
		assertEquals(Categoria.SILVER, conta.getStatus());
		conta.deposito(new BigDecimal(50000));
		assertEquals(Categoria.GOLD, conta.getStatus());
	}

	@Test
	public void testCategoriaGOLDMultiDeposit() {
		for (int i = 0; i < 5; i++) {
			assertNotEquals(Categoria.GOLD, conta.getStatus());
			conta.deposito(new BigDecimal(10000));
		}
		assertEquals(Categoria.GOLD, conta.getStatus());
	}

	@Test
	public void testCategoriaPLATINUMSingleDeposit() {
		assertEquals(Categoria.SILVER, conta.getStatus());
		conta.deposito(new BigDecimal(200000));
		assertEquals(Categoria.PLATINUM, conta.getStatus());
	}

	@Test
	public void testCategoriapPLATINUMMultiDeposit() {
		for (int i = 0; i < 4; i++) {
			assertNotEquals(Categoria.PLATINUM, conta.getStatus());
			conta.deposito(new BigDecimal(50000));
		}
		assertEquals(Categoria.PLATINUM, conta.getStatus());
	}

	@Test
	public void testDowngradePLATINUMtoGOLD() throws Exception {
		conta.deposito(new BigDecimal(200000));
		assertEquals(Categoria.PLATINUM, conta.getStatus());
		conta.retirada(new BigDecimal(100000));
		assertEquals(Categoria.PLATINUM, conta.getStatus());
		conta.retirada(new BigDecimal(1));
		assertEquals(Categoria.GOLD, conta.getStatus());
	}

	@Test
	public void testDowngradePLATINUMtoSILVER() throws Exception {
		conta.deposito(new BigDecimal(200000));
		assertEquals(Categoria.PLATINUM, conta.getStatus());
		conta.retirada(new BigDecimal(190000));
		assertEquals(Categoria.GOLD, conta.getStatus());
		conta.retirada(new BigDecimal(1));
		assertEquals(Categoria.SILVER, conta.getStatus());
	}

	@Test
	public void testDowngradeGOLDtoSILVER() throws Exception {
		conta.deposito(new BigDecimal(50000));
		assertEquals(Categoria.GOLD, conta.getStatus());
		conta.retirada(new BigDecimal(25001));
		assertEquals(Categoria.SILVER, conta.getStatus());
	}

	@Test(expected = Exception.class)
	public void testSaldoInsuficiente() throws Exception {
		conta.retirada(new BigDecimal(1));
	}

	@Test
	public void testBonus() throws Exception {
		BigDecimal VALOR = new BigDecimal(500);
		conta.deposito(new BigDecimal(50000));
		BigDecimal saldo = conta.getSaldo();
		conta.deposito(VALOR);
		assertEquals(saldo.add(conta.getStatus().getBonus().multiply(VALOR)).add(VALOR), conta.getSaldo());
	}

}
