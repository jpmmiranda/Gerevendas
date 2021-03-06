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
import java.util.Objects;

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
     * @throws java.lang.CloneNotSupportedException
     */
    public Hipermercado(CatalogoClientes cc,CatalogoProdutos cp,Facturacao fact, GestaoFilial gf, Estatistica e) throws CloneNotSupportedException {
		this.clientes= cc.clone();
		this.produtos = cp.clone();	
                this.faturacao=fact.clone();
                this.gestfilial=gf.clone();
                this.estatistica=e.clone();
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
     * @throws java.lang.CloneNotSupportedException
     */
   public void insereProduto(Produto pro) throws CloneNotSupportedException {
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
     * @param preco0 Numero de vendas a 0.0
     * @param errados Numero de registos errados
     */
    public void insereEstatistica(String fichVendas, int preco0, int errados){
        
        int clientesCompradores=gestfilial.getTotalDeClientesCompradores();
        int produtosDistintosComprados=gestfilial.getTotalProdutosDiferentesComprados();
        int totalClientes=clientes.totalClientes();
        int totalProdutos=produtos.totalProdutos();
        
        estatistica.setFicheiroVendas(fichVendas);
        estatistica.setTotalRegistosErrados(errados);
        estatistica.setTotalClientes(totalClientes);
        estatistica.setTotalProdutos(totalProdutos);
        estatistica.setTotalComprasZero(preco0);
        estatistica.setTotalFacturacao(faturacao.getTotalFaturadoGlobal());
        estatistica.setTotalNaoComprados(faturacao.getTotalProdutosNaoComprados());
        estatistica.setTotalClientesCompradores(clientesCompradores);
        estatistica.setTotalClientesNaoCompradores(totalClientes-clientesCompradores);
        estatistica.setTotalProdutosDiferentes(produtosDistintosComprados);
        estatistica.setTotalNaoComprados(totalProdutos-produtosDistintosComprados);

        int i;
        for(i=0;i<12;i++){
            estatistica.setTotalComprasMes(i,faturacao.vendasMensais(i+1));
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
     * @throws java.lang.CloneNotSupportedException
     */
    
    public boolean existeCliente(Cliente cli) throws CloneNotSupportedException{
    Boolean r;
        r=clientes.existeCliente(cli.clone());
    return r;
    }
    
     /**
     * Verifica existencia de produto
     * @param pro produto a verificar a existencia
     * @return True se produto existe, false em caso contrario
     * @throws java.lang.CloneNotSupportedException
     */
    public boolean existeProduto(Produto pro) throws CloneNotSupportedException{
    Boolean r;
        r=produtos.existeProduto(pro.clone());
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

    

    /**
     * Método hashcode
     * @return valor de hash
     */
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.clientes);
        hash = 73 * hash + Objects.hashCode(this.produtos);
        hash = 73 * hash + Objects.hashCode(this.faturacao);
        hash = 73 * hash + Objects.hashCode(this.gestfilial);
        hash = 73 * hash + Objects.hashCode(this.estatistica);
        return hash;
    }
    

    /**
     * Teste de igualdade da instância actual com o parâmetro 
     * @param obj Objecto a ser testado
     * @return Igualdade entre a instância actual e o parâmetro obj
     */
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
                && this.produtos.equals(other.produtos)
                && this.faturacao.equals(other.faturacao)
                && this.gestfilial.equals(other.gestfilial)
                && this.estatistica.equals(other.estatistica);
    }
}
