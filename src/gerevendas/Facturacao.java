/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
       
        fact.forEach( (k,v) ->  {
            try {
                this.facturacao.put(k.clone(), v.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Facturacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
    
    public Facturacao(Facturacao fact) throws CloneNotSupportedException {
        this.facturacao = fact.getFacturacao();
        this.totalFaturado = fact.getTotalFaturado();
        this.totalVendas = fact.getTotalVendas();
    }
    
    /*Getter*/

    public Map<Produto, InfoProdutoFacturacao> getFacturacao() throws CloneNotSupportedException {
        TreeMap<Produto, InfoProdutoFacturacao> aux = new TreeMap<>();
        facturacao.forEach( (k,v) ->  {
            try {
                aux.put(k.clone(), v.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Facturacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return aux;
    }

    public int[][] getTotalVendas() {
        return totalVendas.clone();
    }

    public double[][] getTotalFaturado() {
        return totalFaturado.clone();
    }
    
    public double getTotalFaturadoGlobal(){
        double r=0.0;
        int j,i;
        for(i=0;i<12;i++)
            for(j=0;j<2;j++)
                r+=totalFaturado[i][j];
        return r;
    }
    
    public int getTotalProdutosNaoComprados(){
        int  r=0;
        for(InfoProdutoFacturacao p : facturacao.values()){
        
            if(p.getTotalVendidas()==0)r++;
        }
        return r;
    }
    /* Setter*/
    
    
    public void setFacturacao(Map<Produto, InfoProdutoFacturacao> facturacao){
        this.facturacao = facturacao;
    }

    public void setTotalVendas(int[][] totalVendas) {
        this.totalVendas = totalVendas.clone();
    }

    public void setTotalFaturado(double[][] totalFaturado) {
        this.totalFaturado = totalFaturado.clone();
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
        if(PouN.equals("N")){
            totalVendas[mes-1][0]++;
            totalFaturado[mes-1][0]+=preco*quantidade;
        }else{
            totalVendas[mes-1][1]++;
            totalFaturado[mes-1][1]+=preco*quantidade;

        }
        
        
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