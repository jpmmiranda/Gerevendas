/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * @author Rui
 */
public class CatalogoProdutos implements Serializable{
    
  private HashMap<Character,TreeSet<Produto>> CatProdutos;
    
    
    /*Construtores*/
    public  CatalogoProdutos(){
        this.CatProdutos = new HashMap<>();
        for (Character c = 'A'; c <= 'Z'; c++) {
          this.CatProdutos.put(c, new TreeSet<Produto>(new ComparatorCodigoProduto()));
        }
    }
    
     public CatalogoProdutos(CatalogoProdutos cp) {
        this.CatProdutos = cp.getCatProdutos();
    }
    
    /* Getters*/

    public HashMap<Character, TreeSet<Produto>> getCatProdutos() {
       HashMap<Character, TreeSet<Produto>> res = new HashMap<>();
        TreeSet<Produto> aux;
        Character inicio = 'A';
        for (TreeSet<Produto> ts : this.CatProdutos.values()) {
            aux = new TreeSet<>();
            for (Produto st : ts) {
                aux.add(st);
            }
            res.put(inicio, aux);
            inicio++;
        }
        return res;
    }
     
    /*Metodos*/
    
    void adicionaProduto(Produto pro) {
        String cod = pro.getCodigo();
        Character c= Character.toUpperCase(cod.charAt(0));
        this.CatProdutos.get(c).add(pro.clone());
    }
    
   
     
    Boolean existeProduto(Produto pro) {
        String cod = pro.getCodigo();
        Character c= Character.toUpperCase(cod.charAt(0));
        return this.CatProdutos.get(c).contains(pro);
        
    }
    
}
