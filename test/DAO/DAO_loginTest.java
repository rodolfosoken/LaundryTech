/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodolfo
 */
public class DAO_loginTest {
    
    public DAO_loginTest() {
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
     * Test of getPermissao method, of class DAO_login.
     */
    @Test
    public void testGetPermissao_3args() {
        System.out.println("getPermissao");
        String login = "master";
        String senha = "123";
        int acesso = 2;
        DAO_login instance = new DAO_login();
        boolean expResult = true;
        boolean result = instance.getPermissao(login, senha, acesso);
        assertEquals(expResult, result);
       }

    /**
     * Test of getPermissao method, of class DAO_login.
     */
    @Test
    public void testGetPermissao_String_String() {
        System.out.println("getPermissao");
        String login = "Atendente";
        String senha = "123";
        DAO_login instance = new DAO_login();
        boolean expResult = true;
        boolean result = instance.getPermissao(login, senha);
        assertEquals(expResult, result);
        }
    
}
