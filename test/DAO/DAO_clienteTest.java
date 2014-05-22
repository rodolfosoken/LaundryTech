/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
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
public class DAO_clienteTest {

    public DAO_clienteTest() {
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
     * Test of salvar, recupera, exclui method, of class DAO_cliente.
     */
    @Test
    public void testDaoCliente() {
        int tel = 12345678;        
        //salva
        System.out.println("salvar");
        Cliente c = new Cliente();
        c.setNome("Usuário Teste");
        c.setCodClient(tel);
        c.setApto(11);
        c.setBairro("bairro do teste");
        c.setCEP(9726000);
        c.setCidade("cidade do teste");
        c.setComplemento("complemento do teste");
        c.setRua("rua do teste");
        c.setUf("uf do teste");
        c.setCpf(401771);

        DAO_cliente instance = new DAO_cliente();
        boolean expResult = true;
        boolean result = instance.salvar(c);
        assertEquals(expResult, result);

        //recupera
        System.out.println("recupera");
        int result2 = instance.recupera(tel).getCodClient();
        assertEquals(c.getCodClient(), result2);

        //exclui
        System.out.println("exclui");
        boolean expResult3 = false;
        boolean result3 = instance.excluiCliente(tel);
        assertEquals(expResult3, result3);
    
                }

}
