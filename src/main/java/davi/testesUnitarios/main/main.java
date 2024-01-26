
package davi.testesUnitarios.main;

import davi.testesUnitarios.modelo.Desempenho;
import davi.testesUnitarios.modelo.Funcionario;
import davi.testesUnitarios.persistencia.FuncionarioDAO;
import davi.testesUnitarios.service.ReajusteService;

/**
 *
 * @author davi_
 */
public class main {
     public static void main(String[] args) {
        Funcionario func = new Funcionario();
        func.setId(3);
        Desempenho desempenho = Desempenho.EXCELENTE;
        ReajusteService service = new ReajusteService(new FuncionarioDAO());
        try{
            String cadastrado = service.reajustar(func, desempenho);
            System.out.println(cadastrado);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
