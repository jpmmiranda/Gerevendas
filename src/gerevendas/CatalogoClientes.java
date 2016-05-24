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

    private HashMap<Character,TreeSet<Cliente>> CatClientes;
    
    
    /*Construtores*/
    public  CatalogoClientes(){
        this.CatClientes = new HashMap<>();
        for (Character c = 'A'; c <= 'Z'; c++) {
          this.CatClientes.put(c, new TreeSet<Cliente>(new ComparatorCodigoCliente()));
        }
    }
    
     public CatalogoClientes(CatalogoClientes cc) {
        this.CatClientes = cc.getCatClientes();
    }
    
    /* Getters*/

    public HashMap<Character, TreeSet<Cliente>> getCatClientes() {
        return CatClientes;
    }
     
    /*Metodos*/
    
    void adicionaCliente(Cliente cli) {
        String cod = cli.getCodigo();
        Character c= Character.toUpperCase(cod.charAt(0));
        this.CatClientes.get(c).add(cli.clone());
    }
    
    /* Funçao de teste */
     void imprimeCatalogo(){
   
        for (Cliente codigo : this.CatClientes.get('A')) {
            System.out.println(codigo.getCodigo());
        }   
    }
    
}
