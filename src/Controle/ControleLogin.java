/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Model.Login;

/**
 *
 * @author Rodolfo
 */
public class ControleLogin {
    
    public static boolean getPermissao(String senha, String login, int acesso){
        Login log = new Login();
        return log.getPermissao(senha, login, acesso);
    }
    
}