/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Roupa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodolfo
 */
public class DAO_roupa {
    static BD bd;
    
    public DAO_roupa(){
        bd = BD.getBD();
    }
    
    public boolean salvar(Roupa r){
        boolean confirm = false;
            try {
            
            String SQL =	 "INSERT INTO laundrytech.roupas "
                    + "(`codRoupa`, descricao, preco, medida) "
                    + "VALUES ('" + r.getCodRoupa() + "', '" + r.getDescricao()+ "', '" + r.getPreco() + "', '"
                    + r.getMedida()+ "')";
            
            BD.insert(SQL);
            
            confirm = true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Preencha os campos corretamente");
            confirm = false;
            Logger.getLogger(DAO_roupa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DAO_roupa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha na comunicação com o banco de dados");
        }
        
        return confirm;
    }
}
