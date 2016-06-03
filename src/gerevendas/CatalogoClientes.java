/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

/**
 *
 * @author Rui
 */
public class CatalogoClientes implements Serializable {

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
   
    boolean existeCliente(Cliente cli) {

        
        String cod = cli.getCodigo();
        Character c= Character.toUpperCase(cod.charAt(0));
        return this.CatClientes.get(c).contains(cli);
    }

   
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final CatalogoClientes other = (CatalogoClientes) obj;
        if (!Objects.equals(this.CatClientes, other.CatClientes)) {
            return false;
        }
        return true;
    }

    @Override
    public CatalogoClientes clone() throws CloneNotSupportedException {
        return new CatalogoClientes(this);
    }
    
    

}
    

