package gerevendas;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe TrioCliComProFat
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class TrioCliComProFat implements Serializable {
    
    private int Pdistintos[],Compras[];
    private double faturacao[];

    /**
     * Construtor Vazio
     */
    public TrioCliComProFat() {
       this.Pdistintos = new int[12];
        this.Compras = new int[12];
        this.faturacao = new double[12];
    }

    /**
     * Construtor de Cópia
     * @param tcpc Objecto a ser Copiado
     */
   
    public TrioCliComProFat(TrioCliComProFat tcpc) {
         this.Pdistintos = tcpc.getPDistintos();
        this.Compras = tcpc.getCompras();
        this.faturacao = tcpc.getFaturacao();
    }

    /**
     *@return compras
     */
    public int[] getCompras() {
        return this.Compras.clone();
    }
    
    /**
     *@return Produtos distintos
     */
    public int[] getPDistintos() {
        return this.Pdistintos.clone();
    }
    /**
     *@return Faturado
     */
    public double[] getFaturacao() {
        return this.faturacao.clone();
    }
    
    /**
     * Adiciona produtos distintos num dado mes
     * 
     * @param qtd Quantidade a adicionar
     * @param mes Mes a ser adicionado
    */
    public void adicionaDistintos(int qtd, int mes) {
        this.Pdistintos[mes - 1] = qtd;
    }
    
    /**
     * Adiciona faturacao  num dado mes
     * 
     * @param fat Valor a adicionar
     * @param mes Mes a ser adicionado
    */
    public void adicionaFaturacao(float fat, int mes) {
        this.faturacao[mes - 1] = fat;
    }
    
    /**
     * Adiciona  compras num dado mes
     * 
     * @param total Compras a adicionar
     * @param mes Mes a ser adicionado
    */
    public void adicionaCompras(int total, int mes) {
        this.Compras[mes - 1] = total;
    }

    
    /**
     *
     * @return Novo Objecto como cópia da instância Actual
     * @throws java.lang.CloneNotSupportedException
     */
    
    @Override
    public TrioCliComProFat clone() throws CloneNotSupportedException {
        return new TrioCliComProFat(this);
    }
    
    
    /**
     * Teste de igualdade da instância actual com o parâmetro 
     * @param o Objecto a ser testado
     * @return Igualdade entre a instância actual e o parâmetro obj
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            TrioCliComProFat t = (TrioCliComProFat) o;
            return  this.Pdistintos.equals(t.getPDistintos()) && this.faturacao.equals(t.getFaturacao())  && this.Compras.equals(t.getCompras()) ;   }

    }

    
    /**
     * 
     * @return String resultante
     */
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

       
        sb.append("Produtos Distintos \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.Pdistintos[i]).append(" \n");
        }
        
        sb.append("\n");
        sb.append("Numero de Compras \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.Compras[i]).append("\n");
        }
        sb.append("\n");
        sb.append("Faturação  \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.faturacao[i]).append("€ \n ");
        }
        return sb.toString();
    }

    

}
