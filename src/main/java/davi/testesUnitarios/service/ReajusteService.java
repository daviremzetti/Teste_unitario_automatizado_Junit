
package davi.testesUnitarios.service;

import davi.testesUnitarios.modelo.Desempenho;
import davi.testesUnitarios.modelo.Funcionario;
import davi.testesUnitarios.persistencia.FuncionarioDAO;
import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 *
 * @author davi_
 */
public class ReajusteService {
    
    private final FuncionarioDAO dao;
    
    public ReajusteService(FuncionarioDAO dao){
        this.dao = dao;
    }
    
    public boolean salvarFuncionario(Funcionario funcionario){
        return dao.cadastrarFuncionario(funcionario);
    }
    
    public String reajustar(Funcionario funcionario, Desempenho desempenho) throws Exception{
        Funcionario func = dao.buscarFuncionario(funcionario);
        if(func != null){
            BigDecimal reajuste = func.getSalario().multiply(desempenho.percentual());
            BigDecimal novoSalario = func.getSalario().add(reajuste);
            func.setSalario(novoSalario);
            Funcionario cadastrado = dao.atualizarSalario(func);
            return "Salário do funcionário " + cadastrado.getNome() + " reajustado com sucesso para " + cadastrado.getSalario().setScale(2, RoundingMode.HALF_UP);
        }else{
            throw new Exception("Salário não reajustado. Funcionário inexistente");
        }
            
    }
}
