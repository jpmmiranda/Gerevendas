/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Classe de convergência dos Módulos
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class Hipermercado  implements Serializable{

    private CatalogoClientes clientes;
    private CatalogoProdutos produtos;
    private Facturacao faturacao;
    private GestaoFilial gestfilial;
    private Estatistica estatistica;
    
    /**
     * Construtor Vazio
     */
    public Hipermercado() {
        this.clientes = new CatalogoClientes();
        this.produtos = new CatalogoProdutos();
        this.faturacao = new Facturacao();
        this.gestfilial=new GestaoFilial();
        this.estatistica=new Estatistica();
    }
    
    /**
     * Construtor Parametrizado
     * @param cc CatalogoClientes a ser copiado
     * @param cp CatalogoProdutos a ser copiado  
     * @param fact Facturacao a ser copiada 
     * @param gf GestaoFilial a ser copiada
     * @param e CEstatistica a ser copiada
     */
    public Hipermercado(CatalogoClientes cc,CatalogoProdutos cp,Facturacao fact, GestaoFilial gf, Estatistica e) {
		this.clientes= cc;
		this.produtos = cp;	
                this.faturacao=fact;
                this.gestfilial=gf;
                this.estatistica=e;
    }

    /**
     * Construtor de copia
     * @param hiper hipermercado a ser copiado
     */
    public Hipermercado(Hipermercado hiper) {
        clientes = hiper.getClientes();
        produtos = hiper.getProdutos();
        faturacao = hiper.getFaturacao();
        gestfilial=hiper.getGestfilial();
        estatistica=hiper.getEstatistica();
       
    }

    /**
     * 
     * @return Estatistica
     */

    public Estatistica getEstatistica() {
        return estatistica;
    }
    
    /**
     * 
     * @return Facturacao
     */
    public Facturacao getFaturacao() {
        return faturacao;
    }

    /**
     * 
     * @return Catálogo de Clientes
     */
    
    public CatalogoClientes getClientes() {
        return clientes;
    }

    /**
     * 
     * @return Catálogo de Produtos
     */
    public CatalogoProdutos getProdutos() {
        return produtos;
    }
    
    /**
     * 
     * @return Gestao de Filial
     */
    public GestaoFilial getGestfilial() {
        return gestfilial;
    }

    
    
   /**
     * Atualiza faturacao
     * @param faturacao Nova faturacao
     */
    public void setFaturacao(Facturacao faturacao) {
        this.faturacao = faturacao;
    }
    
    /**
     * Atualiza catalogo de clientes
     * @param clientes Novo catalogo de clientes
     */
    public void setClientes(CatalogoClientes clientes) {
        this.clientes = clientes;
    }
    
    /**
     * Atualiza catalogo de produtos
     * @param produtos Novo catalogo de produtos
     */
    public void setProdutos(CatalogoProdutos produtos) {
        this.produtos = produtos;
    }
    
    /**
     * Atualiza gestao de filial
     * @param gestfilial Novo gestao filial
     */
    public void setGestfilial(GestaoFilial gestfilial) {
        this.gestfilial = gestfilial;
    }

    /**
     * Atualiza estatistica
     * @param estatistica Nova estatistica
     */
    public void setEstatistica(Estatistica estatistica) {
        this.estatistica = estatistica;
    }
    
    
   /**
     * Insere um novo Cliente nos módulos
     * @param cli Cliente a ser inserido
     * @throws java.lang.CloneNotSupportedException
     */
    
    public void insereCliente(Cliente cli) throws CloneNotSupportedException {
        clientes.adicionaCliente(cli.clone());
        gestfilial.adicionaClienteInicial(cli.clone());
    }

    /**
     * Insere um novo Produto nos módulos
     * @param pro Produto a ser inserido
     */
   public void insereProduto(Produto pro) {
         produtos.adicionaProduto(pro.clone());
         faturacao.adicionaProduto(pro.clone());
         gestfilial.adicionaProdutoInicial(pro.clone());
    }
    
  /**
     * Insere Venda nos módulos
     * @param v Venda a ser inserido
     * @throws java.lang.CloneNotSupportedException
     */
   public void insereVendaValida(Venda v) throws CloneNotSupportedException {
        faturacao.adicionaFaturacao(v.clone());
        gestfilial.adicionaComprasCliente(v.clone());
        gestfilial.adicionaComprasDeProduto(v.clone());
        
    }

    /**
     * Insere estatistica 
     * @param fichVendas Nome de ficheiro de vendas
     * @param clientes Numero de clientes
     * @param produtos Numero de Produtos
     * @param preco0 Numero de vendas a 0.0
     * @param errados Numero de registos errados
     */
    public void insereEstatistica(String fichVendas,int clientes, int produtos, int preco0, int errados){
        estatistica.setFicheiroVendas(fichVendas);
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
    
    /**
     * Verifica existencia de cliente
     * @param cli Cliente a verificar a existencia
     * @return True se cliente existe, false em caso contrario
     */
    
    public boolean existeCliente(Cliente cli){
    Boolean r;
        r=clientes.existeCliente(cli);
    return r;
    }
    
     /**
     * Verifica existencia de produto
     * @param pro produto a verificar a existencia
     * @return True se produto existe, false em caso contrario
     */
    public boolean existeProduto(Produto pro){
    Boolean r;
        r=produtos.existeProduto(pro);
    return r;
    }
    
     /**
     * Método de escrita para um ficheiro de Objectos
     * @param filename Nome do Ficheiro destino
     * @throws IOException Caso hajam erros 
     */
     public void guardaObj(String filename) throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(Gerevendas.getHipermercado());
            oos.flush();
        }
    }
     /**
     * Método de leitura de um ficheiro de Objectos
     * @param ficheiro Nome do Ficheiro 
     * @return  Hipermercado resultante da leitura
     * @throws IOException Caso hajam erros 
     * @throws java.lang.ClassNotFoundException 
     */
    public  Hipermercado carregaObj(String ficheiro) throws IOException, ClassNotFoundException {
        Hipermercado res;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheiro))) {
            res = (Hipermercado) ois.readObject();
        }
        return res;
    }


    
}
