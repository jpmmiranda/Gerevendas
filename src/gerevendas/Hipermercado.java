/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

/**
 *
 * @author Rui
 */
public class Hipermercado {

    
    
    
    private CatalogoClientes clientes;
    private CatalogoProdutos produtos;
    
    /* Construtores */
    public Hipermercado() {
        this.clientes = new CatalogoClientes();
        this.produtos = new CatalogoProdutos();
    }
    
    public Hipermercado(CatalogoClientes cc,CatalogoProdutos cp) {
		this.clientes= cc;
		this.produtos = cp;	
    }

    
    public Hipermercado(Hipermercado hiper) {
        clientes = hiper.getClientes();
        produtos = hiper.getProdutos();
       
    }

    /* Getters*/
    public CatalogoClientes getClientes() {
        return clientes;
    }

    public CatalogoProdutos getProdutos() {
        return produtos;
    }
    
    /* Setters */

    public void setClientes(CatalogoClientes clientes) {
        this.clientes = clientes;
    }

    public void setProdutos(CatalogoProdutos produtos) {
        this.produtos = produtos;
    }
    
    
    /*Metodos*/
    
    void insereCliente(String cod) {
        clientes.adicionaCliente(cod);
    }

    void insereProduto(String cod) {
         produtos.adicionaProduto(cod);
    }
    
      @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hipermercado other = (Hipermercado) obj;
        
        return this.clientes.equals(other.clientes)
                && this.produtos.equals(other.produtos);
    }
    
    
    
}
