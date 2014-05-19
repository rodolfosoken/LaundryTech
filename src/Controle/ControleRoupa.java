/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;
import Model.Roupa;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Rodolfo
 */
public abstract class  ControleRoupa {
    
   public static boolean cadastraRoupa(HashMap<String,String> dataRoupa){
       
       Roupa roupa = new Roupa();
       roupa.setCodRoupa(Integer.parseInt(dataRoupa.get("codRoupa")));
       roupa.setDescricao(dataRoupa.get("descricao"));
       roupa.setMedida(dataRoupa.get("medida"));
       roupa.setPreco(Float.parseFloat(dataRoupa.get("preco")));
             
       return roupa.cadRoupa();
   }
   
   
   public static DefaultTableModel listaRoupa(){
       Roupa r = new Roupa();
       return r.listaRoupa();
   }
   
   public static DefaultTableModel procuraRoupa(String descricao){
       Roupa r = new Roupa();
       return r.procuraRoupa(descricao);
   }
   
   public static int getNum(){
       Roupa r = new Roupa();
       return r.getNum();
   }
   
}
