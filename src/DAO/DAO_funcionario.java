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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodolfo
 */
public class DAO_funcionario {

    static BD bd;
        DefaultTableModel modelo = new DefaultTableModel();

    public DAO_funcionario() {
        bd = BD.getBD();
    }

    public boolean salvar(Gerente g) {
        boolean confirm = false;
        try {

            String SQL = "INSERT INTO laundrytech.funcionarios "
                    + "( nome, senha, cargo, setor, comissao) "
                    + "VALUES ('" + g.getNome() + "', '" + g.getSenha() + "', '" + g.getCargo() + "', '"
                    + g.getSetor() + "', '" + "0" + "')";

            BD.insert(SQL);

            confirm = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Preencha os campos corretamente");
            confirm = false;
            Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
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
                    + "nenhum" + "', '" + a.getComissao() + "')";
            BD.insert(SQL);

            confirm = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Preencha os campos corretamente");
            confirm = false;
            Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha na comunicação com o banco de dados");
        }

        return confirm;
    }

    public Gerente recuperaGerente(String senha) {
        Gerente g = new Gerente();

        if (consultaGerente(senha)) {
            try {

                bd.ExecuteQuery("SELECT * FROM laundrytech.funcionarios WHERE senha LIKE '" + senha + "'");

                bd.rs.first();
                g.setNome(bd.rs.getString("nome"));
                g.setCargo(bd.rs.getInt("cargo"));
                g.setCodFunc(bd.rs.getInt("codFunc"));
                g.setSetor(bd.rs.getString("setor"));
                g.setSenha(bd.rs.getString("senha"));

            } catch (SQLException ex) {
                Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta");
        }

        return g;

    }

    public boolean consultaGerente(String senha) {
        boolean existe = false;

        String SQL = "SELECT * FROM laundrytech.funcionarios WHERE senha LIKE '" + senha + "'";
        try {
            BD.ExecuteQuery(SQL);
            if (BD.rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    /**
     *
     * @param senha
     * @return
     */
    public Atendente recuperaAtendente(String senha) {
        Atendente a = new Atendente();

        if (consultaAtendente(senha)) {
            try {

                bd.ExecuteQuery("SELECT * FROM laundrytech.funcionarios WHERE senha LIKE '" + senha + "'");

                bd.rs.first();
                a.setNome(bd.rs.getString("nome"));
                a.setCargo(bd.rs.getInt("cargo"));
                a.setCodFunc(bd.rs.getInt("codFunc"));
                a.setComissao(bd.rs.getInt("comissao"));
                a.setSenha(bd.rs.getString("senha"));

            } catch (SQLException ex) {
                Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta");
        }

        return a;

    }

    public boolean consultaAtendente(String senha) {
        boolean existe = false;

        String SQL = "SELECT * FROM laundrytech.funcionarios WHERE senha LIKE '" + senha + "'";
        try {
            BD.ExecuteQuery(SQL);
            if (BD.rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    
        public static int qtdFunc(){
        bd = BD.getBD();
        int qtd=0;
        try {
            qtd = BD.getNumberOfRows("funcionarios");
        } catch (Exception ex) {
            Logger.getLogger(DAO_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return qtd;
}
        
        
            public DefaultTableModel listaFuncionarios() {
        modelo.setColumnIdentifiers(new Object[]{
            "Cod.", "Nome", "Cargo", "Setor", "Comissao"});
        modelo.setNumRows(0);
        try {
            bd.ExecuteQuery("SELECT * FROM laundrytech.funcionarios");
            bd.rs.first();
            do {
                try {

                    modelo.addRow(new Object[]{
                        bd.rs.getObject("codFunc"), bd.rs.getObject("nome"),
                        bd.rs.getObject("cargo"), bd.rs.getObject("setor"),
                        bd.rs.getObject("comissao")});
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (bd.rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(DAO_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

}
