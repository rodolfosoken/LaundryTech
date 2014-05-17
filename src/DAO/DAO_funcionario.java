/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Atendente;
import Model.Gerente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodolfo
 */
public class DAO_funcionario {
    
    static BD bd;
    
    public DAO_funcionario(){
        bd = BD.getBD();
    }

    public boolean salvar(Gerente g) {
        boolean confirm = false;
        try {

            String SQL = "INSERT INTO laundrytech.funcionarios "
                    + "( nome, senha, cargo, setor, comissao) "
                    + "VALUES ('" + g.getNome() + "', '" + g.getSenha() + "', '" + g.getCargo() + "', '"
                    + g.getSetor() + "', '"+ "0" + "')";

            BD.insert(SQL);

            confirm = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Preencha os campos corretamente");
            confirm = false;
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha na comunicação com o banco de dados");
        }

        return confirm;
    }

    public boolean salvar(Atendente a) {
        boolean confirm = false;
        try {

            String SQL = "INSERT INTO laundrytech.funcionarios "
                    + "( nome, senha, cargo, setor, comissao) "
                    + "VALUES ('" + a.getNome() + "', '" + a.getSenha() + "', '" + a.getCargo() + "', '"
                    + "nenhum" + "', '"+ a.getComissao() + "')";
            BD.insert(SQL);

            confirm = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Preencha os campos corretamente");
            confirm = false;
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha na comunicação com o banco de dados");
        }

        return confirm;
    }

}
