package Model;

import DAO.DAO_funcionario;

public class Funcionario {
	private String nome;
	private int codFunc;
	private String senha;
	private int cargo;
        
        DAO_funcionario dao = new DAO_funcionario();

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

    /**
     * @return the codFunc
     */
    public int getCodFunc() {
        return codFunc;
    }

    /**
     * @param codFunc the codFunc to set
     */
    public void setCodFunc(int codFunc) {
        this.codFunc = codFunc;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the cargo
     */
    public int getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

public static int qtdFunc(){
    return DAO_funcionario.qtdFunc();
}

}