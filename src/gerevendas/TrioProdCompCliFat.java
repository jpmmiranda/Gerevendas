/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Classe TrioProdCompCliFa
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class TrioProdCompCliFat implements Serializable{
    
    private int Cdistintos[],Compras[];
    private double faturacao[];

    /**
     * Construtor Vazio
     */
    public TrioProdCompCliFat() {
      
        this.Compras = new int[12];
        this.faturacao = new double[12];
        this.Cdistintos= new int[12];
    }

    
   /**
     * Construtor de Cópia
     * @param tcpc Objecto a ser Copiado
     */
    public TrioProdCompCliFat(TrioProdCompCliFat tcpc) {
         
        this.Compras = tcpc.getCompras();
        this.faturacao = tcpc.getFaturacao();
        this.Cdistintos = tcpc.getCDistintos();
    }

    /**
     *@return compras
     */
    public int[] getCompras() {
        return this.Compras.clone();
    }

  /**
     *@return Clientes distintos
     */
    
    public int[] getCDistintos() {
        return this.Cdistintos.clone();
    }

    /**
     *@return Faturado
     */
    public double[] getFaturacao() {
        return this.faturacao.clone();
    }
    
    /**
     * Adiciona clientes distintos num dado mes
     * 
     * @param qtd Quantidade a adicionar
     * @param mes Mes a ser adicionado
    */
    public void adicionaClientesDistintos(int qtd, int mes) {
        this.Cdistintos[mes - 1] = qtd;
    }

    /**
     * Adiciona faturacao  num dado mes
     * 
     * @param fat Valor a adicionar
     * @param mes Mes a ser adicionado
    */
    public void adicionaFaturacao(double fat, int mes) {
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
    public TrioProdCompCliFat clone() throws CloneNotSupportedException {
        return new TrioProdCompCliFat(this);
    }
    
    /**
     * Teste de igualdade da instância actual com o parâmetro 
     * @param o Objecto a ser testado
     * @return Igualdade entre a instância actual e o parâmetro obj
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            TrioProdCompCliFat t = (TrioProdCompCliFat) o;
            return  this.faturacao.equals(t.getFaturacao())  && this.Compras.equals(t.getCompras()) && this.Cdistintos.equals(t.getCDistintos());
        }

    }

    /**
     * Método hashcode
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Arrays.hashCode(this.Cdistintos);
        hash = 31 * hash + Arrays.hashCode(this.Compras);
        hash = 31 * hash + Arrays.hashCode(this.faturacao);
        return hash;
    }

    /**
     * 
     * @return String resultante
     */

   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Clientes Distintos \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.Cdistintos[i]).append(" \n");
        }
        sb.append("\n");
        sb.append("Numero de Vezes Comprado \n");
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
