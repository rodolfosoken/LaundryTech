/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import DAO.DAO_login;

/**
 *
 * @author Rodolfo
 */
public class Login {
    private String login;
    private String senha;
    
    private static DAO_login dao = new DAO_login();

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean getPermissao(String login, String senha, int acesso){
        return dao.getPermissao(login, senha, acesso);
    }
    
}
