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
    private Facturacao faturacao;
    
    /* Construtores */
    public Hipermercado() {
        this.clientes = new CatalogoClientes();
        this.produtos = new CatalogoProdutos();
        this.faturacao = new Facturacao();
    }
    
    public Hipermercado(CatalogoClientes cc,CatalogoProdutos cp,Facturacao fact) {
		this.clientes= cc;
		this.produtos = cp;	
                this.faturacao=fact;
    }

    
    public Hipermercado(Hipermercado hiper) {
        clientes = hiper.getClientes();
        produtos = hiper.getProdutos();
        faturacao = hiper.getFaturacao());
       
    }

    /* Getters*/
    
    public Facturacao getFaturacao() {
        return faturacao;
    }

    public CatalogoClientes getClientes() {
        return clientes;
    }

    public CatalogoProdutos getProdutos() {
        return produtos;
    }
    
    /* Setters */

    public void setFaturacao(Facturacao faturacao) {
        this.faturacao = faturacao;
    }
    
    

    public void setClientes(CatalogoClientes clientes) {
        this.clientes = clientes;
    }

    public void setProdutos(CatalogoProdutos produtos) {
        this.produtos = produtos;
    }
    
    
    /*Metodos*/
    
    void insereCliente(Cliente cli) {
        clientes.adicionaCliente(cli);
    }

    void insereProduto(Produto pro) {
         produtos.adicionaProduto(pro);
    }
    
    void insereVendaValida(Venda v) throws CloneNotSupportedException {
        faturacao.adicionaFaturacao(v);
    
    }

    void insereVendaInvalida(Venda v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /* Funcao de teste */
    void imprimeClientes(){
    
        clientes.imprimeCatalogo();
    }
    
    void imprimeProdutos(){
    
        produtos.imprimeCatalogo();
    }
    
    boolean existeCliente(Cliente cli){
    Boolean r=false;
        r=clientes.existeCliente(cli);
    return r;
    }
    
    boolean existeProduto(Produto pro){
    Boolean r=false;
        r=produtos.existeProduto(pro);
    return r;
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
