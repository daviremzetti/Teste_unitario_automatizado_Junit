
package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davi_
 */
public class ReajusteServiceTest {
    
    private static Funcionario funcionario;
    private static ReajusteService reajuste;
    private Desempenho desempenho;
    
    public ReajusteServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        funcionario  = new Funcionario("fulano", LocalDate.now(), new BigDecimal("1000.00"));
        reajuste = new ReajusteService();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of reajustar method, of class ReajusteService.
     */
    @Test
    public void reajusteDesempenhoRuim() {
        desempenho = Desempenho.RUIM;
        assertEquals(new BigDecimal("1030.00"), reajuste.reajustar(funcionario, desempenho));
    }
    
    @Test
    public void reajusteDesempenhoBom() {
        desempenho = Desempenho.BOM;
        assertEquals(new BigDecimal("1150.00"), reajuste.reajustar(funcionario, desempenho));
    }
    
    @Test
    public void reajusteDesempenhoExcelente() {
        desempenho = Desempenho.EXCELENTE;
        assertEquals(new BigDecimal("1200.00"), reajuste.reajustar(funcionario, desempenho));
    }
    
}
