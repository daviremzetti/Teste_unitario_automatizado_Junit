
package br.com.alura.tdd.service;

import davi.testesUnitarios.service.ReajusteService;
import davi.testesUnitarios.modelo.Desempenho;
import davi.testesUnitarios.modelo.Funcionario;
import davi.testesUnitarios.persistencia.FuncionarioDAO;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


/**
 *
 * @author davi_
 */
public class ReajusteServiceTest {
    
    @Mock
    private static FuncionarioDAO daoMock;
    private Funcionario funcionario;
    private static ReajusteService reajuste;
    private Desempenho desempenho;
    
    public ReajusteServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        funcionario  = new Funcionario();
        funcionario.setNome("fulano");
        funcionario.setDataAdmissao(LocalDate.now());
        funcionario.setSalario(new BigDecimal("1000.00"));
        MockitoAnnotations.openMocks(this);
        reajuste = new ReajusteService(daoMock);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of reajustar method, of class ReajusteService.
     */
    @Test
    public void reajusteDesempenhoRuim() throws Exception {
        desempenho = Desempenho.RUIM;
        Mockito.when(daoMock.buscarFuncionario(funcionario)).thenReturn(funcionario);
        Mockito.when(daoMock.atualizarSalario(funcionario)).thenReturn(funcionario);
        BigDecimal novoSalario = new BigDecimal("1030.00");
        String resultadoObtido = reajuste.reajustar(funcionario, desempenho);
        String resultadoEsperado = "Salário do funcionário " + funcionario.getNome() + " reajustado com sucesso para " + novoSalario;
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void reajusteDesempenhoBom() throws Exception {
        desempenho = Desempenho.BOM;
        Mockito.when(daoMock.buscarFuncionario(funcionario)).thenReturn(funcionario);
        Mockito.when(daoMock.atualizarSalario(funcionario)).thenReturn(funcionario);
        BigDecimal novoSalario = new BigDecimal("1150.00");
        assertEquals("Salário do funcionário " + funcionario.getNome() + " reajustado com sucesso para " + novoSalario, reajuste.reajustar(funcionario, desempenho));
    }
    
    @Test
    public void reajusteDesempenhoExcelente() throws Exception {
        desempenho = Desempenho.EXCELENTE;
        Mockito.when(daoMock.buscarFuncionario(funcionario)).thenReturn(funcionario);
        Mockito.when(daoMock.atualizarSalario(funcionario)).thenReturn(funcionario);
        BigDecimal novoSalario = new BigDecimal("1200.00");
        assertEquals("Salário do funcionário " + funcionario.getNome() + " reajustado com sucesso para " + novoSalario, reajuste.reajustar(funcionario, desempenho));
    }
    
}
