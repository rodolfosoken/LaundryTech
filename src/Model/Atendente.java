package Model;

import DAO.DAO_funcionario;

public class Atendente extends Funcionario {
	private int comissao;
        static DAO_funcionario dao = new DAO_funcionario();

    /**
     * @return the comissao
     */
    public int getComissao() {
        return comissao;
    }

    /**
     * @param comissao the comissao to set
     */
    public void setComissao(int comissao) {
        this.comissao = comissao;
    }
    
    public boolean salvar(){
        return dao.salvar(this);
    }
        public Atendente recupera(String senha){            
            return  dao.recuperaAtendente(senha);
        }

}