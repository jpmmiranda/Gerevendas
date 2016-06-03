/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Arrays;
import java.util.TreeMap;

/**
 *
 * @author Rui
 */
public class InfoProdutoComprado implements Serializable{
    
    
   private int UnidadesVendidas;
   private double TotalPago;
   private int ComprasN[], ComprasP[];


   /*Construtores*/
   
   public InfoProdutoComprado() {
        
        this.UnidadesVendidas=0;
        this.TotalPago=0.0;
        this.ComprasN=new int[12];
        this.ComprasP=new int[12];



    }
   
    public InfoProdutoComprado(int UnidadesVendidas, double TotalPago) {
        this.UnidadesVendidas = UnidadesVendidas;
        this.TotalPago = TotalPago;
      
    }
   
   public InfoProdutoComprado(InfoProdutoComprado ip) throws CloneNotSupportedException {
       
        this.TotalPago = ip.getTotalPago();
        this.UnidadesVendidas = ip.getUnidadesVendidas();
        this.ComprasN=ip.getComprasN();
        this.ComprasP=ip.getComprasP();
    }
   
   
   
   /*Getters
   */

    public int[] getComprasN() {
        return ComprasN.clone();
    }

    public int[] getComprasP() {
        return ComprasP.clone();
    }

   
   

    public int getUnidadesVendidas() {
        return UnidadesVendidas;
    }

    public double getTotalPago() {
        return TotalPago;
    }

    
    
   /*Setter*/

    public void setUnidadesVendidas(int UnidadesVendidas) {
        this.UnidadesVendidas = UnidadesVendidas;
    }

    public void setTotalPago(double TotalPago) {
        this.TotalPago = TotalPago;
    }

    
    
    /* Métodos */
    
  
    public int totalComprasMes(int mes){
    
        return ComprasN[mes-1]+ ComprasP[mes-1];
    }
    
    void adicionaInfoProduto(double preco, int quant,int mes,String PouN) {
        UnidadesVendidas+=quant;
        TotalPago+=preco*quant;
        if(PouN.equals("N")) ComprasN[mes-1]++;
        else ComprasP[mes-1]++;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InfoProdutoComprado other = (InfoProdutoComprado) obj;
        if (this.UnidadesVendidas != other.UnidadesVendidas) {
            return false;
        }
        if (Double.doubleToLongBits(this.TotalPago) != Double.doubleToLongBits(other.TotalPago)) {
            return false;
        }
        if (!Arrays.equals(this.ComprasN, other.ComprasN)) {
            return false;
        }
        if (!Arrays.equals(this.ComprasP, other.ComprasP)) {
            return false;
        }
        return true;
    }
    
    
    
    
     @Override
    public InfoProdutoComprado clone() throws CloneNotSupportedException {
        return new InfoProdutoComprado(this);
    }
}
