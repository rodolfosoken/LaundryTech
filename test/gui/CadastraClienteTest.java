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
        int t = 30; // tempo entre pressionar e soltar teclas

        //digita telefone
        int[] digita = {KeyEvent.VK_DELETE, KeyEvent.VK_DELETE, KeyEvent.VK_DELETE,
            KeyEvent.VK_4, KeyEvent.VK_6,KeyEvent.VK_4, KeyEvent.VK_6,KeyEvent.VK_4, 
            KeyEvent.VK_6,KeyEvent.VK_4, KeyEvent.VK_6};
        for (int i : digita) {
            bot.keyPress(i);
            Thread.sleep(t);
            bot.keyRelease(i);
            Thread.sleep(t);
        }
        
        //digita nome
        int[] digitaNome = {KeyEvent.VK_TAB, KeyEvent.VK_TAB,
            KeyEvent.VK_DELETE, KeyEvent.VK_DELETE, KeyEvent.VK_DELETE, KeyEvent.VK_DELETE,
            KeyEvent.VK_R, KeyEvent.VK_O, KeyEvent.VK_D, KeyEvent.VK_O, KeyEvent.VK_L, KeyEvent.VK_F, KeyEvent.VK_O};
        for (int i : digitaNome) {
            bot.keyPress(i);
            Thread.sleep(t);
            bot.keyRelease(i);
            Thread.sleep(t);
        }
        
        
        //digita nome
        int[] digitaRua = {KeyEvent.VK_TAB,
            KeyEvent.VK_DELETE, KeyEvent.VK_DELETE, KeyEvent.VK_DELETE,
            KeyEvent.VK_A, KeyEvent.VK_V, KeyEvent.VK_PERIOD, KeyEvent.VK_SPACE, KeyEvent.VK_E, 
            KeyEvent.VK_S, KeyEvent.VK_T,KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_O};
        for (int i : digitaRua) {
            bot.keyPress(i);
            Thread.sleep(t);
            bot.keyRelease(i);
            Thread.sleep(t);
        }

        Thread.sleep(250);

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
        int tel = 46464646;

        //consulta se o cliente foi cadastrado
        boolean result = dao.consultaCliente(tel);
        boolean resultExpected = true;
        assertEquals(resultExpected, result);

        //exclui cliente cadastrado
        boolean result2 = dao.excluiCliente(tel);
        boolean resultExpected2 = false;
        assertEquals(resultExpected2, result2);

    }
}
