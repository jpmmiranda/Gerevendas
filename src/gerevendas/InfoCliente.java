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

/**
 *
 * @author Rui
 */
public class InfoCliente {
    
    private Map<Produto, InfoProduto> clienteCompras; // Cada cliente tem os seus produtos
    private int totalComprados;
    
    /* Cosntrutores*/
    
    public InfoCliente(){
        this.clienteCompras=new TreeMap<>(new ComparatorCodigoProduto());
        this.totalComprados=0;
    }
    
    public InfoCliente(TreeMap<Produto, InfoProduto> clienteCompras, int totalComprados) {
        this.clienteCompras = clienteCompras;
        this.totalComprados = totalComprados;
    }
    
    public InfoCliente(InfoCliente ic) throws CloneNotSupportedException{
        this.clienteCompras=ic.getClienteCompras();
        this.totalComprados=ic.getTotalComprados();
        
        /* for (Map.Entry<Produto, InfoProduto> entrada : ic.clienteCompras.entrySet()) {
            this.clienteCompras.put(entrada.getKey().clone(), entrada.getValue().clone());
        }*/
    }
    
    
    /*Getters*/
  public List<Produto> getProdutosCliente() {
        ArrayList<Produto> resultado = new ArrayList<>();
        int r,a=0;
        for (Produto produto : this.clienteCompras.keySet()) {
             
            resultado.add(produto.clone());
        }
        System.out.println(clienteCompras.size());
        return (List<Produto>) resultado;
    }
  

    public TreeMap<Produto, InfoProduto> getClienteCompras() throws CloneNotSupportedException {
        
    TreeMap<Produto,InfoProduto> res = new TreeMap<>();
        for (Map.Entry<Produto, InfoProduto> entrada : clienteCompras.entrySet()) 
            res.put(entrada.getKey().clone(), entrada.getValue().clone());
        return res;
    }

    public int getTotalComprados() {
        return totalComprados;
    }
    
    /*Setters*/

    public void setClienteCompras(TreeMap<Produto, InfoProduto> clienteCompras) {
        this.clienteCompras = clienteCompras;
    }

    public void setTotalComprados(int totalComprados) {
        this.totalComprados = totalComprados;
    }
    
    
     /* Métodos */
    
       void adicionaInfo(Venda v) throws CloneNotSupportedException {
        
        this.totalComprados++;
       
        if(!clienteCompras.containsKey(v.getProduto())){
           this.clienteCompras.put(v.getProduto().clone(),new InfoProduto());
        }
         this.clienteCompras.get(v.getProduto()).adicionaInfoProduto(v.clone());
       
        
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
