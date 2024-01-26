
package br.com.alura.tdd.service;

import davi.testesUnitarios.service.BonusService;
import davi.testesUnitarios.modelo.Funcionario;
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
public class BonusServiceTest {
    
    private Funcionario funcionario = null;
    private static BonusService instance;
    
    public BonusServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new BonusService();
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
     * Test of calcularBonus method, of class BonusService.
     */
    @Test
    public void testCalcularBonus() {
        funcionario = new Funcionario();
        funcionario.setNome("Fulano");
        funcionario.setDataAdmissao(LocalDate.now());
        funcionario.setSalario(new BigDecimal("2500.00"));
        BigDecimal expResult = new BigDecimal("250.00");
        BigDecimal result = instance.calcularBonus(funcionario);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("Teste de bônus falhou.");
    }
    
    @Test
    public void testCalcularBonusZerado() {
        System.out.println("calcularBonusZerado");
        funcionario = new Funcionario();
        funcionario.setNome("Fulano");
        funcionario.setDataAdmissao(LocalDate.now());
        funcionario.setSalario(new BigDecimal("25000.00"));
        //primeira maneira
        //assertThrows(IllegalArgumentException.class, () -> instance.calcularBonus(funcionario));
        //segunda maneira]
        try{
            instance.calcularBonus(funcionario);
            fail("Não deu exception");
        }catch(Exception e){
            assertEquals("Funcionário com salário de mais de R$10.000,00 não pode receber bônus", e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("Teste de bônus falhou.");
    }
}
