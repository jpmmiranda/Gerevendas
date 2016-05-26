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
   private int[] ComprasFilial1Normal;
   private int[] ComprasFilial2Normal;
   private int[] ComprasFilial3Normal;
   private int[] ComprasFilial1Promocao;
   private int[] ComprasFilial2Promocao;
   private int[] ComprasFilial3Promocao;

  /* private int[][] ComprasFilial1=new int[12][2];
   private int[][] ComprasFilial2=new int[12][2];
   private int[][] ComprasFilial3=new int[12][2];*7

   /*Construtores*/
   
   public InfoProduto() {
        
        this.UnidadesVendidas=0;
        this.TotalPago=0.0;
       this.ComprasFilial1Normal=new int[12];
       this.ComprasFilial2Normal=new int[12];
       this.ComprasFilial3Normal=new int[12];
       this.ComprasFilial1Promocao=new int[12];
       this.ComprasFilial2Promocao=new int[12];
       this.ComprasFilial3Promocao=new int[12];


    }
   
    public InfoProduto(int UnidadesVendidas, double TotalPago, int[] ComprasFilial1Normal, int[] ComprasFilial2Normal, int[] ComprasFilial3Normal,int[] ComprasFilial1Promocao,int[] ComprasFilial2Promocao,int[] ComprasFilial3Promocao) {
        this.UnidadesVendidas = UnidadesVendidas;
        this.TotalPago = TotalPago;
      
        this.ComprasFilial1Normal = ComprasFilial1Normal.clone();
        this.ComprasFilial2Normal = ComprasFilial2Normal.clone();
        this.ComprasFilial3Normal = ComprasFilial3Normal.clone();
        this.ComprasFilial1Promocao = ComprasFilial1Promocao.clone();
        this.ComprasFilial2Promocao = ComprasFilial2Promocao.clone();
        this.ComprasFilial3Promocao = ComprasFilial3Promocao.clone();
    }
   
   public InfoProduto(InfoProduto ip) throws CloneNotSupportedException {
       
        this.TotalPago = ip.getTotalPago();
        this.UnidadesVendidas = ip.getUnidadesVendidas();
        this.ComprasFilial1Normal = ip.getComprasFilial1Normal();
        this.ComprasFilial2Normal = ip.getComprasFilial2Normal();
        this.ComprasFilial3Normal = ip.getComprasFilial3Normal();
        this.ComprasFilial1Promocao = ip.getComprasFilial1Promocao();
        this.ComprasFilial2Promocao = ip.getComprasFilial2Promocao();
        this.ComprasFilial3Promocao = ip.getComprasFilial3Promocao();
    }
   
   
   
   /*Getters
   */

    public int getUnidadesVendidas() {
        return UnidadesVendidas;
    }

    public double getTotalPago() {
        return TotalPago;
    }

    
    public int[] getComprasFilial1Normal() {
        return ComprasFilial1Normal;
    }

    public int[] getComprasFilial2Normal() {
        return ComprasFilial2Normal;
    }

    public int[] getComprasFilial3Normal() {
        return ComprasFilial3Normal;
    }

    public int[] getComprasFilial1Promocao() {
        return ComprasFilial1Promocao;
    }

    public int[] getComprasFilial2Promocao() {
        return ComprasFilial2Promocao;
    }

    public int[] getComprasFilial3Promocao() {
        return ComprasFilial3Promocao;
    }

 
    
   /*Setter*/

    public void setUnidadesVendidas(int UnidadesVendidas) {
        this.UnidadesVendidas = UnidadesVendidas;
    }

    public void setTotalPago(double TotalPago) {
        this.TotalPago = TotalPago;
    }

    public void setComprasFilial1Normal(int[] ComprasFilial1Normal) {
        this.ComprasFilial1Normal = ComprasFilial1Normal;
    }

    public void setComprasFilial2Normal(int[] ComprasFilial2Normal) {
        this.ComprasFilial2Normal = ComprasFilial2Normal;
    }

    public void setComprasFilial3Normal(int[] ComprasFilial3Normal) {
        this.ComprasFilial3Normal = ComprasFilial3Normal;
    }

    public void setComprasFilial1Promocao(int[] ComprasFilial1Promocao) {
        this.ComprasFilial1Promocao = ComprasFilial1Promocao;
    }

    public void setComprasFilial2Promocao(int[] ComprasFilial2Promocao) {
        this.ComprasFilial2Promocao = ComprasFilial2Promocao;
    }

    public void setComprasFilial3Promocao(int[] ComprasFilial3Promocao) {
        this.ComprasFilial3Promocao = ComprasFilial3Promocao;
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
        int filial = v.getFilial();
        if(v.getPouN().equals("N")){
            if(filial==1){

                 this.ComprasFilial1Normal[mes-1]+=quantidade;
                 
            }else if(filial==2){
                
                 this.ComprasFilial2Normal[mes-1]+=quantidade;
            
            
            }else{
                 this.ComprasFilial3Normal[mes-1]+=quantidade;
            }
        }else{
            if(filial==1){
                 this.ComprasFilial1Promocao[mes-1]+=quantidade;
                 
            }else if(filial==2){
                
                 this.ComprasFilial2Promocao[mes-1]+=quantidade;
            
            
            }else{
                 this.ComprasFilial3Promocao[mes-1]+=quantidade;
            }
        }
        
    }
}
