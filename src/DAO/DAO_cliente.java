/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodolfo
 */
public class DAO_cliente {

    static BD bd;
    DefaultTableModel modelo = new DefaultTableModel();

    public DAO_cliente() {
        bd = BD.getBD();
    }

    public boolean salvar(Cliente c) {
        boolean confirm = false;
        try {

            String SQL = "INSERT INTO laundrytech.clientes "
                    + "(`codClient`, nome, cpf, `CEP`, uf, rua, cidade, bairro, apto, complemento) "
                    + "VALUES ('" + c.getCodClient() + "', '" + c.getNome() + "', '" + c.getCpf() + "', '"
                    + c.getCEP() + "', '" + c.getUf() + "', '" + c.getRua() + "', '" + c.getCidade() + "', '" + c.getBairro() + "', '"
                    + c.getApto() + "', '" + c.getComplemento() + "')";

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

    public Cliente recupera(int tel) {
        Cliente c = new Cliente();

        if (consultaCliente(tel)) {
            try {

                bd.ExecuteQuery("SELECT * FROM laundrytech.clientes WHERE codClient LIKE '" + tel + "'");

                bd.rs.first();
                c.setNome(bd.rs.getString("nome"));
                c.setApto(bd.rs.getInt("apto"));
                c.setBairro(bd.rs.getString("bairro"));
                c.setCEP(bd.rs.getInt("cep"));
                c.setCidade(bd.rs.getString("cidade"));
                c.setCodClient(bd.rs.getInt("codClient"));
                c.setComplemento(bd.rs.getString("complemento"));
                c.setCpf(bd.rs.getLong("cpf"));
                c.setRua(bd.rs.getString("rua"));
                c.setUf(bd.rs.getString("uf"));

            } catch (SQLException ex) {
                Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não existe");
        }

        return c;
    }

    public Cliente recupera_row(int row) {
        Cliente c = new Cliente();

        if (consultaCliente(row)) {
            try {

                bd.ExecuteQuery("SELECT * FROM laundrytech.clientes");
                bd.rs.absolute(row);

                bd.rs.first();
                c.setNome(bd.rs.getString("nome"));
                c.setApto(bd.rs.getInt("apto"));
                c.setBairro(bd.rs.getString("bairro"));
                c.setCEP(bd.rs.getInt("cep"));
                c.setCidade(bd.rs.getString("cidade"));
                c.setCodClient(bd.rs.getInt("codClient"));
                c.setComplemento(bd.rs.getString("complemento"));
                c.setCpf(bd.rs.getLong("cpf"));
                c.setRua(bd.rs.getString("rua"));
                c.setUf(bd.rs.getString("uf"));
                
                System.out.println(row);

            } catch (SQLException ex) {
                Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não existe");
        }

        return c;
    }

    public boolean consultaCliente(int tel) {
        boolean existe = false;

        String SQL = "SELECT * FROM laundrytech.clientes WHERE codClient LIKE '" + tel + "'";
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
    
        public boolean excluiCliente(int tel) {
        boolean existe = false;

        String SQL = "DELETE FROM laundrytech.clientes WHERE codClient LIKE '" + tel + "'";
        try {
            BD.insert(SQL);
            existe = this.consultaCliente(tel);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    

    public DefaultTableModel listaClientes() {
        modelo.setColumnIdentifiers(new Object[]{
            "CPF", "Nome", "Telefone", "End.", "Cidade"});
        modelo.setNumRows(0);
        try {
            bd.ExecuteQuery("SELECT * FROM laundrytech.clientes");
            bd.rs.first();
            do {
                try {

                    modelo.addRow(new Object[]{
                        bd.rs.getObject("cpf"), bd.rs.getObject("nome"),
                        bd.rs.getObject("codClient"), bd.rs.getObject("rua"),
                        bd.rs.getObject("cidade")});
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (bd.rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    public DefaultTableModel procuraCliente(String SQL) {
        String SQL_full = "SELECT * FROM laundrytech.clientes WHERE " + SQL;
        //faz a busca no banco de dados
        try {
            //remove as linhas da consulta anterior    
            modelo.setNumRows(0);

            bd.ExecuteQuery(SQL_full);
            while (bd.rs.next()) {
                modelo.addRow(new Object[]{bd.rs.getObject("cpf"),
                    bd.rs.getObject("nome"), bd.rs.getObject("codClient"),
                    bd.rs.getObject("rua"), bd.rs.getObject("cidade")});
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

}
