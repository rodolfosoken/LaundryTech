/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.DAO_cliente;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Rodolfo
 */
public class CadastraClienteTest {

    public CadastraClienteTest() {
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
     * Test of main method, of class CadastraCliente.
     */
    @Test
    public void testMain() {
    }

    /**
     * Test of isFinish method, of class CadastraCliente.
     */
    @Test
    public void testIsFinish() {
    }

    /**
     * Test of setFinish method, of class CadastraCliente.
     */
    @Test
    public void testSetFinish() {
    }

    @Test
    public void testCadastraCliente() throws AWTException, InterruptedException {
        CadastraCliente win = new CadastraCliente();
        win.setVisible(true);
        Robot bot = new Robot();
        bot.keyPress(KeyEvent.VK_4);
        Thread.sleep(250);
        bot.keyRelease(KeyEvent.VK_5);
        Thread.sleep(250);
        bot.keyPress(KeyEvent.VK_6);
        Thread.sleep(250);
        bot.keyRelease(KeyEvent.VK_6);
        Thread.sleep(1000);
        
        //clique de finalização
        bot.mouseMove(510, 350);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(250);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(250);
        bot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(250);
        bot.keyRelease(KeyEvent.VK_ENTER);
        
        
        DAO_cliente dao = new DAO_cliente();
        
        //consulta se o cliente foi cadastrado
        boolean result = dao.consultaCliente(46123);
        boolean resultExpected = true;
        assertEquals(resultExpected, result);
        
        //exclui cliente cadastrado
        boolean result2 = dao.excluiCliente(46123);
        boolean resultExpected2 = false;
        assertEquals(resultExpected2, result2);

    }
}
