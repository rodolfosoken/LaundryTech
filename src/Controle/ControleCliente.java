/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;
import Model.Cliente;
import java.util.HashMap;
/**
 *
 * @author Rodolfo
 */
public abstract class  ControleCliente {    
   public static boolean cadastraCliente(HashMap<String,String> dataCliente){
       
       Cliente cliente = new Cliente();
       cliente.setNome(dataCliente.get("nome"));
       cliente.setCodClient(Integer.parseInt(dataCliente.get("codigo")));
       cliente.setApto(Integer.parseInt(dataCliente.get("apto")));
       cliente.setBairro(dataCliente.get("bairro"));
       cliente.setCEP(Integer.parseInt(dataCliente.get("cep")));
       cliente.setCidade(dataCliente.get("cidade"));
       cliente.setComplemento(dataCliente.get("complem"));
       cliente.setRua(dataCliente.get("rua"));
       cliente.setUf(dataCliente.get("uf"));
       cliente.setCpf(Long.parseLong(dataCliente.get("cpf")));
       cliente.setCEP(Integer.parseInt(dataCliente.get("cep")));
             
       return cliente.salvar();
   }
}
