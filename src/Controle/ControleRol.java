/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Model.Atendente;
import Model.Cliente;
import Model.ROL;
import java.util.Date;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodolfo
 */
public class ControleRol {
    
    public static boolean geraRol(HashMap<String,String> rol , String[][] roupas){
        Atendente a = new Atendente();
        Cliente c = new Cliente();
        ROL r = new ROL();
        r.setCodigo(Integer.parseInt(rol.get("codigo")));
        r.setData(rol.get("data"));
        r.setDesconto(Float.parseFloat(rol.get("desconto")));
        r.setEmissao(rol.get("emissao"));
        r.setStatPag(Integer.parseInt(rol.get("status")));
        r.setTipoEntrega(rol.get("tipoEnt"));
        r.setUnnamed_Atendente_(a.recupera(rol.get("atendente")));
        r.setUnnamed_Cliente_(c.recupera(Integer.parseInt(rol.get("cliente"))));
        r.setValorTotal(Float.parseFloat(rol.get("saldo")));
        r.setNome(rol.get("nome"));
        
        return r.salvar(roupas);
    }
    
    public static DefaultTableModel listaLancamentos(){
        ROL r = new ROL();
        return r.listaLancamentos();
    }

    public static int qtdROL() {
        return Model.ROL.qtdROL();
    }

}
