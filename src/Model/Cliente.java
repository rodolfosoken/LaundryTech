package Model;

import DAO.DAO_cliente;
import java.util.Vector;

public class Cliente {
	private int codClient;
	private String nome;
	private long cpf;
	private int CEP;
	private String uf;
	private String rua;
	private String cidade;
	private String bairro;
	private int apto;
	private String complemento;
	private String endereco;
	public Vector<ROL> unnamed_ROL_ = new Vector<ROL>();
        
        static DAO_cliente dao = new DAO_cliente();
        
        public boolean salvar(){
            return dao.salvar(this);
        }

    /**
     * @return the codClient
     */
    public int getCodClient() {
        return codClient;
    }

    /**
     * @param codClient the codClient to set
     */
    public void setCodClient(int codClient) {
        this.codClient = codClient;
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

    /**
     * @return the cpf
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the CEP
     */
    public int getCEP() {
        return CEP;
    }

    /**
     * @param CEP the CEP to set
     */
    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the apto
     */
    public int getApto() {
        return apto;
    }

    /**
     * @param apto the apto to set
     */
    public void setApto(int apto) {
        this.apto = apto;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}