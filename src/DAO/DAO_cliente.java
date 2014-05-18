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

/**
 *
 * @author Rodolfo
 */
public class DAO_cliente {

    static BD bd;

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


}
