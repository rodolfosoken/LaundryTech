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

}
