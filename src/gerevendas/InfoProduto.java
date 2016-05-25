/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.TreeMap;

/**
 *
 * @author Rui
 */
public class InfoProduto {
    
    
   private int UnidadesVendidas;
   private double TotalPago;
   private int[][] ComprasFilial1;
   private int[][] ComprasFilial2;
   private int[][] ComprasFilial3;

   /*Construtores*/
   
   public InfoProduto() {
        
        this.UnidadesVendidas=0;
        this.TotalPago=0.0;
        this.ComprasFilial1 = new int[12][2];
        this.ComprasFilial2 = new int[12][2];
        this.ComprasFilial3 = new int[12][2];


    }
   
    public InfoProduto(int UnidadesVendidas, double TotalPago, int[][] ComprasFilial1, int[][] ComprasFilial2, int[][] ComprasFilial3) {
        this.UnidadesVendidas = UnidadesVendidas;
        this.TotalPago = TotalPago;
        this.ComprasFilial1 = ComprasFilial1;
        this.ComprasFilial2 = ComprasFilial2;
        this.ComprasFilial3 = ComprasFilial3;
    }
   
   public InfoProduto(InfoProduto ip) throws CloneNotSupportedException {
       
        this.TotalPago = ip.getTotalPago();
        this.UnidadesVendidas = ip.getUnidadesVendidas();
        this.ComprasFilial1 = ip.getComprasFilial1();
        this.ComprasFilial2 = ip.getComprasFilial2();
        this.ComprasFilial3 = ip.getComprasFilial3();
    }
   
   
   
   /*Getters
   */

    public int getUnidadesVendidas() {
        return UnidadesVendidas;
    }

    public double getTotalPago() {
        return TotalPago;
    }

    public int[][] getComprasFilial1() {
        return ComprasFilial1;
    }

    public int[][] getComprasFilial2() {
        return ComprasFilial2;
    }

    public int[][] getComprasFilial3() {
        return ComprasFilial3;
    }
    
   /*Setter*/

    public void setUnidadesVendidas(int UnidadesVendidas) {
        this.UnidadesVendidas = UnidadesVendidas;
    }

    public void setTotalPago(double TotalPago) {
        this.TotalPago = TotalPago;
    }

    public void setComprasFilial1(int[][] ComprasFilial1) {
        this.ComprasFilial1 = ComprasFilial1;
    }

    public void setComprasFilial2(int[][] ComprasFilial2) {
        this.ComprasFilial2 = ComprasFilial2;
    }

    public void setComprasFilial3(int[][] ComprasFilial3) {
        this.ComprasFilial3 = ComprasFilial3;
    }
    
    /* Métodos */
    
    @Override
    public InfoProduto clone() throws CloneNotSupportedException {
        return new InfoProduto(this);
    }

    void adicionaInfoProduto(Venda v) {
        
        this.UnidadesVendidas+=v.getQuantidade();
        this.TotalPago+=v.getPreco()*v.getQuantidade();
        int mes = v.getMes();
        int quantidade= v.getQuantidade();
        double preco = v.getPreco();
        
           if(v.getPouN().equals("N")){
            if(v.getFilial()==1){
            
                 this.ComprasFilial1[mes-1][0]+=preco*quantidade;
                 this.ComprasFilial1[mes-1][0]+=quantidade;
                 
            }else if(v.getFilial()==2){
                
                 this.ComprasFilial2[mes-1][0]+=preco*quantidade;
                 this.ComprasFilial2[mes-1][0]+=quantidade;
            
            
            }else{
                 this.ComprasFilial3[mes-1][0]+=preco*quantidade;
                 this.ComprasFilial3[mes-1][0]+=quantidade;
            }
        }else{
            if(v.getFilial()==1){
            
                 this.ComprasFilial1[mes-1][1]+=preco*quantidade;
                 this.ComprasFilial1[mes-1][1]+=quantidade;
                 
            }else if(v.getFilial()==2){
                
                 this.ComprasFilial2[mes-1][1]+=preco*quantidade;
                 this.ComprasFilial2[mes-1][1]+=quantidade;
            
            
            }else{
                 this.ComprasFilial3[mes-1][1]+=preco*quantidade;
                 this.ComprasFilial3[mes-1][1]+=quantidade;
            }
        }
        
        
    }
}
