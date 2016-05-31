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
   int[][] unidadesVendidas; /* Unidades vendidas cada mes de cada tipo*/
  
   //totalVendas
   /*Construtores*/
     
    public InfoProdutoFacturacao() {
        
        this.totalVendidas = 0;
        this.unidadesVendidas =new int[12][2];
        
     

    }
    
    public InfoProdutoFacturacao(int totalVendidas, int[][] unidadesVendidas, double[][] faturado, double[][] totalFaturado, double[][] totalFatFilial1, double[][] totalFatFilial2, double[][] totalFatFilial3, int[][] totalUniFilial1, int[][] totalUniFilial2, int[][] totalUniFilial3) {
        
        this.totalVendidas = totalVendidas;
        this.unidadesVendidas = unidadesVendidas.clone();
        
     
        
    }
   
   
    public InfoProdutoFacturacao(InfoProdutoFacturacao ipf) {
        this.totalVendidas = ipf.getTotalVendidas();
       
       
    }
    
    
    
    /*Getters*/
    
    public int getTotalVendidas() {
        return totalVendidas;
    }

    public int[][] getUnidadesVendidas() {
        return unidadesVendidas.clone();
    }


    
        /*Setters*/

    public void setTotalVendidas(int totalVendidas) {
        this.totalVendidas = totalVendidas;
    }

    public void setUnidadesVendidas(int[][] unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas.clone();
    }

    


    void incrementaTotalVendidas(int quantidade) {
        this.totalVendidas+=quantidade;
    }

    void incrementaUnidadesVendidas(String PouN, int mes, int quantidade) {
        if(PouN.equals("N")){
            
            this.unidadesVendidas[mes-1][0]+=quantidade;
        }else{
            this.unidadesVendidas[mes-1][1]+=quantidade;

        }
    }

 

   



     @Override
    public InfoProdutoFacturacao clone() throws CloneNotSupportedException {
        return new InfoProdutoFacturacao(this);
    }

}