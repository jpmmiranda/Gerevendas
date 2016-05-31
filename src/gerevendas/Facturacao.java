/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rui
 */
public class Facturacao implements Serializable {
    
    private Map<Produto, InfoProdutoFacturacao> facturacao;
    int[][] totalVendas;//Por mes e tipo
    double totalFaturado;
    double[][] totalFatFilial1;
    double[][] totalFatFilial2;
    double[][] totalFatFilial3;
     
    
    /*Construtores*/
     
    public Facturacao() {
        this.facturacao = new TreeMap<>(new ComparatorCodigoProduto());
        this.totalVendas = new int[12][2];
        this.totalFaturado = 0.0;
        this.totalFatFilial1 = new double[12][2];
        this.totalFatFilial2 = new double[12][2];
        this.totalFatFilial3 = new double[12][2];

    }
   
    public Facturacao(Map<Produto, InfoProdutoFacturacao> fact,int[][] tVendas,double tFaturado,double[][] tf1,double[][] tf2,double[][] tf3) throws CloneNotSupportedException {
        this.totalFaturado = tFaturado;
        this.totalVendas = tVendas;
        this.totalFatFilial1 = tf1;
        this.totalFatFilial2 = tf2;
        this.totalFatFilial3 =tf3;
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
        this.totalFatFilial1=fact.getTotalFatFilial1();
         this.totalFatFilial2=fact.getTotalFatFilial2();
         this.totalFatFilial3=fact.getTotalFatFilial3();
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

    public double getTotalFaturado() {
        return totalFaturado;
    }
    
    public double getTotalFaturadoGlobal(){
        
        return totalFaturado;
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

    public void setTotalFaturado(double totalFaturado) {
        this.totalFaturado = totalFaturado;
    }
    
    
   /* Metodos */
    
    void adicionaProduto(Produto prod){
        InfoProdutoFacturacao ipf = new InfoProdutoFacturacao();

        this.facturacao.put(prod.clone(),ipf );
    
    }
    
    public int vendasMensais(int mes){
    
        int vendas=0;
       
        vendas=totalVendas[mes][0]+totalVendas[mes][1];
         
        return vendas;
    }
    
    public double totalFacturadoMensal(int mes){
    
        double fat=0;
       
        fat=totalFatFilial1[mes][0]+totalFatFilial1[mes][1]+totalFatFilial2[mes][0]+totalFatFilial2[mes][1]+totalFatFilial3[mes][0]+totalFatFilial3[mes][1];
         
        return fat;
    }
    
    public int vendasglobais(){
    
        int i=0,j=0;
        int vendas=0;
        for(;i<12;i++){
            for(;j<2;j++){
                vendas+=totalVendas[i][j];
            }
        }
        return vendas;
    }
    
    public double totalFaturadoFilial1(int mes){
    
        double r=0.0;
        
         r=totalFatFilial1[mes][0]+totalFatFilial1[mes][1];
        
        return r;
    
    }
    
    public double totalFaturadoFilial2(int mes){
    
        double r=0.0;
        
         r=totalFatFilial2[mes][0]+totalFatFilial2[mes][1];
        
        return r;
    
    }
    
    public double totalFaturadoFilial3(int mes){
    
        double r=0.0;
        
         r=totalFatFilial3[mes][0]+totalFatFilial3[mes][1];
        
        return r;
    
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
        totalFaturado+=preco*quantidade;
        if(PouN.equals("N")){
            if(filial==1) totalFatFilial1[mes-1][0]+=preco*quantidade;
            else if(filial==2) totalFatFilial2[mes-1][0]+=preco*quantidade;
            else totalFatFilial3[mes-1][0]+=preco*quantidade;
            totalVendas[mes-1][0]++;
        }else{  
            if(filial==1) totalFatFilial1[mes-1][1]+=preco*quantidade;
            else if(filial==2) totalFatFilial2[mes-1][1]+=preco*quantidade;
            else totalFatFilial3[mes-1][1]+=preco*quantidade;
            totalVendas[mes-1][1]++;

        }
        
        
        //if(facturacao.containsKey(ven.getProduto())){
        
                ipf=this.facturacao.get(ven.getProduto());
                ipf.incrementaTotalVendidas(quantidade);  
             
           // }
    }

    @Override
    public Facturacao clone() throws CloneNotSupportedException {
        return new Facturacao(this);
    }

    private double[][] getTotalFatFilial2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double[][] getTotalFatFilial1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double[][] getTotalFatFilial3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public TreeSet<ParCliProdsComprados> listaDeXProdutos() {
         TreeSet<ParCliProdsComprados> cod=new TreeSet<>(new ComparatorProdutosEQuantidade());
       for(Produto p : facturacao.keySet()){
                InfoProdutoFacturacao ip = facturacao.get(p);
                if(ip.getTotalVendidas()!=0){
                    ParCliProdsComprados pcpc = new ParCliProdsComprados();
                    pcpc.adicionaProduto(p.getCodigo());
                    pcpc.adicionaTotal(ip.getTotalVendidas());
                    cod.add(pcpc);
                }
       
       }
        return cod;
    }

    
}