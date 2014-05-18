/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Model.Atendente;
import Model.Gerente;
import java.util.HashMap;

/**
 *
 * @author Rodolfo
 */
public abstract class ControleFuncionario {

    public static boolean cadFuncionario(HashMap<String, String> dataFuncionario, int cargo) {
        if (cargo == 2) {
            Gerente g = new Gerente();
            g.setNome(dataFuncionario.get("nome"));
            g.setSenha(dataFuncionario.get("senha"));
            g.setCargo(2); // defini acesso de gerente
            g.setSetor(dataFuncionario.get("setor"));
            return g.salvar();

        } else {
            Atendente a = new Atendente();
            a.setNome(dataFuncionario.get("nome"));
            a.setSenha(dataFuncionario.get("senha"));
            a.setCargo(1); // defini acesso de gerente
            a.setComissao(0);
            return a.salvar();
        }
    }
    
    public static HashMap<String, String> recuperaAtendente(String senha){
        Atendente a = new Atendente();
        a = a.recupera(senha);
        
        HashMap<String, String> at = new HashMap<>();
        at.put("nome", a.getNome());
        at.put("senha", a.getSenha());
        at.put("cargo", String.valueOf(a.getCargo()));
        at.put("comissao", String.valueOf(a.getComissao()));
        at.put("codFunc", String.valueOf(a.getCodFunc()));
               
        return at;
    }
    
        public static HashMap<String, String> recuperaGerente(String senha){
        Gerente g = new Gerente();
        g = g.recuperaGerente(senha);
        
        HashMap<String, String> ge = new HashMap<>();
        ge.put("nome", g.getNome());
        ge.put("senha", g.getSenha());
        ge.put("cargo", String.valueOf(g.getCargo()));
        ge.put("setor", String.valueOf(g.getSetor()));
        ge.put("codFunc", String.valueOf(g.getCodFunc()));
               
        return ge;
    }
        
        public static int qtdFunc(){
            return Model.Funcionario.qtdFunc();
        }

}
