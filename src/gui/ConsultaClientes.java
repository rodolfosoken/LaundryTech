/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controle.ControleCliente;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodolfo
 */
public class ConsultaClientes extends javax.swing.JFrame {

    private JTable tabela;
    //Requisita consulta para o Banco de Dados e retorna o Modelo da tabela;
    private DefaultTableModel modelo = ControleCliente.listaClientes();
    private JButton BTnovo = new JButton("Novo");
    private JTextField JTpesquisa = new JTextField();
    private ButtonGroup TipoPesquisa = new ButtonGroup();
    private JRadioButton jrNome = new JRadioButton("Nome");
    private JRadioButton jrCodigo = new JRadioButton("Tel.");
    private JRadioButton jrEnd = new JRadioButton("End.");
    private String SQL = new String();
    private int rowSelected = 0;

    ConsultaClientes() {
        super("Consulta Clientes");
        BTnovo.addActionListener(new ActJBnovo());
        JTpesquisa.addKeyListener(new keyAct());

        TipoPesquisa.add(jrNome);
        TipoPesquisa.add(jrCodigo);
        TipoPesquisa.add(jrEnd);

        jrNome.doClick();

        JFrame janela = new JFrame();

        //define a Jtable com o modelo obtido pelo banco de dados
        tabela = new JTable(modelo);

        //seta o tamanho padrão de cada coluna
        tabela.getColumnModel().getColumn(0).setMaxWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(60);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(160);

        //listener
        tabela.addKeyListener(new keyAct());
        tabela.addMouseListener(new clickAct());

        Container c4 = new JPanel();
        c4.setLayout(new GridLayout(3, 1));
        c4.add(jrNome);
        c4.add(jrCodigo);
        c4.add(jrEnd);

        Container c3 = new JPanel();
        c3.setLayout(new BorderLayout());
        JLabel label = new JLabel("Clientes");
        label.setFont((new Font("Courier", Font.BOLD + Font.ITALIC, 20)));
        c3.add(BorderLayout.NORTH, label);

        JScrollPane tableRoll = new JScrollPane(tabela);
        tableRoll.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        JPanel JP = new JPanel();
        Container c2 = JP;
        c2.setLayout(new BorderLayout(5, 30));
        JP.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        c2.add(BorderLayout.NORTH, c3);
        c2.add(BorderLayout.CENTER, JTpesquisa);
        c2.add(BorderLayout.EAST, BTnovo);
        c2.add(BorderLayout.WEST, new JLabel("Procura "));

        Container c = getContentPane();
        c.setLayout(new BorderLayout(15, 15));
        c.add(BorderLayout.CENTER, tableRoll);
        c.add(BorderLayout.NORTH, c2);
        c.add(BorderLayout.WEST, c4);
        setLocation(0, 30);
        setSize(850, 480);
        //setVisible(true); //desativado por estar dentro do JDialog
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    private void pesquisarNome(String SQL) {
        ControleCliente.procuraCliente(SQL);
    }

    /**
     * @return the rowSelected
     */
    public int getRowSelected() {
        return rowSelected;
    }

    /**
     * @param rowSelected the rowSelected to set
     */
    public void setRowSelected(int rowSelected) {
        this.rowSelected = rowSelected;
    }

    class keyAct implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                //CadastraCliente cadastra = new CadastraCliente(String.valueOf(JTpesquisa.getText()));
                tabela.setRowSelectionInterval(0, 0);
                rowSelected = (int) tabela.getValueAt(tabela.getSelectedRow(), 2);
                dispose();
            }
            if ((e.getKeyCode() == KeyEvent.VK_ENTER) && (e.getSource() == tabela)) {
                tabela.setFocusCycleRoot(true);
                rowSelected = (int) tabela.getValueAt(tabela.getSelectedRow(), 2);
                dispose();

                //VisualizaCliente exibi = new VisualizaCliente(ControleCliente.consultaCliente(tabela.getSelectedRow()));
                // exibi.setVisible(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (JTpesquisa.getText() != null) {
                String nome = JTpesquisa.getText();
                if (TipoPesquisa.getSelection().equals(jrNome.getModel())) {
                    SQL = "nome LIKE '%" + nome + "%'";
                } else if (TipoPesquisa.getSelection().equals(jrCodigo.getModel())) {
                    SQL = "codClient LIKE '%" + nome + "%'";
                } else if (TipoPesquisa.getSelection().equals(jrEnd.getModel())) {
                    SQL = "rua LIKE '%" + nome + "%'";
                }
                String consulta = SQL;

                pesquisarNome(consulta);

            }

        }
    }

    class clickAct implements MouseListener {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent me) {
            rowSelected = (int) tabela.getValueAt(tabela.getSelectedRow(), 2);
            System.out.println(rowSelected);
            dispose();
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    class ActJBnovo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CadastraCliente win = new CadastraCliente();
            JDialog dia = new JDialog(win);
            dia.setModal(true);     //cria JDialog modal para travar foco
            dia.setContentPane(win.getContentPane());
            dia.setBounds(win.getBounds());
            dia.setVisible(true);
            tabela.setModel(modelo);
            
        }
    }

    public static void main(String[] args) {
        ConsultaClientes cliente = new ConsultaClientes();
    }
}
