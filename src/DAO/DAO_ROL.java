/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodolfo
 */
public class DAO_ROL {

    static BD bd;

    public DAO_ROL() {
        bd = BD.getBD();
    }

    public static int qtdROL() {
        bd = BD.getBD();
        int qtd = 0;
        try {
            qtd = BD.getNumberOfRows("ROL");
        } catch (Exception ex) {
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return qtd;
    }

}
