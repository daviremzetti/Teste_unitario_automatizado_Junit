/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.alura.tdd.modelo;

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
public class FuncionarioTest {
    
    public FuncionarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of getNome method, of class Funcionario.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Funcionario instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataAdmissao method, of class Funcionario.
     */
    @Test
    public void testGetDataAdmissao() {
        System.out.println("getDataAdmissao");
        Funcionario instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getDataAdmissao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalario method, of class Funcionario.
     */
    @Test
    public void testGetSalario() {
        System.out.println("getSalario");
        Funcionario instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getSalario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
