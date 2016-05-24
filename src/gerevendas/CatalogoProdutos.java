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
public class CatalogoProdutos {
    
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
        return CatProdutos;
    }
     
    /*Metodos*/
    
    void adicionaProduto(Produto pro) {
        String cod = pro.getCodigo();
        Character c= Character.toUpperCase(cod.charAt(0));
        this.CatProdutos.get(c).add(pro.clone());
    }
    
    /* Funçao de teste */
     void imprimeCatalogo(){
   
        for (Produto codigo : this.CatProdutos.get('B')) {
            System.out.println(codigo.getCodigo());
        }   
    }
    
}
