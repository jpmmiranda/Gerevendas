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
 * Classe que implementa a estrutura de dados de um Catálogo de Produtos
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class CatalogoProdutos implements Serializable{
    
  private HashMap<Character,TreeSet<Produto>> CatProdutos;
    
    
    /**
     * Construtor vazio
     */
    public  CatalogoProdutos(){
        this.CatProdutos = new HashMap<>();
        for (Character c = 'A'; c <= 'Z'; c++) {
          this.CatProdutos.put(c, new TreeSet<>(new ComparatorCodigoProduto()));
        }
    }
    
    /**
     * Construtor de cópia de uma instância da classe CatalogoProdutos
     *
     * @param cp Catálogo a ser copiado
     * @throws java.lang.CloneNotSupportedException
     */
     public CatalogoProdutos(CatalogoProdutos cp) throws CloneNotSupportedException {
        this.CatProdutos = cp.getCatProdutos();
    }
    
    /**
     * 
     * @return Catálogo de Produtos existente no objecto
     * @throws java.lang.CloneNotSupportedException
     */

    public HashMap<Character, TreeSet<Produto>> getCatProdutos() throws CloneNotSupportedException {
       HashMap<Character, TreeSet<Produto>> res = new HashMap<>();
        TreeSet<Produto> aux;
        Character inicio = 'A';
        for (TreeSet<Produto> ts : this.CatProdutos.values()) {
            aux = new TreeSet<>();
            for (Produto st : ts) {
                aux.add(st.clone());
            }
            res.put(inicio, aux);
            inicio++;
        }
        return res;
    }
     
    /**
     * Método que adiciona um produto ao catalogo
     *
     * @param pro Produto a ser inserido
     * @throws java.lang.CloneNotSupportedException
     */
    
    public void adicionaProduto(Produto pro) throws CloneNotSupportedException {
        String cod = pro.getCodigo();
        Character c= Character.toUpperCase(cod.charAt(0));
        this.CatProdutos.get(c).add(pro.clone());
    }
    
   
     /**
     * Método de verificação da existência de um Produto no catálogo de Produtos
     * @param pro Código a ser verificado
     * @return Existência do Código
     */
    
    public boolean existeProduto(Produto pro) {
        String cod = pro.getCodigo();
        Character c= Character.toUpperCase(cod.charAt(0));
        return this.CatProdutos.get(c).contains(pro);
        
    }

    /**
     * Teste de igualdade da instância actual com o parâmetro 
     * @param obj Objecto a ser testado
     * @return Igualdade entre a instância actual e o parâmetro obj
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CatalogoProdutos other = (CatalogoProdutos) obj;
        if (!Objects.equals(this.CatProdutos, other.CatProdutos)) {
            return false;
        }
        return true;
    }
    
    /**
     * Método clone
     * @return Uma nova instância de CatalogoClientes 
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public CatalogoProdutos clone() throws CloneNotSupportedException {
        return new CatalogoProdutos(this);
    }
    
    
    
}
