/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;

/**
 * Classe InfoProdutoFacturacao
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class InfoProdutoFacturacao implements Serializable{
    
    
   int totalVendidas; /* Total de unidades vendidas de cada produto*/
  
  /**
     * Construtor Vazio
     */
   
     
    public InfoProdutoFacturacao() {
        
        this.totalVendidas = 0;
             

    }
    
    /**
     * Construtor Parametrizado
     * @param totalVendidas  totalVendidas  
     */
    public InfoProdutoFacturacao(int totalVendidas) {
        
        this.totalVendidas = totalVendidas;
        
     
        
    }
   
   /**
     * Construtor de Cópia
     * @param ipf Objecto a ser Copiado
     */
    public InfoProdutoFacturacao(InfoProdutoFacturacao ipf) {
        this.totalVendidas = ipf.getTotalVendidas();
       
       
    }
    
    
    
   /**
     * 
     * @return totalVendidas
     */
    
    public int getTotalVendidas() {
        return totalVendidas;
    }

   
     /**
     * Actualiza Numero de total vendidas
     * @param totalVendidas total Vendidas
     */

    public void setTotalVendidas(int totalVendidas) {
        this.totalVendidas = totalVendidas;
    }

    
    /**
     * Incrementa total vendidas
     * @param quantidade Quantidade vendida
     */

    public void incrementaTotalVendidas(int quantidade) {
        this.totalVendidas+=quantidade;
    }

   
    /**
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final InfoProdutoFacturacao other = (InfoProdutoFacturacao) obj;
        if (this.totalVendidas != other.totalVendidas) {
            return false;
        }
       
        return true;
    }

    /**
     *
     * @return Novo Objecto como cópia da instância Actual
     * @throws java.lang.CloneNotSupportedException
     */
     @Override
    public InfoProdutoFacturacao clone() throws CloneNotSupportedException {
        return new InfoProdutoFacturacao(this);
    }

}