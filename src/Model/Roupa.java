package Model;

import DAO.DAO_roupa;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Roupa {
	private int codRoupa;
	private String descricao;
	private float preco;
	private String medida;
	public Tabela unnamed_Tabela_;
	public Vector<ROL> unnamed_ROL_ = new Vector<ROL>();
        
        static DAO_roupa dao = new DAO_roupa();
        
        public int getNum(){
            return dao.getNum();
        }
        
        public DefaultTableModel listaRoupa(){
            return dao.listaRoupa();
        }
        
        public DefaultTableModel procuraRoupa(String descricao){
            return dao.procuraRoupa(descricao);
        }

	public int getCodRoupa() {
		return codRoupa;
	}

	public void setCodRoupa(int aCodRoupa) {
		this.codRoupa = aCodRoupa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String aDescricao) {
		this.descricao = aDescricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float aPreco) {
		this.preco = aPreco;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String aMedida) {
		this.medida = aMedida;
	}

	public boolean cadRoupa() {
		return dao.salvar(this);
	}
}