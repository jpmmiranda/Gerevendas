/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
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
    private int[] totalgasto;
    private int[] comprasMesN;
    private int[] comprasMesP;

    /* Cosntrutores*/
    /* Corrigir erros nos construtores */
    public InfoCliente(){
        this.clienteCompras=new TreeMap<>(new ComparatorCodigoProduto());
        this.comprasMesN=new int[12];
        this.comprasMesP=new int[12];
        this.totalgasto=new int[12];
    }
    
    public InfoCliente(TreeMap<Produto, InfoProdutoComprado> clienteCompras, int[] compraN,int[] compraP,int[] tg) {
        this.clienteCompras = clienteCompras;
        this.comprasMesN=compraN.clone();
        this.comprasMesP=compraP.clone();
        this.totalgasto=tg.clone();

    }
    
    public InfoCliente(InfoCliente ic) throws CloneNotSupportedException{
        this.clienteCompras=ic.getClienteCompras();
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
      
      
      clienteCompras.forEach( (k, v) ->  {
          ParCliProdsComprados pcpc=new ParCliProdsComprados();
          pcpc.adicionaTotal(v.getUnidadesVendidas());
          pcpc.adicionaProduto(k.getCodigo());
          cod.add(pcpc.clone());      
         });

        return cod;
    }
    
    public boolean existeProduto(Produto p){
        return clienteCompras.containsKey(p);
    }
    /*Setters*/

    public void setClienteCompras(TreeMap<Produto, InfoProdutoComprado> clienteCompras) {
        this.clienteCompras = clienteCompras;
    }

  
    
    
     /* Métodos */
    
       void adicionaInfo(Venda v) throws CloneNotSupportedException {
        
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


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InfoCliente other = (InfoCliente) obj;
        if (!Objects.equals(this.clienteCompras, other.clienteCompras)) {
            return false;
        }
        if (!Arrays.equals(this.totalgasto, other.totalgasto)) {
            return false;
        }
        if (!Arrays.equals(this.comprasMesN, other.comprasMesN)) {
            return false;
        }
        if (!Arrays.equals(this.comprasMesP, other.comprasMesP)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public InfoCliente clone() throws CloneNotSupportedException {
        return new InfoCliente(this);
    }

   
   
  
}
