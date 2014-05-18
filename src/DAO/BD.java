/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodolfo
 */
public class BD {
    
    //Configuração dos parâmetros para conexão com o BD
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/laundrytech";
    private static final String User = "root";
    private static final String Senha = "";
    private static BD bd = null;
    public static Connection conexao = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;
    static ResultSetMetaData metadata = null;
    private static boolean existe = false;
    private static final String H_CONN_STRING =null;

//Construtor que gera uma conexão com o BD
    private BD() {
        try {
            conexao = DriverManager.getConnection(URL, User, Senha);
            System.out.println("Conexão bem sucedida!");
        } catch (SQLException ex) {
            System.out.println("Falha ao conectar");
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Connection getBD(BDtipo bdTipo) throws SQLException{
        switch (bdTipo) {
		case MYSQL:
			return DriverManager.getConnection(URL,User, Senha);
		case HSQLDB:
			return DriverManager.getConnection(H_CONN_STRING, User, Senha);
		default:
			return null;
		}
    }

    //Singleton
    public static BD getBD() {
        if (bd == null) {
            bd = new BD();
        }

        return bd;
    }

    public static int getNumberOfRows(String tabela) throws Exception {
        stmt = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery("SELECT * FROM laundrytech." + tabela);
        rs.last();
        //System.out.println("Número de linhas:" + rs.getRow());
        int row = rs.getRow();
        return row;
    }

    public static void ExecuteQuery(String SQL) throws SQLException {
        stmt = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery(SQL);
    }

    public static Object getValueAt(int linha, int coluna, String tabela) throws SQLException {
        stmt = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery("SELECT * FROM laundrytech." + tabela);
        rs.absolute(linha);
        return rs.getObject(coluna);
    }

    public static void insert(String val) throws SQLException {
        stmt = (Statement) conexao.createStatement();
        stmt.executeUpdate(val);
    }

    public static void finaliza() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conexao != null) {
            try {
                conexao.close();
                existe = false;
                System.out.println("conexão fechada");
            } catch (SQLException ex) {
                Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) throws SQLException, Exception {
       //teste de conexão
        getBD();
        //teste de recuperação de dados
        String s = (String) getValueAt(1, 2, "cliente");
        System.out.println(s);
        //insert("INSERT INTO `laundrytech`.`clientes` (`idclientes`,`codigo`, `nome`, `endereco`, `complem`, `apto`, `bairro`, `cidade`, `uf`, `cep`, `tipo`, `nascimento`, `contato`, `telefone`, `telefone2`, `email`, `obs`) VALUES ('2','2', 'teste', 'teste', 'teste', '3', 'teste', 'teste', 'sp', '09726430', '1', '1992-03-23', 'testse', '41247464', '0', 'test', '');");
        finaliza();




    }

}