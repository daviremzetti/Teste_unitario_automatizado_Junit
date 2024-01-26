package davi.testesUnitarios.service;

import java.math.BigDecimal;

import davi.testesUnitarios.modelo.Funcionario;
import java.math.RoundingMode;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			//valor = BigDecimal.ZERO;
                        throw new IllegalArgumentException("Funcionário com salário de mais de R$10.000,00 não pode receber bônus");
		}
                //até duas casas decimais arredondando pra cima se a segunda casa decimal for maior ou igual a 5
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
