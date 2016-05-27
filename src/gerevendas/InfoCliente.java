/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rui
 */
public class InfoCliente {
    
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
    
    public InfoCliente(TreeMap<Produto, InfoProdutoComprado> clienteCompras, int totalComprados, int[] compraMesN,int[] compraMesP) {
        this.clienteCompras = clienteCompras;
        this.totalComprados = totalComprados;
        this.comprasMesN=comprasMesN;
        this.comprasMesP=comprasMesP;
        
    }
    
    public InfoCliente(InfoCliente ic) throws CloneNotSupportedException{
        this.clienteCompras=ic.getClienteCompras();
        this.totalComprados=ic.getTotalComprados();
        this.comprasMesN=getComprasMesN();
        this.comprasMesP=getComprasMesP();
        
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
