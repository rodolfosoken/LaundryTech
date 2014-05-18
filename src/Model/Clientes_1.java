/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rodolfo
 */
@Entity
@Table(name = "clientes", catalog = "laundrytech", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clientes_1.findAll", query = "SELECT c FROM Clientes_1 c"),
    @NamedQuery(name = "Clientes_1.findByCpf", query = "SELECT c FROM Clientes_1 c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Clientes_1.findByCep", query = "SELECT c FROM Clientes_1 c WHERE c.cep = :cep"),
    @NamedQuery(name = "Clientes_1.findByCodClient", query = "SELECT c FROM Clientes_1 c WHERE c.codClient = :codClient")})
public class Clientes_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private BigInteger cpf;
    @Column(name = "CEP")
    private Integer cep;
    @Lob
    @Column(name = "uf")
    private String uf;
    @Lob
    @Column(name = "rua")
    private String rua;
    @Lob
    @Column(name = "cidade")
    private String cidade;
    @Lob
    @Column(name = "bairro")
    private String bairro;
    @Lob
    @Column(name = "apto")
    private String apto;
    @Lob
    @Column(name = "complemento")
    private String complemento;
    @Id
    @Basic(optional = false)
    @Column(name = "codClient")
    private Integer codClient;

    public Clientes_1() {
    }

    public Clientes_1(Integer codClient) {
        this.codClient = codClient;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public void setCpf(BigInteger cpf) {
        BigInteger oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        Integer oldCep = this.cep;
        this.cep = cep;
        changeSupport.firePropertyChange("cep", oldCep, cep);
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        String oldUf = this.uf;
        this.uf = uf;
        changeSupport.firePropertyChange("uf", oldUf, uf);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        String oldRua = this.rua;
        this.rua = rua;
        changeSupport.firePropertyChange("rua", oldRua, rua);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        String oldApto = this.apto;
        this.apto = apto;
        changeSupport.firePropertyChange("apto", oldApto, apto);
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        String oldComplemento = this.complemento;
        this.complemento = complemento;
        changeSupport.firePropertyChange("complemento", oldComplemento, complemento);
    }

    public Integer getCodClient() {
        return codClient;
    }

    public void setCodClient(Integer codClient) {
        Integer oldCodClient = this.codClient;
        this.codClient = codClient;
        changeSupport.firePropertyChange("codClient", oldCodClient, codClient);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codClient != null ? codClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes_1)) {
            return false;
        }
        Clientes_1 other = (Clientes_1) object;
        if ((this.codClient == null && other.codClient != null) || (this.codClient != null && !this.codClient.equals(other.codClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gui.Clientes_1[ codClient=" + codClient + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
