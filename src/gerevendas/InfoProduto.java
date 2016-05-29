/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rui
 */
public class InfoProduto {
     
   private Map<Produto, InfoProdutoComprado> produtoCompras;
   private int UnidadesVendidas;
   private double TotalPago;
   private int compradoMes[];
   private double TotalPagoMes[];

   // private Set<Cliente> clientesComp;
   
    public InfoProduto(){
    this.produtoCompras=new TreeMap<>(new ComparatorCodigoProduto());
    this.UnidadesVendidas = 0;
    this.TotalPago = 0.0;
    this.TotalPagoMes =new double [12];
    this.compradoMes = new int[12];

  //  this.clientesComp=new HashSet<>();
    }
   
    public InfoProduto(TreeMap<Produto, InfoProdutoComprado> produtoCompras,int UnidadesVendidas, double TotalPago,double[] TotalPagoMes,int[] compradoMes) {
        this.produtoCompras=produtoCompras;
        this.UnidadesVendidas = UnidadesVendidas;
        this.TotalPago = TotalPago;
        this.TotalPagoMes = TotalPagoMes.clone();
        this.compradoMes =compradoMes.clone();
    }
    
     public InfoProduto(InfoProduto ip) throws CloneNotSupportedException{
        this.produtoCompras=ip.getProdutoCompras();
        this.UnidadesVendidas=ip.getUnidadesVendidas();
        this.TotalPago=getTotalPago();
        this.TotalPagoMes=getTotalPagoMes();
        this.compradoMes=getCompradoMes();
        
        
    }
    
    public int getProdutosCliente(int mes) {
         int r = 0;
         for(InfoProdutoComprado ipc : produtoCompras.values()){
         
             if(ipc.totalComprasMes(mes)!=0) r++;
         
         }
        return r;
    }
    
    public TreeMap<Produto, InfoProdutoComprado> getProdutoCompras() throws CloneNotSupportedException {
        
    TreeMap<Produto,InfoProdutoComprado> res = new TreeMap<>();
         produtoCompras.forEach( (k,v) ->  {
        try {
            res.put(k.clone(), v.clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(InfoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
        return res;
    }


    public int getUnidadesVendidas() {
        return UnidadesVendidas;
    }

    public double getTotalPago() {
        return TotalPago;
    }
    
     public double[] getTotalPagoMes() {
        return TotalPagoMes;
    }
     
     public double getTotalPagoMesIndice(int i) {
        return TotalPagoMes[i-1];
    }
    
    public int[] getCompradoMes(){
        return compradoMes;
    }
    
    public int getCompradoMesIndice(int i){
        return compradoMes[i-1];
    }

    void adicionaInfoProduto(double preco, int quant,int mes) {
        UnidadesVendidas++;
        TotalPago+=preco*quant;
        compradoMes[mes-1]+=quant;
        TotalPagoMes[mes-1]=preco*getCompradoMesIndice(mes);
     //   clientesComp.add(cli.clone());
    }
   
    
   
   
}
