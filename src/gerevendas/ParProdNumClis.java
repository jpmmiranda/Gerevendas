/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.Arrays;

/**
 *
 * @author Rui
 */
public class ParProdNumClis {
    
    private int vendas;
    private int totalClientes;

    public ParProdNumClis(int vendas, int totalClientes) {
        this.vendas = vendas;
        this.totalClientes = totalClientes;
    }
    
    public ParProdNumClis(){
        this.vendas=0;
        this.totalClientes=0;
    }
    
      public ParProdNumClis(ParProdNumClis par) {
        this.totalClientes = par.getTotalClientes();
        this.vendas = par.getVendas();        
    }



        

    int getTotalClientes() {
        return this.totalClientes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ParProdutoNClientes:");
        sb.append("Total Clientes Distintos=").append(totalClientes);
        sb.append('}');

        return sb.toString();    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.vendas;
        hash = 43 * hash + this.totalClientes;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
         if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParProdNumClis other = (ParProdNumClis) obj;
        return (this.totalClientes == other.totalClientes)
                && this.vendas==other.vendas;
    

    }

    void actualizaValores(Venda v) {

        vendas++;
        totalClientes++;
    }

    int getVendas() {
        return vendas;
    }
    
    
    
}
