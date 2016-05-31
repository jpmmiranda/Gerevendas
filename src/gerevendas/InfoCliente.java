/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rui
 */
public class InfoCliente implements Serializable {
    
    private Map<Produto, InfoProdutoComprado> clienteCompras; // Cada cliente tem os seus produtos
    private int totalComprados;
    private int[] totalgasto;
    private int[] comprasMesN;
    private int[] comprasMesP;

    /* Cosntrutores*/
    /* Corrigir erros nos construtores */
    public InfoCliente(){
        this.clienteCompras=new TreeMap<>(new ComparatorCodigoProduto());
        this.totalComprados=0;
        this.comprasMesN=new int[12];
        this.comprasMesP=new int[12];
        this.totalgasto=new int[12];
    }
    
    public InfoCliente(TreeMap<Produto, InfoProdutoComprado> clienteCompras, int totalComprados, int[] compraN,int[] compraP,int[] tg) {
        this.clienteCompras = clienteCompras;
        this.totalComprados = totalComprados;
        this.comprasMesN=compraN.clone();
        this.comprasMesP=compraP.clone();
        this.totalgasto=tg.clone();

    }
    
    public InfoCliente(InfoCliente ic) throws CloneNotSupportedException{
        this.clienteCompras=ic.getClienteCompras();
        this.totalComprados=ic.getTotalComprados();
        this.comprasMesN=ic.getComprasMesN();
        this.comprasMesP=ic.getComprasMesP();
        this.totalgasto=ic.getTotalgasto();
    }
    
    
    /*Getters*/
     public int getProdutosCliente(int mes) {
         int r = 0;
         for(InfoProdutoComprado ipc : clienteCompras.values()){
         
             if(ipc.totalComprasMes(mes)!=0) r++;
         
         }
        return r;
    }


    public int[] getComprasMesN() {
        return comprasMesN;
    }

    public int[] getComprasMesP() {
        return comprasMesP;
    }
  

    public TreeMap<Produto, InfoProdutoComprado> getClienteCompras() throws CloneNotSupportedException {
        
    TreeMap<Produto,InfoProdutoComprado> res = new TreeMap<>();
         clienteCompras.forEach( (k,v) ->  {
        try {
            res.put(k.clone(), v.clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(InfoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
        return res;
    }

    public int getTotalComprados() {
        return totalComprados;
    }
    
    public int getComprasMesNindice(int i) {
        return comprasMesN[i-1];
    }
     public int getComprasMesPindice(int i) {
        return comprasMesP[i-1];
    }

    public int getTotalgasto(int mes) {
        return totalgasto[mes-1];
    }
    
   private int[] getTotalgasto() {
    return totalgasto.clone();
   }

    
    
    public TreeSet<ParCliProdsComprados> getCodigoProduto(){
      TreeSet<ParCliProdsComprados> cod;
      cod = new TreeSet<>(new ComparatorProdutosEQuantidade());
      InfoProdutoComprado ipc = new InfoProdutoComprado(); 
      for(Produto p : clienteCompras.keySet()){
         ParCliProdsComprados pcpc=new ParCliProdsComprados();

          ipc=clienteCompras.get(p);
          pcpc.adicionaTotal(ipc.getUnidadesVendidas());
          pcpc.adicionaProduto(p.getCodigo());
          cod.add(pcpc.clone());
      }
        return cod;
    }
    
    public boolean existeProduto(Produto p){
        return clienteCompras.containsKey(p);
    }
    /*Setters*/

    public void setClienteCompras(TreeMap<Produto, InfoProdutoComprado> clienteCompras) {
        this.clienteCompras = clienteCompras;
    }

    public void setTotalComprados(int totalComprados) {
        this.totalComprados = totalComprados;
    }
    
    
     /* Métodos */
    
       void adicionaInfo(Venda v) throws CloneNotSupportedException {
        
        this.totalComprados++;
        String PouN = v.getPouN();
        int mes=v.getMes();
        double preco=v.getPreco();
        int quantidade=v.getQuantidade();
        if(PouN.equals("N")){
            comprasMesN[mes-1]++;
        }else{
            comprasMesP[mes-1]++;
        }
       totalgasto[mes-1]+=preco*quantidade;
        if(!clienteCompras.containsKey(v.getProduto())){
           this.clienteCompras.put(v.getProduto().clone(),new InfoProdutoComprado());
        }
         this.clienteCompras.get(v.getProduto()).adicionaInfoProduto(preco,quantidade,mes,PouN);
       
        
    }
    
    
    public int calculaDistintos(int mes,Produto p) {
        int r=0;
        if(clienteCompras.containsKey(p)){
            
            InfoProdutoComprado ipc;
            ipc = clienteCompras.get(p);
            if(ipc.totalComprasMes(mes)!=0) r++; 
        }
        return r;
    }

    public int quantidadeDeProdDistintos(){
        return clienteCompras.size();
    }   
    
    public int gastoNoProduto(Produto p){
    
        int gasto;
        
        gasto=(int)clienteCompras.get(p).getTotalPago();
        return gasto;
    }
       
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        return false;
    }
    @Override
    public InfoCliente clone() throws CloneNotSupportedException {
        return new InfoCliente(this);
    }

   
   
  
}
