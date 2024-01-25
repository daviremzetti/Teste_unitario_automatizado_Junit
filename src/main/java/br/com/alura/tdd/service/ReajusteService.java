
package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author davi_
 */
public class ReajusteService {
    
    public BigDecimal reajustar(Funcionario funcionario, Desempenho desempenho){
        BigDecimal reajuste = funcionario.getSalario().multiply(desempenho.percentual());
        BigDecimal novoSalario = funcionario.getSalario().add(reajuste);
        return novoSalario.setScale(2, RoundingMode.HALF_UP);
    }
}
