/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Classe InfoProdutoComprado
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class InfoProdutoComprado implements Serializable{
    
    
   private int UnidadesVendidas;
   private double TotalPago;
   private int ComprasN[], ComprasP[];


    /**
     * Construtor Vazio
     */
   
   public InfoProdutoComprado() {
        
        this.UnidadesVendidas=0;
        this.TotalPago=0.0;
        this.ComprasN=new int[12];
        this.ComprasP=new int[12];



    }
   
   /**
     * Construtor Parametrizado
     * @param UnidadesVendidas Numero de unidades vendidas
     * @param TotalPago Total Pago
     * @param cn vendas em modo N
     * @param cp vendas em modo P
     */
    public InfoProdutoComprado(int UnidadesVendidas, double TotalPago, int[] cn , int[] cp) {
        this.UnidadesVendidas = UnidadesVendidas;
        this.TotalPago = TotalPago;
        this.ComprasN=cn.clone();
        this.ComprasP = cp.clone();
      
    }
    
   /**
     * Construtor de Cópia
     * @param ip Objecto a ser Copiado
     * @throws java.lang.CloneNotSupportedException
     */
   public InfoProdutoComprado(InfoProdutoComprado ip) throws CloneNotSupportedException {
       
        this.TotalPago = ip.getTotalPago();
        this.UnidadesVendidas = ip.getUnidadesVendidas();
        this.ComprasN=ip.getComprasN();
        this.ComprasP=ip.getComprasP();
    }
   
   
   
   /**
     * 
     * @return Compras N
     */

    public int[] getComprasN() {
        return ComprasN.clone();
    }
    
    /**
     * 
     * @return Compras P
     */
    public int[] getComprasP() {
        return ComprasP.clone();
    }

    /**
     * 
     * @return Unidades Vendidas
     */
    public int getUnidadesVendidas() {
        return UnidadesVendidas;
    }

    /**
     * 
     * @return Total pago
     */
    public double getTotalPago() {
        return TotalPago;
    }

    
    
   /**
     * Actualiza Numero de unidades vendidas
     * @param UnidadesVendidas Unidades Vendidas
     */

    public void setUnidadesVendidas(int UnidadesVendidas) {
        this.UnidadesVendidas = UnidadesVendidas;
    }
    
    /**
     * Actualiza Total pago
     * @param TotalPago Total pago
     */

    public void setTotalPago(double TotalPago) {
        this.TotalPago = TotalPago;
    }

    
    
    /**
     * Calcula total de compras num dado mês
     * @param mes Mes
     * @return total de compras num dado mês
     */
    
  
    public int totalComprasMes(int mes){
    
        return ComprasN[mes-1]+ ComprasP[mes-1];
    }
    
   /**
     * Adiciona info de produto
     * @param preco Preco da venda
     * @param quant Quantidade vendida
     * @param mes Mes
     * @param PouN Modo em que foi efectuada a venda
     */
    public void adicionaInfoProduto(double preco, int quant,int mes,String PouN) {
        UnidadesVendidas+=quant;
        TotalPago+=preco*quant;
        if(PouN.equals("N")) ComprasN[mes-1]++;
        else ComprasP[mes-1]++;
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

    /**
     * Método hashcode
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.UnidadesVendidas;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.TotalPago) ^ (Double.doubleToLongBits(this.TotalPago) >>> 32));
        hash = 79 * hash + Arrays.hashCode(this.ComprasN);
        hash = 79 * hash + Arrays.hashCode(this.ComprasP);
        return hash;
    }
    
    
    
    /**
     *
     * @return Novo Objecto como cópia da instância Actual
     * @throws java.lang.CloneNotSupportedException
     */
     @Override
    public InfoProdutoComprado clone() throws CloneNotSupportedException {
        return new InfoProdutoComprado(this);
    }
}
