package Model;

import DAO.DAO_ROL;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ROL {
    
    private String nome;
    private int codigo;
    private int statPag;
    private float valorTotal;
    private float desconto;
    private String emissao;
    private String data;
    private String tipoEntrega;
    private Cliente unnamed_Cliente_;
    private Atendente unnamed_Atendente_;
    private Vector<Roupa> unnamed_Roupa_ = new Vector<Roupa>();

    static DAO_ROL dao = new DAO_ROL();

    public boolean salvar(String[][] roupas) {
        return dao.salvar(this,roupas);
    }

    public static int qtdROL() {
        return DAO_ROL.qtdROL();
    }
    
    public DefaultTableModel listaLancamentos(){
        return dao.listaLancamentos();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the statPag
     */
    public int getStatPag() {
        return statPag;
    }

    /**
     * @param statPag the statPag to set
     */
    public void setStatPag(int statPag) {
        this.statPag = statPag;
    }

    /**
     * @return the valorTotal
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the unnamed_Cliente_
     */
    public Cliente getUnnamed_Cliente_() {
        return unnamed_Cliente_;
    }

    /**
     * @param unnamed_Cliente_ the unnamed_Cliente_ to set
     */
    public void setUnnamed_Cliente_(Cliente unnamed_Cliente_) {
        this.unnamed_Cliente_ = unnamed_Cliente_;
    }

    /**
     * @return the unnamed_Atendente_
     */
    public Atendente getUnnamed_Atendente_() {
        return unnamed_Atendente_;
    }

    /**
     * @param unnamed_Atendente_ the unnamed_Atendente_ to set
     */
    public void setUnnamed_Atendente_(Atendente unnamed_Atendente_) {
        this.unnamed_Atendente_ = unnamed_Atendente_;
    }

    /**
     * @return the unnamed_Roupa_
     */
    public Vector<Roupa> getUnnamed_Roupa_() {
        return unnamed_Roupa_;
    }

    /**
     * @param unnamed_Roupa_ the unnamed_Roupa_ to set
     */
    public void setUnnamed_Roupa_(Vector<Roupa> unnamed_Roupa_) {
        this.unnamed_Roupa_ = unnamed_Roupa_;
    }

    /**
     * @return the desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the tipoEntrega
     */
    public String getTipoEntrega() {
        return tipoEntrega;
    }

    /**
     * @param tipoEntrega the tipoEntrega to set
     */
    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    /**
     * @return the emissao
     */
    public String getEmissao() {
        return emissao;
    }

    /**
     * @param emissao the emissao to set
     */
    public void setEmissao(String emissao) {
        this.emissao = emissao;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
