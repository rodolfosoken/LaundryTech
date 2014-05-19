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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodolfo
 */
public class DAO_roupa {

    static BD bd;
    DefaultTableModel modelo = new DefaultTableModel();

    public DAO_roupa() {
        bd = BD.getBD();
    }

    public boolean salvar(Roupa r) {
        boolean confirm = false;
        try {

            String SQL = "INSERT INTO laundrytech.roupas "
                    + "(`codRoupa`, descricao, preco, medida) "
                    + "VALUES ('" + r.getCodRoupa() + "', '" + r.getDescricao() + "', '" + r.getPreco() + "', '"
                    + r.getMedida() + "')";

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

    public DefaultTableModel listaRoupa() {

        modelo.setColumnIdentifiers(new Object[]{"Codigo", "Descricao", "Preco", "Medida"});
        modelo.setNumRows(0);
        try {
            bd.ExecuteQuery("SELECT * FROM laundrytech.roupas");
            bd.rs.first();
            do {
                try {

                    modelo.addRow(new Object[]{
                        bd.rs.getObject("codRoupa"), bd.rs.getObject("descricao"),
                        bd.rs.getObject("preco"), bd.rs.getObject("medida"),});
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_roupa.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (bd.rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(DAO_roupa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
    
        public DefaultTableModel procuraRoupa(String descricao) {

        String SQL_full = "SELECT * FROM laundrytech.roupas WHERE descricao LIKE '%" + descricao + "%'";
        //faz a busca no banco de dados
        try {
            //remove as linhas da consulta anterior    
            modelo.setNumRows(0);

            bd.ExecuteQuery(SQL_full);
            while (bd.rs.next()) {
                modelo.addRow(
                        new Object[]{
                            bd.rs.getObject("codRoupa"), bd.rs.getObject("descricao"),
                            bd.rs.getObject("preco"), bd.rs.getObject("medida"),});
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO_roupa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

}
