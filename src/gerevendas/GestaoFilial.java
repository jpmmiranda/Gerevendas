/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author Rui
 */
public class GestaoFilial {
    
    private HashMap<Cliente,InfoCliente> comprasDoCliente;
    private HashMap<Produto,InfoProduto> comprasDeProduto; // NAo sei se sera necessario!!!

    
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
    
    
    void adicionaComprasCliente(Venda v) throws CloneNotSupportedException {
        
      this.comprasDoCliente.get(v.getCliente()).adicionaInfo(v.clone());
                    
    }
    
    
    
    void adicionaClienteInicial(Cliente cli) throws CloneNotSupportedException{
        InfoCliente ic = new InfoCliente();
        this.comprasDoCliente.put(cli.clone(), ic);
    }

    void adicionaProdutoInicial(Produto pro) {
        InfoProduto ip = new InfoProduto();
        this.comprasDeProduto.put(pro.clone(), ip);
    }
    
    void adicionaComprasDeProduto(Venda v) throws CloneNotSupportedException {
       
        if(comprasDeProduto.containsKey(v.getProduto())){
                 this.comprasDeProduto.get(v.getProduto()).adicionaInfoProduto(v.clone());

        }
    }
    
     public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        final GestaoFilial other = (GestaoFilial) o;
        return this.comprasDoCliente.keySet().containsAll(other.comprasDoCliente.keySet())
                && this.comprasDoCliente.values().containsAll(other.comprasDoCliente.values())
                && this.comprasDeProduto.keySet().containsAll(other.comprasDeProduto.keySet())
                && this.comprasDeProduto.values().containsAll(other.comprasDeProduto.values());
      }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.comprasDoCliente);
        hash = 97 * hash + Objects.hashCode(this.comprasDeProduto);
        return hash;
    }
     
    @Override
    public GestaoFilial clone() throws CloneNotSupportedException {
        return new GestaoFilial(this);
    }


  
    
}
