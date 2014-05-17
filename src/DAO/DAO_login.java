/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodolfo
 */
public class DAO_login {
    
    static BD bd;
    
    public DAO_login(){
        bd = BD.getBD();
    }

    public boolean getPermissao(String login, String senha, int acesso) {
        boolean existe = false;

        String SQL = "SELECT * FROM laundrytech.funcionarios WHERE `nome`= '" + login + "' AND `senha` = '" + senha  + "' AND `cargo` = '" + acesso + "'";
        try {
            BD.ExecuteQuery(SQL);
            if (BD.rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    
        public boolean getPermissao(String login, String senha) {
        boolean existe = false;

        String SQL = "SELECT * FROM laundrytech.funcionarios WHERE `nome`= '" + login + "' AND `senha` = '" + senha  + "'";
        try {
            BD.ExecuteQuery(SQL);
            if (BD.rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    
    
}
