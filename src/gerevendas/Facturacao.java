/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Rui
 */
public class Facturacao {
    
    private Map<Produto, InfoProdutoFacturacao> facturacao;
    int[][] totalVendas;
    double[][] totalFaturado;
          
    
    /*Construtores*/
     
    public Facturacao() {
        this.facturacao = new TreeMap<>(new ComparatorCodigoProduto());
        this.totalVendas = new int[12][2];
        this.totalFaturado = new double[12][2];

    }
   
    public Facturacao(Map<Produto, InfoProdutoFacturacao> fact,int[][] tVendas,double[][] tFaturado) throws CloneNotSupportedException {
        this.totalFaturado = tFaturado;
        this.totalVendas = tVendas;
        this.facturacao = new TreeMap<>();
        for (Map.Entry<Produto, InfoProdutoFacturacao> ipf : fact.entrySet()) {
            this.facturacao.put(ipf.getKey().clone(), ipf.getValue().clone());
        }
    }
    
    public Facturacao(Facturacao fact) throws CloneNotSupportedException {
        this.facturacao = fact.getFacturacao();
        this.totalFaturado = fact.getTotalFaturado();
        this.totalVendas = fact.getTotalVendas();
    }
    
    /*Getter*/

    public Map<Produto, InfoProdutoFacturacao> getFacturacao() throws CloneNotSupportedException {
        TreeMap<Produto, InfoProdutoFacturacao> aux = new TreeMap<>();

        for (Map.Entry<Produto, InfoProdutoFacturacao> ipf : this.facturacao.entrySet()) {
            aux.put(ipf.getKey().clone(), ipf.getValue().clone());
        }
        return aux;
    }

    public int[][] getTotalVendas() {
        return totalVendas;
    }

    public double[][] getTotalFaturado() {
        return totalFaturado;
    }

    
    /* Setter*/
    
    
    public void setFacturacao(Map<Produto, InfoProdutoFacturacao> facturacao){
        this.facturacao = facturacao;
    }

    public void setTotalVendas(int[][] totalVendas) {
        this.totalVendas = totalVendas;
    }

    public void setTotalFaturado(double[][] totalFaturado) {
        this.totalFaturado = totalFaturado;
    }
    
    
   /* Metodos */
    
    void adicionaProduto(Produto prod){
        InfoProdutoFacturacao ipf = new InfoProdutoFacturacao();

        this.facturacao.put(prod.clone(),ipf );
    
    }
    
    
    void adicionaFaturacao(Venda ven) throws CloneNotSupportedException {
        String PouN;
        int mes,quantidade,filial;
        double preco ;
        
        InfoProdutoFacturacao ipf;
        quantidade=ven.getQuantidade();
        PouN=ven.getPouN();
        mes=ven.getMes();
        filial=ven.getFilial();
        preco=ven.getPreco();
        if(facturacao.containsKey(ven.getProduto())){
        
                ipf=this.facturacao.get(ven.getProduto());
                ipf.incrementaTotalVendidas(quantidade);
                ipf.incrementaUnidadesVendidas(PouN, mes, quantidade);
                ipf.incrementaFaturado( PouN, mes, preco);
                ipf.incrementaTotalFaturado( PouN, mes, preco,quantidade);
                ipf.incrementaTotaisFilial( PouN, mes, preco,quantidade, filial);
             
            }
    }

    @Override
    public Facturacao clone() throws CloneNotSupportedException {
        return new Facturacao(this);
    }

    
}