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
    private GestaoFilial gestfilial;
    private Estatistica estatistica;
    
    /* Construtores */
    public Hipermercado() {
        this.clientes = new CatalogoClientes();
        this.produtos = new CatalogoProdutos();
        this.faturacao = new Facturacao();
        this.gestfilial=new GestaoFilial();
        this.estatistica=new Estatistica();
    }
    
    public Hipermercado(CatalogoClientes cc,CatalogoProdutos cp,Facturacao fact, GestaoFilial gf, Estatistica e) {
		this.clientes= cc;
		this.produtos = cp;	
                this.faturacao=fact;
                this.gestfilial=gf;
                this.estatistica=e;
    }

    
    public Hipermercado(Hipermercado hiper) {
        clientes = hiper.getClientes();
        produtos = hiper.getProdutos();
        faturacao = hiper.getFaturacao();
        gestfilial=hiper.getGestfilial();
        estatistica=hiper.getEstatistica();
       
    }

    /* Getters*/

    public Estatistica getEstatistica() {
        return estatistica;
    }
    
    
    public Facturacao getFaturacao() {
        return faturacao;
    }

    public CatalogoClientes getClientes() {
        return clientes;
    }

    public CatalogoProdutos getProdutos() {
        return produtos;
    }
    
    public GestaoFilial getGestfilial() {
        return gestfilial;
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
    
    public void setGestfilial(GestaoFilial gestfilial) {
        this.gestfilial = gestfilial;
    }

    public void setEstatistica(Estatistica estatistica) {
        this.estatistica = estatistica;
    }
    
    
    /*Metodos*/
    
    void insereCliente(Cliente cli) throws CloneNotSupportedException {
        clientes.adicionaCliente(cli.clone());
        gestfilial.adicionaClienteInicial(cli.clone());
    }

    void insereProduto(Produto pro) {
         produtos.adicionaProduto(pro.clone());
         faturacao.adicionaProduto(pro.clone());
         gestfilial.adicionaProdutoInicial(pro.clone());
    }
    
    void insereVendaValida(Venda v) throws CloneNotSupportedException {
        faturacao.adicionaFaturacao(v.clone());
        gestfilial.adicionaComprasCliente(v.clone());
        gestfilial.adicionaComprasDeProduto(v.clone());
        
    }

    void insereVendaInvalida(Venda v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void insereEstatistica(String fichCompras,int clientes, int produtos, int compras, int preco0, int errados){
        estatistica.setFicheiroVendas(fichCompras);
        estatistica.setTotalClientes(clientes);
        estatistica.setTotalProdutos(produtos);
        estatistica.setTotalComprasZero(preco0);
        estatistica.setTotalFacturacao(faturacao.getTotalFaturadoGlobal());
        estatistica.setTotalNaoComprados(faturacao.getTotalProdutosNaoComprados());
        estatistica.setTotalClientesCompradores(gestfilial.getTotalDeClientesCompradores());
        estatistica.setTotalClientesNaoCompradores(clientes-gestfilial.getTotalDeClientesCompradores());
        estatistica.setTotalProdutosDiferentes(gestfilial.getTotalProdutosDiferentesComprados());
        estatistica.setTotalNaoComprados(produtos-gestfilial.getTotalProdutosDiferentesComprados());

        int i;
        for(i=0;i<12;i++){
            estatistica.setTotalComprasMes(i,faturacao.vendasMensais(i));
            estatistica.setTotalFacturacaoFilial1(i,faturacao.totalFaturadoFilial1(i));
            estatistica.setTotalFacturacaoFilial2(i,faturacao.totalFaturadoFilial2(i));
            estatistica.setTotalFacturacaoFilial3(i,faturacao.totalFaturadoFilial3(i));
            estatistica.setTotalFacturacaoMensal(i,faturacao.totalFacturadoMensal(i));
            estatistica.setClientesDistintos(i,gestfilial.compradoresMes(i));
        }
        
    }
    
    public void imprimeEstatisticas(){
        System.out.println(estatistica.getFicheiroVendas());
        System.out.println(estatistica.getTotalClientes());
        System.out.println(estatistica.getTotalProdutos());
        System.out.println(estatistica.getTotalComprasZero());
       System.out.println( estatistica.getTotalFacturacao());
       System.out.println( estatistica.getTotalNaoComprados());   
        estatistica.toString();//Nao funciona
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
