package Model;

import DAO.DAO_funcionario;

public class Gerente extends Funcionario {

    private String setor;
    static private DAO_funcionario dao = new DAO_funcionario();

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    public boolean salvar() {
        return dao.salvar(this);
    }

}
