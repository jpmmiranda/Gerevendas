/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que implementa o módulo de Facturacao
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class Facturacao implements Serializable {
    
    private Map<Produto, Integer> facturacao;
    int[][] totalVendas;//Por mes e tipo
    double totalFaturado;
    double[][] totalFatFilial1;
    double[][] totalFatFilial2;
    double[][] totalFatFilial3;
     
    
    /**
     * Construtor Vazio
     */
     
    public Facturacao() {
        this.facturacao = new TreeMap<>(new ComparatorCodigoProduto());
        this.totalVendas = new int[12][2];
        this.totalFaturado = 0.0;
        this.totalFatFilial1 = new double[12][2];
        this.totalFatFilial2 = new double[12][2];
        this.totalFatFilial3 = new double[12][2];

    }
    
    /**
     * Construtor Parametrizado
     * @param fact Map a ser colocado em facturacao
     * @param tVendas Total de vendas mensais, por tipo P ou N
     * @param tFaturado Total Facturado
     * @param tf1 Total Facturado Filial 1
     * @param tf2 Total Facturado Filial 2
     * @param tf3 Total Facturado Filial 3
     * @throws java.lang.CloneNotSupportedException
     */
    public Facturacao(Map<Produto, Integer> fact,int[][] tVendas,double tFaturado,double[][] tf1,double[][] tf2,double[][] tf3) throws CloneNotSupportedException {
        this.totalFaturado = tFaturado;
        this.totalVendas = tVendas.clone();
        this.totalFatFilial1 = tf1.clone();
        this.totalFatFilial2 = tf2.clone();
        this.totalFatFilial3 =tf3.clone();
        this.facturacao = new TreeMap<>();
       
        fact.forEach( (Produto k,Integer v) ->  {
            try {
                this.facturacao.put(k.clone(), v);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Facturacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
    
    
    /**
     * Construtor de Cópia
     * @param fact Objecto a ser Copiado
     * @throws java.lang.CloneNotSupportedException
     */
    public Facturacao(Facturacao fact) throws CloneNotSupportedException {
        this.facturacao = fact.getFacturacao();
        this.totalFaturado = fact.getTotalFaturadoGlobal();
        this.totalVendas = fact.getTotalVendas();
        this.totalFatFilial1=fact.getTotalFatFilial1();
         this.totalFatFilial2=fact.getTotalFatFilial2();
         this.totalFatFilial3=fact.getTotalFatFilial3();
    }
    
    /**
     * 
     * @return Map de facturacao
     * @throws java.lang.CloneNotSupportedException
     */

    public Map<Produto, Integer> getFacturacao() throws CloneNotSupportedException {
        TreeMap<Produto, Integer> aux = new TreeMap<>();
        facturacao.forEach( (k,v) ->  {
            try {
                aux.put(k.clone(), v);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Facturacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return aux;
    }

    /**
     * 
     * @return Total de vendas
     */
    public int[][] getTotalVendas() {
        return totalVendas.clone();
    }

    
    /**
     * 
     * @return Total facturado
     */
    public double getTotalFaturadoGlobal(){
        
        return totalFaturado;
    }
    
    /**
     * Metodo que calcula os produtos não comprados
     * @return Total de produtos nao comprados
     */
    public int getTotalProdutosNaoComprados(){
        int  r=0;
        for(Integer p : facturacao.values()){
        
            if(p==0)r++;
        }
        return r;
    }
    
    /**
     * 
     * @return Total facturado na Filial 2
     */
    private double[][] getTotalFatFilial2() {
      return  this.totalFatFilial2.clone();
    }
    
    /**
     * 
     * @return Total facturado na Filial 1
     */
    private double[][] getTotalFatFilial1() {
        return  this.totalFatFilial1.clone();
    }

    /**
     * 
     * @return Total facturado na Filial 3
     */
    private double[][] getTotalFatFilial3() {
        return  this.totalFatFilial3.clone();
    }
    
    /**
     * Actualiza facturacao
     *
     * @param facturacao Map a actualizar 
     */
    
    public void setFacturacao(Map<Produto, Integer> facturacao){
         this.facturacao = new TreeMap<>(new ComparatorCodigoProduto());

           facturacao.forEach( (k,v) ->  {

                try {
                    this.facturacao.put(k.clone(), v);
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
                }
               });
    }

    /**
     * Actualiza total de vendas
     *
     * @param totalVendas Vendas a actualizar
     */
    public void setTotalVendas(int[][] totalVendas) {
        this.totalVendas = totalVendas.clone();
    }

    /**
     * Actualiza total facturado
     *
     * @param totalFaturado Valor a actualizar
     */
    public void setTotalFaturado(double totalFaturado) {
        this.totalFaturado = totalFaturado;
    }
    
    
   /**
     * Adiciona produto 
     * @param prod Produto a ser inserido
     * @throws java.lang.CloneNotSupportedException
     */
    
   public  void adicionaProduto(Produto prod) throws CloneNotSupportedException{

        this.facturacao.put(prod.clone(),0 );
    
    }
    
    /**
     * Calcula vendas mensais 
     * @param mes Mês a ser calculadas as vendas
     * @return Total de vendas mensais
     */
    public int vendasMensais(int mes){
    
        int vendas;
       
        vendas=totalVendas[mes-1][0]+totalVendas[mes-1][1];
         
        return vendas;
    }
    
    /**
     * Calcula total facturado mensal
     * @param mes Mês a ser calculado o total facturado
     * @return Total Facturado mensal
     */
    public double totalFacturadoMensal(int mes){
    
        double fat;
        fat=totalFatFilial1[mes][0]+totalFatFilial1[mes][1]+totalFatFilial2[mes][0]+totalFatFilial2[mes][1]+totalFatFilial3[mes][0]+totalFatFilial3[mes][1];
         
        return fat;
    }
    
     /**
     * Calcula total facturado mensal na filial 1
     * @param mes Mês a ser calculado o total facturado
     * @return Total Facturado mensal na filial 1
     */
    public double totalFaturadoFilial1(int mes){
    
        double r;
        
         r=totalFatFilial1[mes][0]+totalFatFilial1[mes][1];
        
        return r;
    
    }
    
    /**
     * Calcula total facturado mensal na filial 2
     * @param mes Mês a ser calculado o total facturado
     * @return Total Facturado mensal na filial 2
     */
    public double totalFaturadoFilial2(int mes){
    
        double r;
        
         r=totalFatFilial2[mes][0]+totalFatFilial2[mes][1];
        
        return r;
    
    }
    
    /**
     * Calcula total facturado mensal na filial 3
     * @param mes Mês a ser calculado o total facturado
     * @return Total Facturado mensal na filial 3
     */
    public double totalFaturadoFilial3(int mes){
    
        double r;
        
         r=totalFatFilial3[mes][0]+totalFatFilial3[mes][1];
        
        return r;
    
    }
    
    /**
     * Método que devolve X produtos vendidos
     * @param X Limite de produtos a retornar
     * @return Lista com produtos vendidos.
     * @throws java.lang.CloneNotSupportedException
     */
    
    public ArrayList<ParCliProdsComprados> listaDeXProdutos(int X) throws CloneNotSupportedException {
         TreeSet<ParCliProdsComprados> cod=new TreeSet<>(new ComparatorProdutosEQuantidade());
          ArrayList<ParCliProdsComprados> prodFinal=new ArrayList<>();
         ArrayList<ParCliProdsComprados> prodAux=new ArrayList<>();
         facturacao.forEach( (k,v) ->  {
            
             if(v!=0){
                    ParCliProdsComprados pcpc = new ParCliProdsComprados();
                    pcpc.adicionaProduto(k.getCodigo());
                    pcpc.adicionaTotal(v);
                 try {
                     cod.add(pcpc.clone());
                 } catch (CloneNotSupportedException ex) {
                     Logger.getLogger(Facturacao.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }
           });
         
      cod.forEach( (v) ->  {  
             try {
                 prodAux.add(v.clone());
             } catch (CloneNotSupportedException ex) {
                 Logger.getLogger(Facturacao.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
        
        for(int i=0;i<X && i<prodAux.size();i++)
            prodFinal.add(prodAux.get(i).clone());
        
        return prodFinal;
    }    

    
    /**
     * Adiciona dados acerca de uma venda
     * @param ven Venda de onde serão recolhidos os dados
     * @throws java.lang.CloneNotSupportedException
     */
    public void adicionaFaturacao(Venda ven) throws CloneNotSupportedException {
        String PouN;
        int mes,quantidade,filial;
        double preco ;
        
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
        
               int v=this.facturacao.get(ven.getProduto());
               v+=quantidade;
               this.facturacao.put(ven.getProduto(),v);
             
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
        final Facturacao other = (Facturacao) obj;
        if (!Objects.equals(this.facturacao, other.facturacao)) {
            return false;
        }
        if (!Arrays.deepEquals(this.totalVendas, other.totalVendas)) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalFaturado) != Double.doubleToLongBits(other.totalFaturado)) {
            return false;
        }
        if (!Arrays.deepEquals(this.totalFatFilial1, other.totalFatFilial1)) {
            return false;
        }
        if (!Arrays.deepEquals(this.totalFatFilial2, other.totalFatFilial2)) {
            return false;
        }
        if (!Arrays.deepEquals(this.totalFatFilial3, other.totalFatFilial3)) {
            return false;
        }
        return true;
    }

    
    /**
     *
     * @return Novo Objecto como cópia da instância Actual
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Facturacao clone() throws CloneNotSupportedException {
        return new Facturacao(this);
    }


}