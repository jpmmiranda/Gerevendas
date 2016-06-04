/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;

/**
 *
 * @author Rui
 */
public class InfoProdutoFacturacao implements Serializable{
    
    
   int totalVendidas; /* Total de unidades vendidas de cada produto*/
  
   /*Construtores*/
     
    public InfoProdutoFacturacao() {
        
        this.totalVendidas = 0;
             

    }
    
    public InfoProdutoFacturacao(int totalVendidas) {
        
        this.totalVendidas = totalVendidas;
        
     
        
    }
   
   
    public InfoProdutoFacturacao(InfoProdutoFacturacao ipf) {
        this.totalVendidas = ipf.getTotalVendidas();
       
       
    }
    
    
    
    /*Getters*/
    
    public int getTotalVendidas() {
        return totalVendidas;
    }

   
        /*Setters*/

    public void setTotalVendidas(int totalVendidas) {
        this.totalVendidas = totalVendidas;
    }

    


    void incrementaTotalVendidas(int quantidade) {
        this.totalVendidas+=quantidade;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

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


     @Override
    public InfoProdutoFacturacao clone() throws CloneNotSupportedException {
        return new InfoProdutoFacturacao(this);
    }

}