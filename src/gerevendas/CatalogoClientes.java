/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * @author Rui
 */
public class CatalogoClientes {

    private HashMap<Character,TreeSet<Cliente>> clientes;
    
    
    
    public CatalogoClientes(){
        this.clientes = new HashMap<>();
        for (Character c = 'A'; c <= 'Z'; c++) {
          this.clientes.put(c, new TreeSet<Cliente>());
        }
    }
    
    void adicionaCliente(String cod) {
        System.out.println(cod);
    }
    
}
