/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Model.Cliente;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodolfo
 */
public abstract class ControleCliente {

    public static boolean cadastraCliente(HashMap<String, String> dataCliente) {

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

    public static HashMap<String, String> recuperaCliente(int tel) {
        Cliente cliente = new Cliente();
        cliente = cliente.recupera(tel);
        HashMap<String, String> c = new HashMap<>();
        c.put("nome", cliente.getNome());
        c.put("codigo", String.valueOf(cliente.getCodClient()));
        c.put("apto", String.valueOf(cliente.getApto()));
        c.put("bairro", cliente.getBairro());
        c.put("cep", String.valueOf(cliente.getCEP()));
        c.put("cidade", cliente.getCidade());
        c.put("complem", cliente.getComplemento());
        c.put("rua", cliente.getRua());
        c.put("uf", cliente.getUf());
        c.put("cpf", String.valueOf(cliente.getCpf()));
        c.put("cep", String.valueOf(cliente.getCEP()));

        return c;
    }

    public static HashMap<String, String> recupera_row(int row) {
        Cliente cliente = new Cliente();
        cliente = cliente.recupera_row(row);

        HashMap<String, String> c = new HashMap<>();
        c.put("nome", cliente.getNome());
        c.put("codigo", String.valueOf(cliente.getCodClient()));
        c.put("apto", String.valueOf(cliente.getApto()));
        c.put("bairro", cliente.getBairro());
        c.put("cep", String.valueOf(cliente.getCEP()));
        c.put("cidade", cliente.getCidade());
        c.put("complem", cliente.getComplemento());
        c.put("rua", cliente.getRua());
        c.put("uf", cliente.getUf());
        c.put("cpf", String.valueOf(cliente.getCpf()));
        c.put("cep", String.valueOf(cliente.getCEP()));

        return c;
    }

    public static DefaultTableModel listaClientes() {
        Cliente cliente = new Cliente();
        return cliente.listaClientes();

    }

    public static DefaultTableModel procuraCliente(String SQL) {
        Cliente cliente = new Cliente();
        return cliente.procuraCliente(SQL);
    }

}
