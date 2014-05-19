/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ROL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodolfo
 */
public class DAO_ROL {

    static BD bd;
    DefaultTableModel modelo = new DefaultTableModel();

    public DAO_ROL() {
        bd = BD.getBD();
    }

    public boolean salvar(ROL r, String[][] roupas) {
        boolean confirm = false;
        try {

            String SQL = "INSERT INTO laundrytech.rol "
                    + " (status, `valorTotal`, desconto, emissao, `data`, `tipoEntrega`, cliente, atendente, nome) "
                    + "VALUES ('" + r.getStatPag() + "', '" + r.getValorTotal() + "', '" + r.getDesconto() + "', '" + r.getEmissao() + "', '"
                    + r.getData() + "', '" + r.getTipoEntrega() + "', '" + r.getUnnamed_Cliente_().getCodClient() + "', '"
                    + r.getUnnamed_Atendente_().getSenha()+ "', '"+ r.getNome() + "')";

            BD.insert(SQL);

            confirm = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Preencha os campos corretamente");
            confirm = false;
            Logger.getLogger(DAO_ROL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DAO_ROL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha na comunicação com o banco de dados");
        }

        for (int i = 0; i < roupas.length; i++) {
            try {
                String SQL = "INSERT INTO laundrytech.rol_roupa "
                        + "(codigo, descricao, quantidade, preco, numRol) "
                        + "VALUES ('" + roupas[i][0] + "', '" + roupas[i][1] + "', '" + roupas[i][2] + "', '"
                        + roupas[i][3] + "', '" + roupas[i][4] + "')";
                BD.insert(SQL);

                confirm = true;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: Preencha os campos corretamente");
                confirm = false;
                Logger.getLogger(DAO_ROL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(DAO_ROL.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Falha na comunicação com o banco de dados");
            }

        }

        return confirm;
    }

    public static int qtdROL() {
        bd = BD.getBD();
        int qtd = 0;
        try {
            qtd = BD.getNumberOfRows("rol");
        } catch (Exception ex) {
            Logger.getLogger(DAO_ROL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return qtd;
    }

    public DefaultTableModel listaLancamentos() {
        modelo.setColumnIdentifiers(new Object[]{
            "ROL", "Nome", "Emissao", "Status"});
        modelo.setNumRows(0);
        try {
            bd.ExecuteQuery("SELECT * FROM laundrytech.rol");
            bd.rs.first();
            do {
                try {

                    modelo.addRow(new Object[]{
                        bd.rs.getObject("codigo"), bd.rs.getObject("nome"),
                        bd.rs.getObject("emissao"), bd.rs.getObject("status")
                       });
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_ROL.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (bd.rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(DAO_ROL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

}
