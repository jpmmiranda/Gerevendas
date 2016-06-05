/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;

/**
 * Classe ParCliProdsComprados
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class ParCliProdsComprados implements Serializable {
    
    private int total=0;
    private String produto;

    /**
     * Construtor Vazio
     */
    public ParCliProdsComprados() {
       this.produto = "";
        this.total = 0;
    }

    
   /**
     * Construtor de Cópia
     * @param pcpc Objecto a ser Copiado
     */
    public ParCliProdsComprados(ParCliProdsComprados pcpc) {
         this.produto = pcpc.getProdutos();
        this.total = pcpc.getTotal();
        
    }

    /**
     *@return total
     */
    public int getTotal() {
        return total;
    }

    /**
     *@return produtos
     */
    public String getProdutos() {
        return produto;
    }

    
  
    /**
     * Adiciona produto
     * @param Produto Codigo de produto a ser adicionado
     */
    public void adicionaProduto(String Produto) {
        this.produto=Produto;
   
    }

    /**
     * Adiciona total
     * @param total total a ser adicionado
     */
    public void adicionaTotal(int total) {
        this.total=total;
   
    }
    
    
    /**
     *
     * @return Novo Objecto como cópia da instância Actual
     */
    
    public ParCliProdsComprados clone()  {
        return new ParCliProdsComprados(this);
    }
    
    
    /**
     * Teste de igualdade da instância actual com o parâmetro 
     * @param o Objecto a ser testado
     * @return Igualdade entre a instância actual e o parâmetro obj
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
           ParCliProdsComprados t = (ParCliProdsComprados) o;
            return  (this.total == t.getTotal()&& produto.equals(t.getProdutos())) ;
    }
    }

    

   /**
     * 
     * @return String resultante
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();     
        sb.append("Produto : ").append(produto).append("\n");
        sb.append("Numero Total: ").append(getTotal()).append("\n");
       
        return sb.toString();
    }

    
}
