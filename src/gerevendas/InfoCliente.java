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
public class InfoCliente {
    
    private TreeMap<Produto, InfoProduto> clienteCompras; // Cada cliente tem os seus produtos
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
    
    public InfoCliente(InfoCliente ic){
        this.clienteCompras=ic.getClienteCompras();
        this.totalComprados=ic.getTotalComprados();
        
    }
    
    
    /*Getters*/

    public TreeMap<Produto, InfoProduto> getClienteCompras() {
        return clienteCompras;
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
        /*InfoProduto ip;
        if(clienteCompras.containsKey(v.getProduto())){
            ip=clienteCompras.get(v.getProduto());
            ip.adicionaInfoProduto(v.clone());
            clienteCompras.put(v.getProduto(), ip); 
        
        }else{
            ip=new InfoProduto();
            ip.adicionaInfoProduto(v.clone());
            clienteCompras.put(v.getProduto(), ip);    
        }*/
        
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
