package Model;

import DAO.DAO_ROL;
import java.util.Vector;

public class ROL {

    private int codigo;
    private int statPag;
    private float valorTotal;
    private Cliente unnamed_Cliente_;
    private Atendente unnamed_Atendente_;
    private Vector<Roupa> unnamed_Roupa_ = new Vector<Roupa>();

    public static int qtdROL() {
        return DAO_ROL.qtdROL();
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

}
