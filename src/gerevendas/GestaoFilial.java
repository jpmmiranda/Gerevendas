/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class GestaoFilial {
    
    private HashMap<Cliente,InfoCliente> comprasDoCliente;
    private HashMap<Produto,InfoProduto> comprasDeProduto;

    
    /*Construtor*/
    public GestaoFilial() {
        this.comprasDoCliente = new HashMap<>();
        this.comprasDeProduto = new HashMap<>();
    }
    
    
    public GestaoFilial(HashMap<Cliente, InfoCliente> comprasDoCliente, HashMap<Produto, InfoProduto> comprasDeProduto) {
        this.comprasDoCliente = comprasDoCliente;
        this.comprasDeProduto = comprasDeProduto;
    }

     public GestaoFilial(GestaoFilial gf) {
        this.comprasDoCliente = gf.getComprasDoCliente();
        this.comprasDeProduto = gf.getComprasDeProduto();
    }

    /*Getters*/
    public HashMap<Cliente,InfoCliente> getComprasDoCliente() {
        return comprasDoCliente;
    }

    public HashMap<Produto,InfoProduto> getComprasDeProduto() {
        return comprasDeProduto;
    }
     
    /*Setters*/

    public void setComprasDoCliente(HashMap<Cliente,InfoCliente> comprasDoCliente) {
        this.comprasDoCliente = comprasDoCliente;
    }

    public void setComprasDeProduto(HashMap<Produto,InfoProduto> comprasDeProduto) {
        this.comprasDeProduto = comprasDeProduto;
    }
    
     /* Métodos */
    
    void imprimeCliente(){
        
                 InfoCliente ic;
                 

         for(Cliente cl : comprasDoCliente.keySet()){
            if(cl.getCodigo().equals("F2916")){
                      ic=comprasDoCliente.get(cl);
                      int r=10;
                       r= ic.getTotalComprados();
                      System.out.println(r);
            }
        }
   
        System.out.println(comprasDoCliente.size());
    
    }
    
    void adicionaComprasCliente(Venda v) throws CloneNotSupportedException {
        
        InfoCliente ic;
        if(this.comprasDoCliente.containsKey(v.getCliente())){
                                    System.out.println("fdasnfsf"+ v.getCliente());

            ic=comprasDoCliente.get(v.getCliente());
            ic.adicionaInfo(v.clone());
            comprasDoCliente.put(v.getCliente().clone(), ic.clone()); 

        }
    
    }
    
    void adicionaClienteInicial(Cliente cli) throws CloneNotSupportedException{
        InfoCliente ic = new InfoCliente();
        this.comprasDoCliente.put(cli, ic);
    }

    void adicionaComprasDeProduto(Venda v) throws CloneNotSupportedException {
        InfoProduto ip;
        if(comprasDeProduto.containsKey(v.getProduto())){
            
            ip=comprasDeProduto.get(v.getProduto());
            ip.adicionaInfoProduto(v.clone());
            comprasDeProduto.put(v.getProduto(), ip); 
        }
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
    public GestaoFilial clone() throws CloneNotSupportedException {
        return new GestaoFilial(this);
    }

  
    
}
